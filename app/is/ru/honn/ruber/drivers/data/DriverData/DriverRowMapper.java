package is.ru.honn.ruber.drivers.data.DriverData;

import is.ru.honn.ruber.domain.Driver;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DriverRowMapper implements RowMapper<Driver>
{
    public Driver mapRow(ResultSet rs, int rowNum) throws SQLException
    {
        Driver driver = new Driver(rs.getInt(1),rs.getString(2),rs.getString(3));

        return driver;
    }
}
