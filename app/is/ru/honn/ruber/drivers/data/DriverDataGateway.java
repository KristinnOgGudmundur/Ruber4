package is.ru.honn.ruber.drivers.data;

import is.ru.honn.ruber.domain.Driver;
import java.util.List;

public interface DriverDataGateway {
    public int addDriver(Driver driver);
    public Driver getDriverByName(String name);
    public Driver getDriverById(int id);
    public List<Driver> getDrivers();
}
