package is.ru.honn.ruber.drivers.service;

import is.ru.honn.ruber.domain.Driver;
import is.ru.honn.ruber.domain.History;
import is.ru.honn.ruber.domain.Review;
import is.ru.honn.ruber.drivers.data.DriverDataGateway;

import java.util.List;

/**
 * Created by Gvendur Stefáns on 22.10.2014.
 */
public class RuberDriverService implements DriverService {

	public RuberDriverService(DriverDataGateway driverDataGateway){

	}

	@Override
	public List<Driver> getDrivers() {
		return null;
	}

	@Override
	public Driver getDriver(int driverID) {
		return null;
	}

	@Override
	public History getHistory(int driverID) {
		return null;
	}

	@Override
	public void rateDriver(int driverID, Review review) {

	}
}
