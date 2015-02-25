package newtrino.daos;

import newtrino.beans.Consumption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

public class ConsumptionRefDao {

    @Qualifier("mongoTemplate")
    @Autowired
    private MongoOperations mongoOperations;

    public Consumption findByName(String name){
        Query query = Query.query(Criteria.where("productName").is(name));
        return mongoOperations.findOne(query, Consumption.class);
    }

}
