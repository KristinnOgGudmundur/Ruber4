package is.ru.honn.ruber.drivers.service;

import is.ru.honn.ruber.domain.Driver;
import is.ru.honn.ruber.domain.History;
import is.ru.honn.ruber.domain.Review;
import is.ru.honn.ruber.drivers.data.DriverDataGateway;
import is.ru.honn.ruber.users.service.UserNotFoundException;
import java.util.List;

public class RuberDriverService implements DriverService {

    private DriverDataGateway driverDataGateway;

    public RuberDriverService(DriverDataGateway driverDataGateway){
        this.driverDataGateway = driverDataGateway;
    }

    @Override
    public List<Driver> getDrivers() {

        List<Driver> drivers;
        drivers = driverDataGateway.getDrivers();

        if (drivers == null)
        {
            throw new UserNotFoundException("No Drivers Found");
        }
        return drivers;
    }

    @Override
    public Driver getDriver(int driverID) {

        Driver driver = driverDataGateway.getDriverById(driverID);

        if(driver == null)
        {
            throw new UserNotFoundException("Driver Not Found");
        }
        return driver;
    }

    @Override
    public History getHistory(int driverID) {
        return null;
    }

    @Override
    public void rateDriver(int driverID, Review review) {

    }
}
