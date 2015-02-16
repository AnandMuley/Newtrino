package newtrino.dtos;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class ProductDto extends SearchDto implements Comparable {

    private String id;
    private String name;
    private MultipartFile prodImg;
    private String quantity;
    private List<NutrientDto> nutrientDtos;

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

    public MultipartFile getProdImg() {
        return prodImg;
    }

    public void setProdImg(MultipartFile prodImg) {
        this.prodImg = prodImg;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
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
