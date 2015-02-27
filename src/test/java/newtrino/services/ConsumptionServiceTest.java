package newtrino.services;

import newtrino.beans.Consumption;
import newtrino.beans.Nutrient;
import newtrino.common.DefaultConfiguration;
import newtrino.common.TestDataUtils;
import newtrino.daos.ConsumptionDao;
import newtrino.daos.ProductDao;
import newtrino.dtos.ConsumptionDto;
import newtrino.utils.*;
import org.jmock.Expectations;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Date;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class ConsumptionServiceTest extends DefaultConfiguration{

    private ConsumptionDao mockConsumptionDao;

    private ConsumptionServiceImpl consumptionService;

    @Before
    public void setUp(){
        mockConsumptionDao = context.mock(ConsumptionDao.class);
        beanCreatorUtil = new BeanCreatorUtilImpl();
        dateConverterUtil = new DateConverterUtilImpl();
        dtoCreatorUtil = new DtoCreatorUtilImpl();

        consumptionService = new ConsumptionServiceImpl();
        testDataUtils = new TestDataUtils();

        ReflectionTestUtils.setField(consumptionService, "consumptionDao", mockConsumptionDao);
        ReflectionTestUtils.setField(consumptionService, "beanCreatorUtil", beanCreatorUtil);
        ReflectionTestUtils.setField(consumptionService, "dateConverterUtil", dateConverterUtil);
        ReflectionTestUtils.setField(consumptionService, "dtoCreatorUtil",dtoCreatorUtil);
    }

    @Test
    public void testConsumeProduct() throws Exception {
        // Given
        final ConsumptionDto expectedConsumptionDto = testDataUtils.createConsumptionDto("Apple");

        // When
        context.checking(new Expectations(){
            {
                oneOf(mockConsumptionDao).createNew(with(any(Consumption.class)));
            }
        });

        consumptionService.consumeProduct(expectedConsumptionDto);

        // Then
        // The only way to check whether the test case is successful is only one invocation of methods
        // which is taken care by oneOf

    }

    @Test
    public void testProductsConsumedOn() throws Exception {
        // Given
        final Date today = new Date();
        final List<Consumption> consumptions = testDataUtils.createConsumptions();
        final int expectedSize = 1;

        // When
        context.checking(new Expectations(){
            {
                oneOf(mockConsumptionDao).consumedOn(with(any(Date.class)),with(any(Date.class)));
                will(returnValue(consumptions));
            }
        });
        Set<ConsumptionDto> consumptionDtos  =consumptionService.productsConsumedOn(today);

        // Then
        Assert.assertEquals(expectedSize,consumptionDtos.size());
    }

    @Test
    public void testChangeConsumptionQuantityIncrement() throws Exception {

        // Given
        final String productName = "Apple";
        final int operation = 1;
        final Consumption changedConsumption = testDataUtils.createConsumption("Apple");
        changedConsumption.setQuantity(10);

        // When

        context.checking(new Expectations(){
            {
                oneOf(mockConsumptionDao).changeConsumptionQuantity(with(any(String.class)),with(any(Integer.class)));
                will(returnValue(changedConsumption));
            }
        });
        ConsumptionDto actualConsumptionDto = consumptionService.changeConsumptionQuantity(productName, operation);

        // Then
        Assert.assertEquals(changedConsumption.getQuantity(),actualConsumptionDto.getQuantity(),0);

    }

    @Test
    public void testChangeConsumptionQuantityDecrement() throws Exception {

        // Given
        final String productName = "Apple";
        final int operation = -1;
        final Consumption changedConsumption = testDataUtils.createConsumption("Apple");
        changedConsumption.setQuantity(9);

        // When

        context.checking(new Expectations(){
            {
                oneOf(mockConsumptionDao).changeConsumptionQuantity(with(any(String.class)),with(any(Integer.class)));
                will(returnValue(changedConsumption));
            }
        });
        ConsumptionDto actualConsumptionDto = consumptionService.changeConsumptionQuantity(productName, operation);

        // Then
        Assert.assertEquals(changedConsumption.getQuantity(),actualConsumptionDto.getQuantity(),0);

    }

    @Test
    public void testChangeConsumptionQuantityDefaultOperation() throws Exception {

        // Given
        final String productName = "Apple";
        final int operation = 0;
        final Consumption changedConsumption = testDataUtils.createConsumption("Apple");
        changedConsumption.setQuantity(9);

        // When

        context.checking(new Expectations(){
            {
                oneOf(mockConsumptionDao).changeConsumptionQuantity(with(any(String.class)),with(any(Integer.class)));
                will(returnValue(changedConsumption));
            }
        });
        ConsumptionDto actualConsumptionDto = consumptionService.changeConsumptionQuantity(productName, operation);

        // Then
        Assert.assertNull(actualConsumptionDto);

    }
}