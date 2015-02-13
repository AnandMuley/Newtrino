package newtrino.utils;

import newtrino.beans.Nutrient;
import newtrino.beans.Product;
import newtrino.beans.Unit;
import newtrino.dtos.NutrientDto;
import newtrino.dtos.ProductDto;
import newtrino.dtos.UnitDto;
import org.springframework.stereotype.Component;

@Component
public class BeanCreatorUtil {

    public Product createProduct(ProductDto productDto){
        Product product = new Product(productDto.getName());
        for(NutrientDto nutrientDto : productDto.getNutrientDtos()){
            product.getNutrients().add(createNutrient(nutrientDto));
        }
        return product;
    }

    public Nutrient createNutrient(NutrientDto nutrientDto){
        return new Nutrient(nutrientDto.getName(),createUnit(nutrientDto.getUnitDto()));
    }

    private Unit createUnit(UnitDto unitDto) {
        return new Unit(unitDto.getType(),unitDto.getQuantity());
    }


}
