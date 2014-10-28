package controllers;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import play.mvc.Controller;
/**
 * All controller classes that will use the user service will need to extend this controller
 */
public abstract class AbstractUserController extends Controller
{
	protected static ApplicationContext ctx = new FileSystemXmlApplicationContext("/conf/UserService.xml");
}
