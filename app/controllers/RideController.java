package controllers;

import is.ru.honn.ruber.domain.Trip;
import is.ru.honn.ruber.process.TripImportProcess;
import is.ru.honn.ruber.rides.RidesService;
import is.ruframework.process.RuProcessRunner;
import play.data.*;
import play.mvc.*;
import views.html.trips;

import java.util.List;

import static play.libs.Json.toJson;
import static play.mvc.Results.ok;

/**
 * Created by Gvendur Stefáns on 27.10.2014.
 */
public class RideController extends AbstractRideController {
	public static Result getTrips(int userId){
		TripImportProcess theProcess = (TripImportProcess)importCtx.getBean("importProcess");
		RuProcessRunner importProcessRunner = new RuProcessRunner(theProcess);
		importProcessRunner.run();

		RidesService theService = theProcess.getRideService();
		List<Trip> returnValue = theService.getTrip(userId);

		return ok(toJson(returnValue));
	}
}
