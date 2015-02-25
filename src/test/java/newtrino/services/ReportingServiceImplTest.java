package newtrino.services;

import newtrino.beans.Nutrient;
import newtrino.beans.Product;
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
import org.springframework.test.util.ReflectionTestUtils;

import java.util.*;

public class ReportingServiceImplTest extends BootstrapJunit{

    private ReportingServiceImpl reportingService;

    private ConsumptionService mockConsumptionService;

    private ProductDao mockProductDao;

    private DtoCreatorUtil mockDtoCreatorUtil;

    @Before
    public void setUp() throws Exception {
        reportingService = new ReportingServiceImpl();

        mockConsumptionService = context.mock(ConsumptionService.class);
        mockProductDao = context.mock(ProductDao.class);
        mockDtoCreatorUtil = context.mock(DtoCreatorUtil.class);

        ReflectionTestUtils.setField(reportingService,"consumptionService",mockConsumptionService);
        ReflectionTestUtils.setField(reportingService,"productDao",mockProductDao);
        ReflectionTestUtils.setField(reportingService,"dtoCreatorUtil",mockDtoCreatorUtil);
    }


    @Test
    public void testFetchConsumptionData() throws Exception {
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
    public void testFetchConsumptionDataNone() throws Exception {
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
}