package newtrino.common;

import newtrino.utils.BeanCreatorUtil;
import newtrino.utils.DateConverterUtil;
import newtrino.utils.DtoCreatorUtil;
import org.jmock.Mockery;
import org.junit.After;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;


@ContextConfiguration(locations = "classpath:/config/application-config.xml")
public class DefaultConfiguration {

    @Autowired
    protected MongoTemplate mongoTemplate;

    @Qualifier("mongoTemplate")
    @Autowired
    protected MongoOperations mongoOperations;

    @Autowired
    protected DateConverterUtil dateConverterUtil;

    @Autowired
    protected TestDataUtils testDataUtils;

    protected BeanCreatorUtil beanCreatorUtil;

    protected DtoCreatorUtil dtoCreatorUtil;

    protected Mockery context = new Mockery();

    @Before
    public void setUp(){
        mongoTemplate.getDb().dropDatabase();
    }

    @After
    public void cleanUp() {
        mongoTemplate.getDb().dropDatabase();
    }

}
