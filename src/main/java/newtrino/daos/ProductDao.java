package newtrino.daos;

import newtrino.beans.Product;

import java.util.List;

public interface ProductDao {

    void add(Product product);

    List<Product> fetchAll();
}
