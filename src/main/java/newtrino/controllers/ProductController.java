package newtrino.controllers;

import newtrino.dtos.ProductDto;
import newtrino.dtos.SearchResponseJsonDto;
import newtrino.services.ProductService;
import newtrino.utils.Messages;
import newtrino.utils.Models;
import newtrino.utils.ViewNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("home")
    public String renderHome(){
        return ViewNames.PRODUCT_HOME;
    }

    @RequestMapping("add")
    public String renderAddProduct(Model model){
        Set<ProductDto> productDtos = productService.fetchAll();
        model.addAttribute(Models.PRODUCTS,productDtos);
        return ViewNames.ADD_PRODUCT;
    }

    @RequestMapping("addnew")
    public String addProduct(ProductDto productDto,Model model){
        productService.add(productDto);
        model.addAttribute(Models.MESSAGE, Messages.PRODUCT_ADD_SUCCESS);
        return renderAddProduct(model);
    }

    @ResponseBody
    @RequestMapping("search")
    public List<SearchResponseJsonDto> searchProduct(ProductDto productDto){
        return productService.search(productDto);
    }

}
