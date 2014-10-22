package is.ru.honn.ruber.drivers.data;

import is.ru.honn.ruber.domain.Driver;
import is.ruframework.data.RuData;

/**
 * Created by Gvendur Stefáns on 22.10.2014.
 */
public class DriverData extends RuData implements DriverDataGateway {
	@Override
	public int addDriver(Driver driver) {
		return 0;
	}

	@Override
	public Driver getDriverByName(String name) {
		return null;
	}

	@Override
	public Driver getDriverById(int id) {
		return null;
	}
}
