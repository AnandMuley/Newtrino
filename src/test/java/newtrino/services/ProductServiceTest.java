package newtrino.services;

import newtrino.beans.Product;
import newtrino.common.DefaultConfiguration;
import newtrino.daos.ProductDao;
import newtrino.dtos.ProductDto;
import newtrino.utils.BeanCreatorUtilImpl;
import newtrino.utils.DtoCreatorUtilImpl;
import org.jmock.Expectations;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class ProductServiceTest extends DefaultConfiguration{

    private ProductServiceImpl productService;

    private ProductDao mockProductDao;

    private GridFsOperations mockGridFsTemplate;

    @Before
    public void setUp(){
        productService = new ProductServiceImpl();
        beanCreatorUtil = new BeanCreatorUtilImpl();
        dtoCreatorUtil = new DtoCreatorUtilImpl();
        mockProductDao = context.mock(ProductDao.class);
        mockGridFsTemplate = context.mock(GridFsOperations.class);

        ReflectionTestUtils.setField(productService,"beanCreatorUtil",beanCreatorUtil);
        ReflectionTestUtils.setField(productService,"dtoCreatorUtil",dtoCreatorUtil);
        ReflectionTestUtils.setField(productService,"productDao",mockProductDao);
        ReflectionTestUtils.setField(productService,"gridFsTemplate",mockGridFsTemplate);
    }


    @Test
    public void testAdd(){
        // Given
        final int nutrients = 2;
        final ProductDto productDto = testDataUtils.createProductDto(nutrients);

        // When
        context.checking(new Expectations(){
            {
                oneOf(mockProductDao).add(with(any(Product.class)));
            }
        });
        productService.add(productDto);

        // Then
        // Cannot verify since the method return type is void
    }

    @Test
    public void testFetchAll(){
        // Given
        final int expectedSize = 2;
        final List<Product> products = testDataUtils.createProducts(expectedSize);

        // When
        context.checking(new Expectations(){
            {
                oneOf(mockProductDao).fetchAll();
                will(returnValue(products));
            }
        });

        Set<ProductDto> productDtos = productService.fetchAll();

        // Then
        Assert.assertEquals(expectedSize,productDtos.size());
    }

    //@Test
    public void testSearch(){
        // Given

        // When

        // Then
    }

   // @Test
    public void testFetchProductPic(){

    }

    //@Test
    public void testDeleteProduct() {

    }
}