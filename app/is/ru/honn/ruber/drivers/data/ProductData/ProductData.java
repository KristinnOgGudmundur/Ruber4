package is.ru.honn.ruber.drivers.data.ProductData;

import is.ru.honn.ruber.domain.Driver;
import is.ru.honn.ruber.domain.Product;
import is.ru.honn.ruber.drivers.service.Exceptions.DriverNotFoundException;
import is.ru.honn.ruber.drivers.service.Exceptions.ProductNotFoundException;
import is.ruframework.data.RuData;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ProductData extends RuData implements ProductDataGateway {

    private String productTableName = "ru_products";

    @Override
    public Product getProductById(int id) {

        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        Product product;

        try
        {
            product = jdbcTemplate.queryForObject(
                    "select * from " + productTableName + " where id = '" + id + "'", new ProductRowMapper());
        }
        catch (EmptyResultDataAccessException erdaex)
        {
            throw new ProductNotFoundException("No Product found with id: " + id);
        }
        return product;
    }

    @Override
    public List<Product> getProducts() {

        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());

        List<Product> products;
        try
        {
            products = jdbcTemplate.query(
                    "select * from " + productTableName, new ProductRowMapper());
        }
        catch (EmptyResultDataAccessException erdaex)
        {
            throw new ProductNotFoundException("No products found");
        }
        return products;
    }

}
