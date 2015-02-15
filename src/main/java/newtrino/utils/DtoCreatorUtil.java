package newtrino.utils;

import newtrino.beans.Nutrient;
import newtrino.beans.Product;
import newtrino.beans.Unit;
import newtrino.dtos.NutrientDto;
import newtrino.dtos.ProductDto;
import newtrino.dtos.SearchResponseJsonDto;
import newtrino.dtos.UnitDto;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class DtoCreatorUtil {

    public Set<ProductDto> createProductDtos(List<Product> products){
        Set<ProductDto> productDtos = new TreeSet<>();
        for(Product product : products){
            productDtos.add(createProductDto(product));
        }
        return productDtos;
    }

    public ProductDto createProductDto(Product product){
        ProductDto productDto = new ProductDto(product.getId(),product.getName());
        for(Nutrient nutrient : product.getNutrients()){
            productDto.getNutrientDtos().add(createNutrientDto(nutrient));
        }
        return productDto;
    }

    private NutrientDto createNutrientDto(Nutrient nutrient) {
        return new NutrientDto(nutrient.getName(),createUnitDto(nutrient.getUnit()));
    }

    private UnitDto createUnitDto(Unit unit) {
        return new UnitDto(unit.getQuantity(),unit.getType());
    }

    public List<SearchResponseJsonDto> createSearchResponseDtos(List<Product> products){
        List<SearchResponseJsonDto> responseJsons = new LinkedList<>();
        for (Product product : products){
            responseJsons.add(createSearchResponseDto(product));
        }
        return responseJsons;
    }

    public SearchResponseJsonDto createSearchResponseDto(Product product){
        return new SearchResponseJsonDto(product.getId(),product.getName(),product.getName());
    }

}
