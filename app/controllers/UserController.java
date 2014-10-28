package controllers;

import com.fasterxml.jackson.databind.node.ObjectNode;
import is.ru.honn.ruber.domain.User;
import is.ru.honn.ruber.users.service.UserService;
import play.api.libs.json.JsObject;
import play.libs.Json;
import play.mvc.*;
import play.data.*;

public class UserController extends AbstractUserController{

    public static Result getUserByUserName(String userName)
    {
        UserService service = (UserService) ctx.getBean("userService");
        ObjectNode result = Json.newObject();
        User user = service.getUser(userName);
        result.put("id", user.getId());
        result.put("userName", user.getUsername());
        result.put("firstName", user.getFirstName());
        result.put("lastName", user.getLastName());
        result.put("registered", user.getRegistered().toString());

        return ok(result.toString());
    }

}
