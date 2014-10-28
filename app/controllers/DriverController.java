package controllers;

import is.ru.honn.ruber.domain.Driver;
import is.ru.honn.ruber.domain.DriverDTO;
import is.ru.honn.ruber.domain.Review;
import is.ru.honn.ruber.drivers.service.DriverService;
import play.data.Form;
import play.mvc.*;
import views.html.*;
import java.util.List;
import static play.data.Form.form;
import static play.libs.Json.toJson;
import static play.mvc.Results.ok;

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

        return ok(details.render(driver, CommentForm, comments, getAverage(comments)));
    }

	public static Result getDriverById(int driverId){
		DriverService service = (DriverService)ctx.getBean("driverService");
		Driver returnValue = service.getDriver(driverId);

		return ok(toJson(returnValue));
	}

    /**
     * adds a new review for driver with a specific driverId
     * @param driverId
     * Id of the driver
     * @return
     * String title, Driver driver, Form<Review> commentForm, List<Review> reviews, int average
     */
    public static Result rateDriver(int driverId){

        Form<Review> comment = CommentForm.bindFromRequest();
        DriverService driverService = (DriverService) ctx.getBean("driverService");

        int myScore = Integer.parseInt(comment.field("score").value());

        if (comment.hasErrors())
        {
            DriverDTO driver = driverService.getDriverDTO(driverId);
            List<Review> comments = driverService.getReviews(driverId);

            return badRequest(details.render(driver, comment, comments, getAverage(comments)));
        }

        System.out.println(comment.field("content").value());
        //TODO Fetch the right userId instead of stubbing it with "1"
        driverService.rateDriver(1,driverId,comment.field("content").value(),myScore);

        return details(driverId);
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