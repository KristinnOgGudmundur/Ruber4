package is.ru.honn.ruber.drivers.service;

import is.ru.honn.ruber.domain.Driver;
import is.ru.honn.ruber.domain.DriverDTO;
import is.ru.honn.ruber.domain.History;
import is.ru.honn.ruber.domain.Review;
import is.ru.honn.ruber.drivers.service.Exceptions.DriverNotFoundException;
import is.ru.honn.ruber.drivers.service.Exceptions.ReviewNotFoundException;

import java.util.List;


public interface DriverService {
    public List<Driver> getDrivers() throws DriverNotFoundException;
    public Driver getDriver(int driverId) throws DriverNotFoundException;
	public DriverDTO getDriverDTO(int driverId) throws DriverNotFoundException;
    public History getHistory(int driverId);
    public Review rateDriver(int userId, int driverId, String content, int score);
    public List<Review> getReviews(int driverId) throws ReviewNotFoundException;
}
