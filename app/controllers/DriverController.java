package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import is.ru.honn.ruber.domain.Driver;
import is.ru.honn.ruber.domain.DriverDTO;
import is.ru.honn.ruber.domain.Review;
import is.ru.honn.ruber.drivers.service.DriverService;
import play.libs.Json;
import play.mvc.Result;
import play.data.Form;
import views.html.*;
import org.json.simple.*;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import static play.data.Form.form;
import static play.libs.Json.toJson;

public class DriverController extends AbstractDriverController {

    final static Form<Review> CommentForm = form(Review.class);

    /**
     * Fetches all drivers from database
     * @return
     * String title, List<Driver>
     */
    public static Result getDrivers(){

        DriverService service = (DriverService) ctx.getBean("driverService");
        List<Driver> MyDrivers = service.getDrivers();
        return ok(drivers.render("Home", MyDrivers));
    }

    public static Result getReviews(int driverId)
    {
        DriverService service = (DriverService) ctx.getBean("driverService");
        List<Review> reviews = service.getReviews(driverId);

        JSONObject returnJson = new JSONObject();
        JSONArray jsonArray = new JSONArray();

        for(Review r : reviews)
        {
            //use HashMap so the order of objects stays the same
            Map hashMap = new LinkedHashMap();

            hashMap.put("content", r.getContent());
            hashMap.put("score", r.getScore());

            //add the HashMap to the JsonArray
            jsonArray.add(hashMap);
        }

        //add the JsonArray to the JsonObject "prices"
        returnJson.put("reviews", jsonArray);
        return ok(returnJson.toString());
    }

    /**
     * Fetches driver & Reviews from database
     * @param driverId
     * Id of the driver
     * @return
     * String title, Driver driver, Form<Review> commentForm, List<Review> reviews, int average
     */
    public static Result details(int driverId){

        DriverService service = (DriverService) ctx.getBean("driverService");

        DriverDTO driver = service.getDriverDTO(driverId);
        List<Review> comments = service.getReviews(driverId);

        return ok(details.render(driver, CommentForm, getAverage(comments)));
    }

	public static Result getDriverById(int driverId){
		DriverService service = (DriverService)ctx.getBean("driverService");
		Driver returnValue = service.getDriver(driverId);

		return ok(toJson(returnValue));
	}

    /**
     * adds a new review for driver with a specific driverId
     * Id of the driver
     * @return
     * String title, Driver driver, Form<Review> commentForm, List<Review> reviews, int average
     */
    public static Result rateDriver(){

        JsonNode json = request().body().asJson();
        DriverService driverService = (DriverService) ctx.getBean("driverService");

        int myScore = json.findPath("score").asInt();
        int userId = json.findPath("userId").asInt();
        String content = json.findPath("content").asText();
        String driverName = json.findPath("driverName").asText();
        int driverId = driverService.getDriver(driverName).getId();

        driverService.rateDriver(userId,driverId,content,myScore);

        ObjectNode result = Json.newObject();
        result.put("driverId", driverId);

        return ok(result.toString());
    }

    /**
     * a helper function to calculate the average rating from a list of reviews, and rounds the number off
     * @param reviews
     * List of reviews to be inspected
     * @return
     * double average
     */
    private static double getAverage(List<Review> reviews)
    {
        double sum = 0;

        for(Review r : reviews)
        {
            sum += r.getScore();
        }

        double average = sum / reviews.size();

        return Math.round(average*100)/100.0d;
    }
}