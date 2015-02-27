package newtrino.services;

import newtrino.beans.Nutrient;
import newtrino.beans.Product;
import newtrino.daos.ProductDao;
import newtrino.dtos.ConsumptionDto;
import newtrino.dtos.NutrientDto;
import newtrino.dtos.chart.ConsumptionJsonDto;
import newtrino.utils.DtoCreatorUtil;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;

@Service
public class ReportingServiceImpl implements ReportingService{

    @Autowired
    private ConsumptionService consumptionService;

    @Autowired
    private ProductDao productDao;

    @Autowired
    private DtoCreatorUtil dtoCreatorUtil;

    @Override
    public List<ConsumptionJsonDto> fetchConsumptionData() {
        Date today = new Date();
        Set<ConsumptionDto> consumptionDtos = consumptionService.productsConsumedOn(today);
        Set<String> productNames = extractProductNames(consumptionDtos);
        List<Product> products = productDao.fetchAll(productNames);
        HashMap<String,NutrientDto> nutrientDtoHashMap = calculateNutrientsConsumed(consumptionDtos, products);
        return createConsumptionJsonDto(nutrientDtoHashMap);
    }

    private List<ConsumptionJsonDto> createConsumptionJsonDto(HashMap<String,NutrientDto> nutrientDtoHashMap){
        List<ConsumptionJsonDto> consumptionJsonDtos = new ArrayList<>();
        Iterator<String> keysItr = nutrientDtoHashMap.keySet().iterator();
        while (keysItr.hasNext()){
            String key = keysItr.next();
            NutrientDto nutrientDto = nutrientDtoHashMap.get(key);
            ConsumptionJsonDto consumptionJsonDto = new ConsumptionJsonDto(nutrientDto);
            consumptionJsonDtos.add(consumptionJsonDto);
        }
        return consumptionJsonDtos;
    }

    public HashMap<String,NutrientDto> calculateNutrientsConsumed(Set<ConsumptionDto> consumptionDtos,List<Product> products){

        HashMap<String,NutrientDto> nutrientDtoMap = new HashMap<>();

        Iterator<ConsumptionDto> consumptionDtoIterator = consumptionDtos.iterator();
        while (consumptionDtoIterator.hasNext()){
            ConsumptionDto consumptionDto = consumptionDtoIterator.next();
            // Finding for all nutrients
            List<Nutrient> nutrientList = getNutrients(products, consumptionDto);

            // Consumed Quantity
            Double prodConsumedQuantity = consumptionDto.getQuantity();

            // Multiplying nutrients
            manipulateNutrients(nutrientDtoMap, nutrientList, prodConsumedQuantity);
        }

        return nutrientDtoMap;
    }

    private void manipulateNutrients(HashMap<String, NutrientDto> nutrientDtoMap, List<Nutrient> nutrientList, Double prodConsumedQuantity) {
        if(!CollectionUtils.isEmpty(nutrientList)){
            for(Nutrient nutrient : nutrientList){
                // If Map contains then remove modify and add

                NutrientDto nutrientDto = dtoCreatorUtil.createNutrientDto(nutrient);
                String nutrientName = nutrientDto.getName();
                if(nutrientDtoMap.containsKey(nutrientName)){
                    NutrientDto nutrientDtoContained = nutrientDtoMap.remove(nutrientDto.getName());
                    Double calQ = nutrientDtoContained.getUnitDto().getQuantity() + nutrientDto.getUnitDto().getQuantity()*prodConsumedQuantity;
                    nutrientDtoContained.getUnitDto().setQuantity(calQ);
                    nutrientDtoMap.put(nutrientName,nutrientDtoContained);
                }else{
                    // If Map does not contains then modify and add
                    Double calQ = nutrientDto.getUnitDto().getQuantity()*prodConsumedQuantity;
                    nutrientDto.getUnitDto().setQuantity(calQ);
                    nutrientDtoMap.put(nutrientName,nutrientDto);
                }
            }
        }
    }

    private List<Nutrient> getNutrients(List<Product> products, ConsumptionDto consumptionDto) {
        List<Nutrient> nutrientList = null;
        for(Product product : products){
            if(product.getName().equalsIgnoreCase(consumptionDto.getProductName())){
                nutrientList = product.getNutrients();
            }
        }
        return nutrientList;
    }

    private Set<String> extractProductNames(Set<ConsumptionDto> consumptionDtos) {
        Set<String> productNames = new HashSet<>();
        Iterator<ConsumptionDto> consumptionDtoIterator = consumptionDtos.iterator();
        while(consumptionDtoIterator.hasNext()){
            productNames.add(consumptionDtoIterator.next().getProductName());
        }
        return productNames;
    }
}
