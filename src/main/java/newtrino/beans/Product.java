package newtrino.beans;

import java.util.ArrayList;
import java.util.List;

public class Product implements Comparable{

    private String id;
    private String name;
    private List<Nutrient> nutrients = new ArrayList<>();

    public Product() {
    }

    public Product(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Nutrient> getNutrients() {
        return nutrients;
    }

    public void setNutrients(List<Nutrient> nutrients) {
        this.nutrients = nutrients;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", nutrients=" + nutrients +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        Product product = (Product)o;
        return this.id.compareTo(product.getId());
    }
}
