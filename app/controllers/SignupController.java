package controllers;


import is.ru.honn.ruber.domain.UserRegistration;
import is.ru.honn.ruber.users.service.UserNotFoundException;
import is.ru.honn.ruber.users.service.UserService;
import play.mvc.*;
import play.data.*;

import views.html.signup;
import views.html.summary;

import static play.data.Form.*;


public class SignupController extends UserController
{
  final static Form<UserRegistration> signupForm = form(UserRegistration.class);

  public static Result blank()
  {
    return ok(signup.render(signupForm));
  }

  public static Result signup()
  {
    Form<UserRegistration> filledForm = signupForm.bindFromRequest();

    UserService service = (UserService) ctx.getBean("userService");

    if (!"true".equals(filledForm.field("accept").value()))
    {
      filledForm.reject("accept", "You must accept the terms and conditions");
    }

    try
    {
      service.getUser(filledForm.field("username").value());
      filledForm.reject("username", "Username already exists");
    }
    catch (UserNotFoundException ex)
    {
    }

    if (filledForm.field("username").value().length() < 4)
    {
      filledForm.reject("username", "Display Name must be at least 4 characters");
    }

    if (!filledForm.field("password").value().equals(filledForm.field("repeatPassword").value()))
    {
      filledForm.reject("repeatPassword", "The passwords you entered don't match");
    }

    if (filledForm.field("password").value().length() < 6)
    {
      filledForm.reject("password", "The password is too short");
    }

    if (filledForm.hasErrors())
    {
      return badRequest(signup.render(filledForm));
    }
    else
    {
      UserRegistration created = filledForm.get();
      service.userSignup(created.getUsername(),
                         created.getFirstName(),
                         created.getLastName(),
                         created.getPassword(),
                         created.getEmail(),
                         created.getRegistered());
      return ok(summary.render(created));
    }
  }
}
