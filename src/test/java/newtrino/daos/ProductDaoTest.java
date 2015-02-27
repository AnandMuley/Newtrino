package newtrino.daos;

import newtrino.beans.Product;
import newtrino.common.CommonDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
public class ProductDaoTest extends CommonDao<Product> {

    @Autowired
    private ProductDao productDao;

    @Test
    public void testAdd(){
        // Given
        Product product = testDataUtils.createProduct();

        // When
        productDao.add(product);
        Product actual = super.findByField("name",product.getName(),Product.class);

        // Then
        Assert.assertNotNull(actual);
    }

    @Test
    public void testFetchAll() {
        // Given
        int expectedSize = 3;
        List<Product> products = testDataUtils.createProducts(expectedSize);

        // When
        for(int i=0;i<expectedSize;i++){
            productDao.add(products.get(i));
        }

        List<Product> actualList = productDao.fetchAll();

        // Then
        Assert.assertEquals(expectedSize,actualList.size());
    }

    @Test
    public void testSearchByName() {
        // Given
        Product expected = testDataUtils.createProduct();

        // When
        productDao.add(expected);
        List<Product> actual = productDao.searchByName(expected.getName());

        // Then
        Assert.assertEquals(expected.getName(),actual.get(0).getName());
        Assert.assertNotNull(actual.get(0).getId());
    }

    @Test
    public void testDelete(){
        // Given
        Product product = testDataUtils.createProduct();
        int expectedSize = 0;

        // When
        productDao.add(product);
        Product actual = super.findByField("name",product.getName(),Product.class);
        Assert.assertNotNull(actual);
        productDao.delete(product.getName());
        List<Product> actualList = productDao.fetchAll();

        // Then
        Assert.assertEquals(expectedSize,actualList.size());
    }

    @Test
    public void testFetchAllByNames() {
        // Given
        int expectedSize = 3;

        Set<String> productNames = new HashSet<>();
        productNames.add("Product0");
        productNames.add("Product1");
        productNames.add("Product2");

        List<Product> products = testDataUtils.createProducts(expectedSize);

        // When
        for(int i=0;i<expectedSize;i++){
            productDao.add(products.get(i));
        }

        List<Product> actualList = productDao.fetchAll(productNames);

        // Then
        Assert.assertEquals(expectedSize,actualList.size());
    }
}