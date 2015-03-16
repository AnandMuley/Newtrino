package newtrino.daos;

import com.mongodb.WriteResult;
import newtrino.beans.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao{

    @Qualifier("mongoTemplate")
    @Autowired
    private MongoOperations mongoOperations;


    @Override
    public void create(User user) {
        mongoOperations.insert(user);
    }

    @Override
    public int delete(String userId) {
        Query query = Query.query(Criteria.where("id").is(userId));
        WriteResult result = mongoOperations.remove(query, User.class);
        return result.getN();
    }

    @Override
    public User find(String username, String password) {
        Query query = Query.query(Criteria.where("username").is(username).and("password").is(password));
        return mongoOperations.findOne(query, User.class);
    }

    @Override
    public User findById(String userId) {
        return mongoOperations.findById(userId,User.class);
    }
}
