package newtrino.services;

import newtrino.beans.Product;
import newtrino.daos.ProductDao;
import newtrino.dtos.ProductDto;
import newtrino.dtos.SearchResponseJsonDto;
import newtrino.utils.BeanCreatorUtil;
import newtrino.utils.DtoCreatorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private BeanCreatorUtil beanCreatorUtil;

    @Autowired
    private DtoCreatorUtil dtoCreatorUtil;

    @Autowired
    private ProductDao productDao;

    @Override
    public void add(ProductDto productDto) {
        Product product = beanCreatorUtil.createProduct(productDto);
        productDao.add(product);
    }

    @Override
    public Set<ProductDto> fetchAll() {
        List<Product> products = productDao.fetchAll();
        return dtoCreatorUtil.createProductDtos(products);
    }

    @Override
    public List<SearchResponseJsonDto> search(ProductDto productDto) {
        List<Product> products = productDao.searchByName(productDto.getTerm());
        return dtoCreatorUtil.createSearchResponseDtos(products);
    }
}
