package newtrino.common;

import newtrino.beans.Nutrient;
import newtrino.beans.Product;
import newtrino.beans.Unit;
import newtrino.dtos.ConsumptionDto;
import newtrino.dtos.NutrientDto;
import newtrino.dtos.UnitDto;

import java.util.*;

public class TestDataUtils {

    public Set<ConsumptionDto> generateConsumptionDtos(int size){
        Set<ConsumptionDto> consumptionDtos = new HashSet<>();
        if(size>0){
            Date consumptionTime = new Date();
            ConsumptionDto consumedApple = new ConsumptionDto("PRD001","Apple",2,consumptionTime);
            consumptionDtos.add(consumedApple);
        }
        return consumptionDtos;
    }

    public List<Product> generateProductDtos() {
        List<Product> products = new ArrayList<>();
        List<Nutrient> nutrients = new ArrayList<>();
        Product product = new Product();
        product.setId("PRD001");
        product.setName("Apple");
        Unit unitProtein = new Unit("mg",10);
        Nutrient protein = new Nutrient("Protein",unitProtein);
        Unit unitFat = new Unit("mg",10);
        Nutrient fats = new Nutrient("Fats",unitFat);

        nutrients.add(protein);
        nutrients.add(fats);

        product.setNutrients(nutrients);
        products.add(product);
        return products;
    }

    public NutrientDto generateNutrientDto(String name){
        UnitDto unitDto = new UnitDto(20,"mg");
        NutrientDto nutrientDto = new NutrientDto(name,unitDto);
        return nutrientDto;
    }

}
