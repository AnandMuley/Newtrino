package newtrino.daos;

import newtrino.beans.Consumption;
import newtrino.utils.DateConverterUtil;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/config/application-config.xml")
public class ConsumptionDaoImplTest extends ConsumptionRefDao{

    @Autowired
    private ConsumptionDao consumptionDao;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private DateConverterUtil dateConverterUtil;

    @Before
    public void setUp() throws Exception {
        mongoTemplate.getDb().dropDatabase();
    }

    @After
    public void cleanUp() throws Exception {
        mongoTemplate.getDb().dropDatabase();
    }

    @Test
    public void testCreateNew() throws Exception {

        // Given
        String name = "PRD001";
        Date today = new Date();
        Consumption consumption = new Consumption(name,1,today);

        // When
        consumptionDao.createNew(consumption);
        Consumption consumptionPersisted = super.findByName(name);

        // Then
        Assert.assertNotNull(consumptionPersisted);

    }

    @Test
    public void testConsumedOn() throws Exception {
        // Given
        String name = "PRD001";
        Date today = new Date();
        Consumption consumption = new Consumption(name,1,today);
        Date endDate = dateConverterUtil.calculateEndDate(today);
        Date startDate = dateConverterUtil.calculateStartDate(today);
        final int expectedSize = 1;

        // When
        consumptionDao.createNew(consumption);
        List<Consumption> consumptions = consumptionDao.consumedOn(startDate,endDate);

        // Then
        Assert.assertEquals(expectedSize,consumptions.size());
    }

    @Test
    public void testConsumedOnWithOldData() throws Exception {
        // Given
        String name = "PRD001";
        Date today = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        calendar.add(Calendar.DAY_OF_MONTH,-2);
        Consumption consumedYesterday = new Consumption(name,1,calendar.getTime());
        Consumption consumption = new Consumption(name,1,today);
        Date endDate = dateConverterUtil.calculateEndDate(today);
        Date startDate = dateConverterUtil.calculateStartDate(today);
        final int expectedSize = 1;

        // When
        consumptionDao.createNew(consumption);
        consumptionDao.createNew(consumedYesterday);
        List<Consumption> consumptions = consumptionDao.consumedOn(startDate,endDate);

        // Then
        Assert.assertEquals(expectedSize,consumptions.size());
    }

    @Test
    public void testChangeConsumptionQuantity() throws Exception {

        // Given
        String name = "PRD001";
        Date today = new Date();
        Consumption consumption = new Consumption(name,1,today);
        final int expectedQuantity = 3;

        // When
        consumptionDao.createNew(consumption);
        consumptionDao.changeConsumptionQuantity(name,expectedQuantity);
        Consumption actualConsumption = super.findByName(name);

        // Then
        Assert.assertEquals(expectedQuantity+1,actualConsumption.getQuantity());

    }
}