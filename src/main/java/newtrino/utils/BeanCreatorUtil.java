package newtrino.utils;

import com.mongodb.gridfs.GridFSDBFile;
import newtrino.beans.Consumption;
import newtrino.beans.Nutrient;
import newtrino.beans.Product;
import newtrino.beans.Unit;
import newtrino.dtos.ConsumptionDto;
import newtrino.dtos.NutrientDto;
import newtrino.dtos.ProductDto;
import newtrino.dtos.UnitDto;
import newtrino.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsCriteria;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Date;

@Component
public class BeanCreatorUtil {

    @Autowired
    private GridFsTemplate gridFsTemplate;

    @Autowired
    private ProductService productService;

    public Consumption createConsumption(ConsumptionDto consumptionDto){
        Date today = new Date();
        return new Consumption(consumptionDto.getProductName(),today);
    }

    public Product createProduct(ProductDto productDto){
        Product product = new Product(productDto.getName());
        for(NutrientDto nutrientDto : productDto.getNutrientDtos()){
            product.getNutrients().add(createNutrient(nutrientDto));
        }
        saveProductPic(productDto);
        return product;
    }

    private void saveProductPic(ProductDto productDto){
        try {
            if(productDto.getProdImg().getBytes().length>0){
                GridFSDBFile gridFSDBFile = productService.fetchProductPic(productDto.getName());
                if(null != gridFSDBFile){
                    gridFsTemplate.delete(Query.query(GridFsCriteria.whereFilename().is(productDto.getName())));
                }
                gridFsTemplate.store(productDto.getProdImg().getInputStream(),productDto.getName(),productDto.getProdImg().getContentType());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Nutrient createNutrient(NutrientDto nutrientDto){
        return new Nutrient(nutrientDto.getName(),createUnit(nutrientDto.getUnitDto()));
    }

    private Unit createUnit(UnitDto unitDto) {
        return new Unit(unitDto.getType(),unitDto.getQuantity());
    }


}
