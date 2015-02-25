package newtrino.utils;

import newtrino.beans.Consumption;
import newtrino.beans.Nutrient;
import newtrino.beans.Product;
import newtrino.dtos.ConsumptionDto;
import newtrino.dtos.NutrientDto;
import newtrino.dtos.ProductDto;
import newtrino.dtos.SearchResponseJsonDto;

import java.util.List;
import java.util.Set;

public interface DtoCreatorUtil {

    Set<ConsumptionDto> createConsumptions(List<Consumption> consumptions);

    ConsumptionDto createConsumptionDto(Consumption consumption);

    Set<ProductDto> createProductDtos(List<Product> products);

    ProductDto createProductDto(Product product);

    List<SearchResponseJsonDto> createSearchResponseDtos(List<Product> products);

    SearchResponseJsonDto createSearchResponseDto(Product product);

    NutrientDto createNutrientDto(Nutrient nutrient);
}
