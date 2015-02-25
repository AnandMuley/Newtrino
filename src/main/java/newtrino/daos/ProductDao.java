package newtrino.daos;

import newtrino.beans.Product;

import java.util.List;
import java.util.Set;

public interface ProductDao {

    void add(Product product);

    List<Product> fetchAll();

    List<Product> searchByName(String name);

    void delete(String productName);

    List<Product> fetchAll(Set<String> productNames);
}
