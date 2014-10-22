package controllers;

import is.ru.honn.ruber.domain.Trip;
import is.ru.honn.ruber.process.TripImportProcess;
import is.ruframework.process.RuProcessRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import play.*;
import play.mvc.*;

import views.html.*;
import views.html.index;

public class Application extends Controller
{
	protected static ApplicationContext ctx = new FileSystemXmlApplicationContext("/conf/ImportProcess.xml");

	public static Result index()
	{
		TripImportProcess theProcess = (TripImportProcess)ctx.getBean("importProcess");
		RuProcessRunner importProcessRunner = new RuProcessRunner(theProcess);
		//importProcessRunner.run();
		return ok(index.render("Welcome"));
	}
}
