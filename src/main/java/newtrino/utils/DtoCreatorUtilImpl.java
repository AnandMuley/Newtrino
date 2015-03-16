package newtrino.utils;

import newtrino.beans.*;
import newtrino.dtos.*;
import newtrino.dtos.chart.ConsumptionJsonDto;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DtoCreatorUtilImpl implements DtoCreatorUtil{

    @Autowired
    private DateConverterUtil dateConverterUtil;

    @Override
    public Set<ConsumptionDto> createConsumptions(List<Consumption> consumptions){
        Set<ConsumptionDto> consumptionDtos = new TreeSet<>();
        for(Consumption consumption : consumptions){
            consumptionDtos.add(createConsumptionDto(consumption));
        }
        return consumptionDtos;
    }

    @Override
    public ConsumptionDto createConsumptionDto(Consumption consumption) {
        return new ConsumptionDto(consumption.getId(),consumption.getProductName(),consumption.getQuantity(),consumption.getConsumptionTime());
    }

    @Override
    public Set<ProductDto> createProductDtos(List<Product> products){
        Set<ProductDto> productDtos = new TreeSet<>();
        for(Product product : products){
            productDtos.add(createProductDto(product));
        }
        return productDtos;
    }

    @Override
    public ProductDto createProductDto(Product product){
        List<NutrientDto> nutrientDtos = new ArrayList<>();
        ProductDto productDto = new ProductDto(product.getId(),product.getName());
        productDto.setNutrientDtos(nutrientDtos);
        for(Nutrient nutrient : product.getNutrients()){
            nutrientDtos.add(createNutrientDto(nutrient));
        }
        return productDto;
    }

    @Override
    public NutrientDto createNutrientDto(Nutrient nutrient) {
        NutrientDto nutrientDto = new NutrientDto();
        nutrientDto.setName(nutrient.getName());
        nutrientDto.setUnitDto(createUnitDto(nutrient.getUnit()));
        return nutrientDto;
    }

    @Override
    public UserDto createUserDto(User user) {
        return new UserDto(user.getId(),createNameDto(user.getName()),user.getUsername(),user.getPassword(),createContactDto(user.getContact()),dateConverterUtil.toString(user.getBirthDate(),DateConverterUtil.PATTERN_DDMMYYYY));
    }

    private ContactDto createContactDto(Contact contact) {
        return new ContactDto(contact.getEmailId(),contact.getMobileNo());
    }

    private NameDto createNameDto(Name name) {
        NameDto nameDto = null;
        if(null != name) {
           nameDto = new NameDto(name.getFirst(), name.getMiddle(), name.getLast());
        }
        return nameDto;
    }

    private UnitDto createUnitDto(Unit unit) {
        return new UnitDto(unit.getQuantity(),unit.getType());
    }

    @Override
    public List<SearchResponseJsonDto> createSearchResponseDtos(List<Product> products){
        List<SearchResponseJsonDto> responseJsons = new LinkedList<>();
        for (Product product : products){
            responseJsons.add(createSearchResponseDto(product));
        }
        return responseJsons;
    }

    @Override
    public SearchResponseJsonDto createSearchResponseDto(Product product){
        return new SearchResponseJsonDto(product.getId(),product.getName(),product.getName());
    }

}
