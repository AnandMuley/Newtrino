package newtrino.dtos;

public class UnitDto {

    private String type;
    private double quantity;
    private double maxQuantity;

    public UnitDto() {
    }

    public UnitDto(double quantity,String type) {
        this.type = type;
        this.quantity = quantity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getMaxQuantity() {
        return maxQuantity;
    }

    public void setMaxQuantity(double maxQuantity) {
        this.maxQuantity = maxQuantity;
    }

    @Override
    public String toString() {
        return "UnitDto{" +
                "type='" + type + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
