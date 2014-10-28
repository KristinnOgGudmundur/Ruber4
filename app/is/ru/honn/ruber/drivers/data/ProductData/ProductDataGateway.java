package is.ru.honn.ruber.drivers.data.ProductData;

import is.ru.honn.ruber.domain.Driver;
import is.ru.honn.ruber.domain.Product;

import java.util.List;

public interface ProductDataGateway {
    public int addProduct(Product product);
    public Product getProductById(int id);
    public List<Product> getProducts();
}
