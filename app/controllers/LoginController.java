package controllers;


import is.ru.honn.ruber.domain.User;
import is.ru.honn.ruber.users.service.UserNotFoundException;
import is.ru.honn.ruber.users.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import play.data.*;
import play.mvc.*;

import static play.data.Form.form;

import views.html.index;
import views.html.login;

public class LoginController extends UserController
{
  final static Form<User> loginForm = form(User.class);

  public static Result blank()
  {
    return ok(login.render(loginForm));
  }

  public static Result login()
  {
    Form<User> filledForm = loginForm.bindFromRequest();

    UserService service = (UserService) ctx.getBean("userService");

    try
    {
      User user = service.getUser(filledForm.field("username").value());
      if (!user.getPassword().equals(filledForm.field("password").value()))
      {
        // Let's throw this exception here to use the same logic for
        // unsuccessful login (both username not found and incorrect
        // password.
        throw new UserNotFoundException();
      }

      session("username", user.getUsername());
      session("displayName", user.getFirstName() + " " + user.getLastName());

    }
    catch (UserNotFoundException unfe)
    {
      filledForm.reject("password", "User not found or incorrect password entered.");
      return badRequest(login.render(filledForm));
    }

    if (session().get("username") != null)
    {
      return ok(index.render("Home"));
    }
    else
      return redirect("/");
  }

  public static Result logout()
  {
    session().clear();
    return redirect("/");
  }
}
