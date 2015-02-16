package newtrino.services;

import com.mongodb.gridfs.GridFSDBFile;
import newtrino.beans.Product;
import newtrino.daos.ProductDao;
import newtrino.dtos.ProductDto;
import newtrino.dtos.SearchResponseJsonDto;
import newtrino.utils.BeanCreatorUtil;
import newtrino.utils.DtoCreatorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsCriteria;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

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

    @Autowired
    private GridFsTemplate gridFsTemplate;

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

    @Override
    public GridFSDBFile fetchProductPic(String id) {
        GridFSDBFile gridFSDBFile = null;
        List<GridFSDBFile> result = gridFsTemplate.find(Query.query(GridFsCriteria.whereFilename().is(id)));
        if(!CollectionUtils.isEmpty(result)){
            gridFSDBFile = result.get(0);
        }
        return gridFSDBFile;
    }
}
