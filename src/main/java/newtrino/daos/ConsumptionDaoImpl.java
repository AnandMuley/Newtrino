package newtrino.daos;

import newtrino.beans.Consumption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class ConsumptionDaoImpl implements ConsumptionDao{

    @Qualifier("mongoTemplate")
    @Autowired
    private MongoOperations mongoOperations;

    @Override
    public void createNew(Consumption consumption) {
        mongoOperations.insert(consumption);
    }

    @Override
    public List<Consumption> consumedOn(Date startDate,Date endDate) {
        Query query = Query.query(Criteria.where("consumptionTime").lt(endDate));
        return mongoOperations.find(query,Consumption.class);
    }
}
