package newtrino.daos;

import newtrino.beans.Product;
import newtrino.utils.DBCollections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.regex.Pattern;

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

    @Override
    public List<Product> searchByName(String name) {
        Query query = Query.query(Criteria.where("name").regex(name,"i"));
        return mongoOperations.find(query,Product.class,DBCollections.PRODUCTS);
    }

    @Override
    public void delete(String productName) {
        Query query = Query.query(Criteria.where("name").is(productName));
        mongoOperations.remove(query,Product.class);
    }
}
