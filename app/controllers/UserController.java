package controllers;

import is.ru.honn.ruber.domain.Trip;
import is.ru.honn.ruber.domain.TripStatus;
import is.ruframework.http.SimpleHttpRequest;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import play.mvc.Result;
import scala.util.parsing.json.JSON;
import views.html.trips;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gvendur Stefáns on 28.10.2014.
 */
public class UserController extends AbstractUserController {
	public static Result getTrips(int userId){
		SimpleHttpRequest jsonRequest = new SimpleHttpRequest();
		JSONArray theArray = new JSONArray();
		try {
			String jsonString = jsonRequest.sendGetRequest("http://localhost:9000/api/ride/" + userId);
			System.out.println(jsonString);
			JSONParser jsonParser = new JSONParser();
			theArray = (JSONArray)jsonParser.parse(jsonString);
		}
		catch(Exception e){
			System.out.println("ERROR: " + e.getMessage());
		}

		System.out.println(theArray);

		List<Trip> returnValue = new ArrayList<Trip>();

		for(Object obj : theArray){
			JSONObject o = (JSONObject)obj;
			Trip trip = new Trip();

			trip.setId(Integer.parseInt(o.get("id").toString()));
			trip.setProductId(Integer.parseInt(o.get("productId").toString()));
			trip.setStatus(TripStatus.COMPLETED);
			trip.setDistance((Double)o.get("distance"));
			trip.setRequestTime(Integer.parseInt(o.get("requestTime").toString()));
			trip.setStartTime(Integer.parseInt(o.get("startTime").toString()));
			trip.setEndTime(Integer.parseInt(o.get("endTime").toString()));

			returnValue.add(trip);
		}
		return ok(trips.render("Home", returnValue));
	}
}
