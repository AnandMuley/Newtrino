package newtrino.services;

import com.mongodb.gridfs.GridFSDBFile;
import newtrino.dtos.ProductDto;
import newtrino.dtos.SearchResponseJsonDto;

import java.util.List;
import java.util.Set;

public interface ProductService {

    void add(ProductDto productDto);

    Set<ProductDto> fetchAll();

    List<SearchResponseJsonDto> search(ProductDto productDto);

    GridFSDBFile fetchProductPic(String id);

    void deleteProduct(String productName);
}
