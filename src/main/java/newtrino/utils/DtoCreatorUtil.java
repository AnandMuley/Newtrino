package newtrino.utils;

import newtrino.beans.Consumption;
import newtrino.beans.Nutrient;
import newtrino.beans.Product;
import newtrino.beans.User;
import newtrino.dtos.*;

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

    UserDto createUserDto(User user);
}
