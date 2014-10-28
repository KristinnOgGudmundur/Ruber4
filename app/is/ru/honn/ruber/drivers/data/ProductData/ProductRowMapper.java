package is.ru.honn.ruber.drivers.data.ProductData;

import is.ru.honn.ruber.domain.Driver;
import is.ru.honn.ruber.domain.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRowMapper implements RowMapper<Product>
{
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException
    {
        Product product = new Product(rs.getInt(1),rs.getString(2),rs.getString(3));

        return product;
    }
}
