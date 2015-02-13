package newtrino.daos;

import newtrino.beans.Product;
import newtrino.utils.DBCollections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDao{

    @Qualifier("mongoTemplate")
    @Autowired
    private MongoOperations mongoOperations;

    @Override
    public void add(Product product) {
        mongoOperations.insert(product, DBCollections.PRODUCTS);
    }

    @Override
    public List<Product> fetchAll() {
        return mongoOperations.findAll(Product.class,DBCollections.PRODUCTS);
    }
}