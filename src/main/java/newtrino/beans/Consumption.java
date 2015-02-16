package newtrino.beans;


import newtrino.utils.DBCollections;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = DBCollections.CONSUMPTIONS)
public class Consumption {

    @Id
    private String id;
    private String productName;
    private long quantity;
    private Date consumptionTime;

    public Consumption() {
    }

    public Consumption(String productName, Date consumptionTime) {
        this.productName = productName;
        this.consumptionTime = consumptionTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public Date getConsumptionTime() {
        return consumptionTime;
    }

    public void setConsumptionTime(Date consumptionTime) {
        this.consumptionTime = consumptionTime;
    }

    @Override
    public String toString() {
        return "Consumption{" +
                "id='" + id + '\'' +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                ", consumptionTime=" + consumptionTime +
                '}';
    }
}
