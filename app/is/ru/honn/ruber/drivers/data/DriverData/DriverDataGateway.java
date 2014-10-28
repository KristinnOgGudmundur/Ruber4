package is.ru.honn.ruber.drivers.data.DriverData;

import is.ru.honn.ruber.domain.Driver;
import java.util.List;

public interface DriverDataGateway {
    public Driver getDriverByName(String name);
    public Driver getDriverById(int id);
    public List<Driver> getDrivers();
}
