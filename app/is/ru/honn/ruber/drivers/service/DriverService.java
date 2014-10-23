package is.ru.honn.ruber.drivers.service;

import is.ru.honn.ruber.domain.Driver;
import is.ru.honn.ruber.domain.History;
import is.ru.honn.ruber.domain.Review;

import java.util.List;

/**
 * Created by Gvendur Stefáns on 21.10.2014.
 */
public interface DriverService {
    public List<Driver> getDrivers();
    public Driver getDriver(int driverID);
    public History getHistory(int driverID);
    public void rateDriver(int driverID, Review review);
}
