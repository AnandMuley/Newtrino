package newtrino.services;

import newtrino.dtos.ProductDto;

import java.util.Set;

public interface ProductService {

    void add(ProductDto productDto);

    Set<ProductDto> fetchAll();

}
