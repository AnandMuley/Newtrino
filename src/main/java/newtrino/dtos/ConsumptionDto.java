package newtrino.dtos;

import java.util.Date;

public class ConsumptionDto implements  Comparable{

    private String id;
    private String productName;
    private double quantity;
    private Date consumptionTime;

    public ConsumptionDto() {
    }

    public ConsumptionDto(String id, String productName, int quantity, Date consumptionTime) {
        this.id = id;
        this.productName = productName;
        this.quantity = quantity;
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

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
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
        return "ConsumptionDto{" +
                "id='" + id + '\'' +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                ", consumptionTime=" + consumptionTime +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        ConsumptionDto consumptionDto = (ConsumptionDto)o;
        return this.consumptionTime.compareTo(consumptionDto.getConsumptionTime());
    }
}
