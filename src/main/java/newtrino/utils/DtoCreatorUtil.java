package newtrino.utils;

import newtrino.beans.Consumption;
import newtrino.beans.Nutrient;
import newtrino.beans.Product;
import newtrino.beans.Unit;
import newtrino.dtos.*;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class DtoCreatorUtil {

    public Set<ConsumptionDto> createConsumptions(List<Consumption> consumptions){
        Set<ConsumptionDto> consumptionDtos = new TreeSet<>();
        for(Consumption consumption : consumptions){
            consumptionDtos.add(createConsumptionDto(consumption));
        }
        return consumptionDtos;
    }

    private ConsumptionDto createConsumptionDto(Consumption consumption) {
        return new ConsumptionDto(consumption.getId(),consumption.getProductName(),consumption.getQuantity(),consumption.getConsumptionTime());
    }

    public Set<ProductDto> createProductDtos(List<Product> products){
        Set<ProductDto> productDtos = new TreeSet<>();
        for(Product product : products){
            productDtos.add(createProductDto(product));
        }
        return productDtos;
    }

    public ProductDto createProductDto(Product product){
        List<NutrientDto> nutrientDtos = new ArrayList<>();
        ProductDto productDto = new ProductDto(product.getId(),product.getName());
        productDto.setNutrientDtos(nutrientDtos);
        for(Nutrient nutrient : product.getNutrients()){
            nutrientDtos.add(createNutrientDto(nutrient));
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
