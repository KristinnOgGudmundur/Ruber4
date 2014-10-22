package controllers;

import is.ru.honn.ruber.process.TripImportProcess;
import is.ruframework.process.RuProcessRunner;
import play.*;
import play.mvc.*;

import views.html.*;
import views.html.index;

public class Application extends Controller
{
	public static Result index()
	{
		//RuProcessRunner importProcessRunner = new RuProcessRunner("conf/process.xml");
		
		RuProcessRunner importProcessRunner = new RuProcessRunner(new TripImportProcess());
		//importProcessRunner.run();
		return ok(index.render("Welcome"));
	}
}
