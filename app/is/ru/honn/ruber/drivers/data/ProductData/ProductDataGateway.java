package is.ru.honn.ruber.drivers.data.ProductData;

import is.ru.honn.ruber.domain.Product;
import java.util.List;

/**
 * Gateway for ru_products database
 */
public interface ProductDataGateway {

    /**
     * Fetches product for a given id
     * @param id
     * Id of the product
     * @return
     * Product product
     */
    public Product getProductById(int id);

    /**
     * Fetches all products
     * @return
     * List<Product> products
     */
    public List<Product> getProducts();
}
