package newtrino.services;

import newtrino.beans.Nutrient;
import newtrino.beans.Product;
import newtrino.common.DefaultConfiguration;
import newtrino.common.TestDataUtils;
import newtrino.config.BootstrapJunit;
import newtrino.daos.ProductDao;
import newtrino.dtos.ConsumptionDto;
import newtrino.dtos.NutrientDto;
import newtrino.dtos.chart.ConsumptionJsonDto;
import newtrino.utils.DtoCreatorUtil;
import org.jmock.Expectations;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class ReportingServiceTest extends DefaultConfiguration{

    private ReportingServiceImpl reportingService;

    private ConsumptionService mockConsumptionService;

    private ProductDao mockProductDao;

    private DtoCreatorUtil mockDtoCreatorUtil;

    @Before
    public void setUp() {
        reportingService = new ReportingServiceImpl();
        testDataUtils = new TestDataUtils();

        mockConsumptionService = context.mock(ConsumptionService.class);
        mockProductDao = context.mock(ProductDao.class);
        mockDtoCreatorUtil = context.mock(DtoCreatorUtil.class);

        ReflectionTestUtils.setField(reportingService,"consumptionService",mockConsumptionService);
        ReflectionTestUtils.setField(reportingService,"productDao",mockProductDao);
        ReflectionTestUtils.setField(reportingService,"dtoCreatorUtil",mockDtoCreatorUtil);
    }


    @Test
    public void testFetchConsumptionData(){
        // Given
        final int size = 1;
        final Set<ConsumptionDto> expectedJsons = testDataUtils.generateConsumptionDtos(size);
        final List<Product> expectedProducts = testDataUtils.generateProductDtos();
        final NutrientDto proteinDto = testDataUtils.generateNutrientDto("Protein");
        final NutrientDto fatsDto = testDataUtils.generateNutrientDto("Fats");

        // When
        context.checking(new Expectations(){
            {
                allowing(mockConsumptionService).productsConsumedOn(with(any(Date.class)));
                will(returnValue(expectedJsons));
                allowing(mockProductDao).fetchAll(with(any(Set.class)));
                will(returnValue(expectedProducts));
                oneOf(mockDtoCreatorUtil).createNutrientDto(with(any(Nutrient.class)));
                will(returnValue(proteinDto));
                oneOf(mockDtoCreatorUtil).createNutrientDto(with(any(Nutrient.class)));
                will(returnValue(fatsDto));
            }
        });
        List<ConsumptionJsonDto> consumptionJsonDtos = reportingService.fetchConsumptionData();

        // Then
        Assert.assertEquals(2, consumptionJsonDtos.size());
    }

    @Test
    public void testFetchConsumptionDataCommon(){
        // Given
        final int size = 1;
        final Set<ConsumptionDto> expectedJsons = testDataUtils.generateConsumptionDtos(size);
        final List<Product> expectedProducts = testDataUtils.generateProductDtos();
        expectedProducts.get(0).getNutrients().add(testDataUtils.createNurtient("Protein"));
        final NutrientDto proteinDto = testDataUtils.generateNutrientDto("Protein");
        final NutrientDto proteinDto1 = testDataUtils.generateNutrientDto("Protein");
        final NutrientDto fatsDto = testDataUtils.generateNutrientDto("Fats");

        // When
        context.checking(new Expectations(){
            {
                allowing(mockConsumptionService).productsConsumedOn(with(any(Date.class)));
                will(returnValue(expectedJsons));
                allowing(mockProductDao).fetchAll(with(any(Set.class)));
                will(returnValue(expectedProducts));
                oneOf(mockDtoCreatorUtil).createNutrientDto(with(any(Nutrient.class)));
                will(returnValue(proteinDto));
                oneOf(mockDtoCreatorUtil).createNutrientDto(with(any(Nutrient.class)));
                will(returnValue(proteinDto1));
                oneOf(mockDtoCreatorUtil).createNutrientDto(with(any(Nutrient.class)));
                will(returnValue(fatsDto));
            }
        });
        List<ConsumptionJsonDto> consumptionJsonDtos = reportingService.fetchConsumptionData();

        // Then
        Assert.assertEquals(2, consumptionJsonDtos.size());
    }

    @Test
    public void testFetchConsumptionDataNone() {
        // Given
        final int size = 0;
        final Set<ConsumptionDto> expectedJsons = testDataUtils.generateConsumptionDtos(size);
        final List<Product> expectedProducts = testDataUtils.generateProductDtos();
        final NutrientDto nutrientDto = testDataUtils.generateNutrientDto("Protein");

        // When
        context.checking(new Expectations(){
            {
                allowing(mockConsumptionService).productsConsumedOn(with(any(Date.class)));
                will(returnValue(expectedJsons));
                allowing(mockProductDao).fetchAll(with(any(Set.class)));
                will(returnValue(expectedProducts));
                allowing(mockDtoCreatorUtil).createNutrientDto(with(any(Nutrient.class)));
                will(returnValue(nutrientDto));
            }
        });
        List<ConsumptionJsonDto> consumptionJsonDtos = reportingService.fetchConsumptionData();

        // Then
        Assert.assertEquals(size, consumptionJsonDtos.size());
    }

    @Test
    public void testFetchConsumptionDataNoNutrients() {
        // Given
        final int size = 1;
        final Set<ConsumptionDto> expectedJsons = testDataUtils.generateConsumptionDtos(size);
        expectedJsons.add(testDataUtils.createConsumptionDto("Dummy"));
        final List<Product> expectedProducts = testDataUtils.generateProductDtos();
        final NutrientDto proteinDto = testDataUtils.generateNutrientDto("Protein");
        final NutrientDto fatsDto = testDataUtils.generateNutrientDto("Fats");

        // When
        context.checking(new Expectations(){
            {
                allowing(mockConsumptionService).productsConsumedOn(with(any(Date.class)));
                will(returnValue(expectedJsons));
                allowing(mockProductDao).fetchAll(with(any(Set.class)));
                will(returnValue(expectedProducts));
                oneOf(mockDtoCreatorUtil).createNutrientDto(with(any(Nutrient.class)));
                will(returnValue(proteinDto));
                oneOf(mockDtoCreatorUtil).createNutrientDto(with(any(Nutrient.class)));
                will(returnValue(fatsDto));
            }
        });
        List<ConsumptionJsonDto> consumptionJsonDtos = reportingService.fetchConsumptionData();

        // Then
        Assert.assertEquals(2, consumptionJsonDtos.size());
    }

}