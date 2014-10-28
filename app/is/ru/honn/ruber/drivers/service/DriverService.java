package is.ru.honn.ruber.drivers.service;

import is.ru.honn.ruber.domain.Driver;
import is.ru.honn.ruber.domain.DriverDTO;
import is.ru.honn.ruber.domain.History;
import is.ru.honn.ruber.domain.Review;
import is.ru.honn.ruber.drivers.service.Exceptions.DriverNotFoundException;
import is.ru.honn.ruber.drivers.service.Exceptions.ReviewExistsException;
import is.ru.honn.ruber.drivers.service.Exceptions.ReviewNotFoundException;

import java.util.List;

/**
 * dedicated service for drivers
 */
public interface DriverService {

    /**
     * Fetches all driver
     * @return
     * List<Driver> drivers
     * @throws DriverNotFoundException
     * No driver found
     */
    public List<Driver> getDrivers() throws DriverNotFoundException;

    /**
     * Fetches a driver for a given Id
     * @param driverId
     * Id of the driver
     * @return
     * Driver driver
     * @throws DriverNotFoundException
     * No driver found
     */
    public Driver getDriver(int driverId) throws DriverNotFoundException;

    /**
     * Fetches a driver for a given name
     * @param driverName
     * Name of the driver
     * @return
     * Driver driver
     * @throws DriverNotFoundException
     * No driver found
     */
    public Driver getDriver(String driverName) throws DriverNotFoundException;

    /**
     * Fetches a driver dto for a given id
     * @param driverId
     * Id of the driver
     * @return
     * DriverDTO driver
     * @throws DriverNotFoundException
     * No driver found
     */
	public DriverDTO getDriverDTO(int driverId) throws DriverNotFoundException;

    /**
     * Creates a new review for a driver
     * @param userId
     * Id of user that made the review
     * @param driverId
     * Id of driver that the review is about
     * @param content
     * the comment of the review
     * @param score
     * the rating of the review
     * @return
     * Review review
     * @throws ReviewExistsException
     * Review already exists in the database
     */
    public Review rateDriver(int userId, int driverId, String content, int score)throws ReviewExistsException;

    /**
     * Fetches all reviews for a given driver
     * @param driverId
     * Id of the driver
     * @return
     * List<Review> reviews
     * @throws ReviewNotFoundException
     * No Review found
     */
    public List<Review> getReviews(int driverId) throws ReviewNotFoundException;
}
