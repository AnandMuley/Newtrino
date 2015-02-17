package newtrino.services;

import newtrino.dtos.ConsumptionDto;

import java.util.Date;
import java.util.Set;

public interface ConsumptionService {

    void consumeProduct(ConsumptionDto consumptionDto);

    Set<ConsumptionDto> productsConsumedOn(Date date);

    ConsumptionDto changeConsumptionQuantity(String productName,Integer opr);
}
