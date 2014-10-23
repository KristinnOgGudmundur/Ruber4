package is.ru.honn.ruber.drivers.data;

import is.ru.honn.ruber.domain.Driver;
import is.ru.honn.ruber.domain.User;
import is.ru.honn.ruber.users.data.UserRowMapper;
import is.ru.honn.ruber.users.service.UserNotFoundException;
import is.ruframework.data.RuData;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Collection;
import java.util.List;

/**
 * Created by Gvendur Stefáns on 22.10.2014.
 */
public class DriverData extends RuData implements DriverDataGateway {

    private String driverTableName = "ru_drivers";

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

    @Override
    public List<Driver> getDrivers() {

        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());

        List<Driver> drivers;
        try
        {
            drivers = jdbcTemplate.query(
                    "select * from " + driverTableName, new DriverRowMapper());
        }
        catch (EmptyResultDataAccessException erdaex)
        {
            throw new UserNotFoundException("No drivers found");
        }
        return drivers;
    }


}
