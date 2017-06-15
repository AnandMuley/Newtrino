package newtrino.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
public class Consumption {

    @Id
    private String id;
    private String productName;
    private int quantity;
    private Date consumptionTime;

    public Consumption() {
    }

    public Consumption(String productName, int quantity, Date consumptionTime) {
        this.productName = productName;
        this.quantity = quantity;
        this.consumptionTime = consumptionTime;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getConsumptionTime() {
        return consumptionTime;
    }

    public void setConsumptionTime(Date consumptionTime) {
        this.consumptionTime = consumptionTime;
    }

    public void changeConsumptionQuantity(int changeVal){
        this.quantity+=changeVal;
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
