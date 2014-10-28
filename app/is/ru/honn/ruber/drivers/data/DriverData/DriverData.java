package is.ru.honn.ruber.drivers.data.DriverData;

import is.ru.honn.ruber.domain.Driver;
import is.ru.honn.ruber.drivers.service.Exceptions.DriverNotFoundException;
import is.ruframework.data.RuData;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;

public class DriverData extends RuData implements DriverDataGateway {

    private String driverTableName = "ru_drivers";

    @Override
    public Driver getDriverByName(String name) {

        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        Driver driver;

        try
        {
            driver = jdbcTemplate.queryForObject(
                    "select * from " + driverTableName + " where name = '" + name + "'", new DriverRowMapper());
        }
        catch (EmptyResultDataAccessException erdaex)
        {
            throw new DriverNotFoundException("No Driver found with name: " + name);
        }
        return driver;
    }

    @Override
    public Driver getDriverById(int id) {

        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        Driver driver;

        try
        {
            driver = jdbcTemplate.queryForObject(
                    "select * from " + driverTableName + " where id = '" + id + "'", new DriverRowMapper());
        }
        catch (EmptyResultDataAccessException erdaex)
        {
            throw new DriverNotFoundException("No Driver found with id: " + id);
        }
        return driver;
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
            throw new DriverNotFoundException("No drivers found");
        }
        return drivers;
    }

}
