package module.product;

import java.util.ArrayList;

public interface ProductRepository {
    ArrayList<Product> findAll();
    Product findById(long id);
    Product save(Product product);
    void deleteById();
}
