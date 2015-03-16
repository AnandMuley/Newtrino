package newtrino.utils;

import com.mongodb.gridfs.GridFSDBFile;
import newtrino.beans.*;
import newtrino.dtos.*;
import newtrino.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsCriteria;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Date;

@Component
public class BeanCreatorUtilImpl implements BeanCreatorUtil{

    @Autowired
    private GridFsTemplate gridFsTemplate;

    @Autowired
    private ProductService productService;

    @Autowired
    private DateConverterUtil dateConverterUtil;

    @Override
    public Consumption createConsumption(ConsumptionDto consumptionDto){
        Date today = new Date();
        return new Consumption(consumptionDto.getProductName(),today);
    }

    @Override
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
            if(null != productDto.getProdImg() && productDto.getProdImg().getBytes().length>0){
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

    @Override
    public Nutrient createNutrient(NutrientDto nutrientDto){
        return new Nutrient(nutrientDto.getName(),createUnit(nutrientDto.getUnitDto()));
    }

    private Name createNameBean(NameDto nameDto){
       Name name = null;
       if(null != nameDto) {
           name = new Name(nameDto.getFirst(), nameDto.getMiddle(), nameDto.getLast());
       }
       return name;
    }

    private Contact createContactBean(ContactDto contactDto){
        Contact contact = null;
        if(contactDto != null){
            contact = new Contact(contactDto.getEmailId(),contactDto.getMobileNo());
        }
        return contact;
    }

    @Override
    public User createUserBean(UserDto userDto) {
        return new User(createNameBean(userDto.getNameDto()),userDto.getUsername(),userDto.getPassword(),createContactBean(userDto.getContactDto()),dateConverterUtil.toDate(userDto.getBirthDate(),DateConverterUtil.PATTERN_DDMMYYYY));
    }

    private Unit createUnit(UnitDto unitDto) {
        return new Unit(unitDto.getType(),unitDto.getQuantity());
    }


}
