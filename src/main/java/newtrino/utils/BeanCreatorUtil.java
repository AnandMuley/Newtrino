package newtrino.utils;


import newtrino.beans.Consumption;
import newtrino.beans.Nutrient;
import newtrino.beans.Product;
import newtrino.dtos.ConsumptionDto;
import newtrino.dtos.NutrientDto;
import newtrino.dtos.ProductDto;

public interface BeanCreatorUtil {

    Consumption createConsumption(ConsumptionDto consumptionDto);

    Product createProduct(ProductDto productDto);

    Nutrient createNutrient(NutrientDto nutrientDto);

}
