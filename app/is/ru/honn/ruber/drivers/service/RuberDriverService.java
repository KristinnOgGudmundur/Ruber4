package is.ru.honn.ruber.drivers.service;

import is.ru.honn.ruber.domain.Driver;
import is.ru.honn.ruber.domain.History;
import is.ru.honn.ruber.domain.Review;
import is.ru.honn.ruber.drivers.data.DriverData.DriverDataGateway;
import is.ru.honn.ruber.drivers.data.ReviewData.ReviewDataGateway;
import is.ru.honn.ruber.drivers.service.Exceptions.DriverNotFoundException;
import is.ru.honn.ruber.drivers.service.Exceptions.ReviewExistsException;
import is.ru.honn.ruber.drivers.service.Exceptions.ReviewNotFoundException;

import java.util.List;

public class RuberDriverService implements DriverService {

    private DriverDataGateway driverDataGateway;

    private ReviewDataGateway reviewDataGateway;

    public RuberDriverService(DriverDataGateway driverDataGateway, ReviewDataGateway reviewDataGateway){
        this.driverDataGateway = driverDataGateway;
        this.reviewDataGateway = reviewDataGateway;
    }

    @Override
    public List<Driver> getDrivers() throws DriverNotFoundException {

        List<Driver> drivers;
        drivers = driverDataGateway.getDrivers();

        if (drivers == null)
        {
            throw new DriverNotFoundException("No Drivers Found");
        }
        return drivers;
    }

    @Override
    public Driver getDriver(int driverId) throws DriverNotFoundException{

        Driver driver = driverDataGateway.getDriverById(driverId);

        if(driver == null)
        {
            throw new DriverNotFoundException("Driver Not Found with id: " + driverId);
        }
        return driver;
    }

    @Override
    public Driver getDriver(String name) throws DriverNotFoundException{

        Driver driver = driverDataGateway.getDriverByName(name);

        if(driver == null)
        {
            throw new DriverNotFoundException("Driver Not Found with name: " + name);
        }
        return driver;
    }

    @Override
    public List<Review> getReviews(int driverId) throws ReviewNotFoundException {

        List<Review> myReviews = reviewDataGateway.getReviews(driverId);

        if(myReviews == null)
        {
            throw new ReviewNotFoundException("No Reviews Found");
        }

        return myReviews;
    }

    @Override
    public Review rateDriver(int userId, int driverId, String content, int score) throws ReviewExistsException {
        Review review = new Review(userId, driverId, content, score);
        int id = reviewDataGateway.addReview(review);
        review.setId(id);
        return review;

    }

    @Override
    public History getHistory(int driverID) {
        return null;
    }
}
