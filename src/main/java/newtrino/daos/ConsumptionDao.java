package newtrino.daos;

import newtrino.beans.Consumption;

import java.util.Date;
import java.util.List;

public interface ConsumptionDao {

    void createNew(Consumption consumption);

    List<Consumption> consumedOn(Date startDate,Date endDate);

}
