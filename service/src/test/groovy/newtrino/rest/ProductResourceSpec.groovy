package newtrino.rest

import newtrino.dtos.ProductDto
import newtrino.shared.SharedSpecification
import spock.lang.Shared

class ProductResourceSpec extends SharedSpecification {

    @Shared
    ProductResource productResource

    def setup() {
        productResource = new ProductResource()
    }

    def "add - should create a product"() {
        given: "product does not exist"
        ProductDto productDto = new ProductDto()

        when: "add is called"
        productResource.add(productDto)

        then: "product should be added"
        assert productDto.id == null

    }

}
