package newtrino.common;

import newtrino.beans.Consumption;
import newtrino.beans.Nutrient;
import newtrino.beans.Product;
import newtrino.beans.Unit;
import newtrino.dtos.ConsumptionDto;
import newtrino.dtos.NutrientDto;
import newtrino.dtos.ProductDto;
import newtrino.dtos.UnitDto;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

@Component
public class TestDataUtils {

    public ProductDto createProductDto(int nutrients){
        MultipartFile prodImg = null;
        List<NutrientDto> nutrientDtos = createNutrientDtos(nutrients);
        ProductDto productDto = new ProductDto("Pineapple",prodImg,"10",nutrientDtos);
        return productDto;
    }

    public List<NutrientDto> createNutrientDtos(int size){
        List<NutrientDto> nutrientDtos = new ArrayList<>();
        for(int i=0;i<size;i++){
            nutrientDtos.add(generateNutrientDto("Nutrient"+i));
        }
        return nutrientDtos;
    }

    public List<Consumption> createConsumptions(){
        List<Consumption> consumptions = new ArrayList<>();
        Consumption consumption = createConsumption("ProductName");
        consumptions.add(consumption);
        return consumptions;
    }

    public Consumption createConsumption(String productName){
        Date today = new Date();
        Consumption consumption = new Consumption(productName,2,today);
        return consumption;
    }

    public Product createProduct(){
        Product product = new Product("Apple");
        Unit unit = new Unit("mg",10);
        Nutrient protein = new Nutrient("Protein",unit);
        product.getNutrients().add(protein);
        return product;
    }


    public List<Product> createProducts(int num){
        List<Product> products = new ArrayList<>();
        for(int i=0;i<num;i++){
            Product product = new Product("id"+i,"Product"+i);
            Unit unit = new Unit("mg",10+i);
            Nutrient protein = new Nutrient("Nutrient",unit);
            product.getNutrients().add(protein);
            products.add(product);
        }
        return products;
    }

    public Set<ConsumptionDto> generateConsumptionDtos(int size){
        Set<ConsumptionDto> consumptionDtos = new HashSet<>();
        if(size>0){
            Date consumptionTime = new Date();
            ConsumptionDto consumedApple = new ConsumptionDto("PRD001","Apple",2,consumptionTime);
            consumptionDtos.add(consumedApple);
        }
        return consumptionDtos;
    }

    public ConsumptionDto createConsumptionDto(String name){
        Date consumptionTime = new Date();
        ConsumptionDto consumptionDto = new ConsumptionDto("PRD001",name,2,consumptionTime);
        return consumptionDto;
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

    public Nutrient createNurtient(String name){
        Unit unit = new Unit("mg",10);
        Nutrient nutrient = new Nutrient(name,unit);
        return nutrient;
    }

}
