package newtrino.services;

import newtrino.beans.Consumption;
import newtrino.daos.ConsumptionDao;
import newtrino.dtos.ConsumptionDto;
import newtrino.utils.BeanCreatorUtil;
import newtrino.utils.DateConverterUtil;
import newtrino.utils.DtoCreatorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
public class ConsumptionServiceImpl implements ConsumptionService{

    @Autowired
    private BeanCreatorUtil beanCreatorUtil;

    @Autowired
    private DateConverterUtil dateConverterUtil;

    @Autowired
    private ConsumptionDao consumptionDao;

    @Autowired
    private DtoCreatorUtil dtoCreatorUtil;


    @Override
    public void consumeProduct(ConsumptionDto consumptionDto) {
        consumptionDao.createNew(beanCreatorUtil.createConsumption(consumptionDto));
    }

    @Override
    public Set<ConsumptionDto> productsConsumedOn(Date today) {
        Date endDate = dateConverterUtil.calculateEndDate(today);
        List<Consumption> consumptions = consumptionDao.consumedOn(today, endDate);
        return dtoCreatorUtil.createConsumptions(consumptions);
    }
}
