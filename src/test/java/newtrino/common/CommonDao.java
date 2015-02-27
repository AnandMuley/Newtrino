package newtrino.common;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

public class CommonDao<T> extends DefaultConfiguration{

    public T findByField(String fieldName,String fieldValue,Class<T> tClass){
        Query query = Query.query(Criteria.where(fieldName).is(fieldValue));
        return mongoOperations.findOne(query,tClass);
    }

}
