package is.ru.honn.ruber.drivers.data.DriverData;

import is.ru.honn.ruber.domain.Driver;
import java.util.List;

/**
 * Gateway for ru_drivers database
 */
public interface DriverDataGateway {

    /**
     * Fetches Driver from a given name
     * @param name
     * Name of driver
     * @return
     * Driver driver
     */
    public Driver getDriverByName(String name);

    /**
     * Fetches Driver from a given id
     * @param id
     * Id of driver
     * @return
     * Driver driver
     */
    public Driver getDriverById(int id);

    /**
     * Fetches all drivers
     * @return
     * List<Driver> drivers
     */
    public List<Driver> getDrivers();
}
