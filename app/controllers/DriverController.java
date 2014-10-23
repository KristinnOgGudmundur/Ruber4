package controllers;

import is.ru.honn.ruber.domain.Driver;
import is.ru.honn.ruber.drivers.service.DriverService;
import play.mvc.*;
import views.html.*;
import java.util.List;

public class DriverController extends AbstractDriverController {

    public static Result getDrivers(){
        DriverService service = (DriverService) ctx.getBean("driverService");

        List<Driver> MyDrivers;
        MyDrivers = service.getDrivers();

        return ok(drivers.render("Home", MyDrivers));
    }
}