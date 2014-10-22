package is.ru.honn.ruber.drivers.data;

import is.ru.honn.ruber.domain.Driver;

/**
 * Created by Gvendur Stefáns on 22.10.2014.
 */
public interface DriverDataGateway {
	public int addDriver(Driver driver);
	public Driver getDriverByName(String name);
	public Driver getDriverById(int id);
}
