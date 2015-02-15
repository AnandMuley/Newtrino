package newtrino.dtos;

import java.util.ArrayList;
import java.util.List;

public class ProductDto extends SearchDto implements Comparable {

    private String id;
    private String name;
    private List<NutrientDto> nutrientDtos = new ArrayList<>();

    public ProductDto() {
    }

    public ProductDto(String id, String name) {
        this.id = id;
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

    public List<NutrientDto> getNutrientDtos() {
        return nutrientDtos;
    }

    public void setNutrientDtos(List<NutrientDto> nutrientDtos) {
        this.nutrientDtos = nutrientDtos;
    }

    @Override
    public String toString() {
        return "ProductDto{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", nutrientDtos=" + nutrientDtos +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        ProductDto productDto = (ProductDto)o;
        return this.id.compareTo(productDto.getId());
    }
}
