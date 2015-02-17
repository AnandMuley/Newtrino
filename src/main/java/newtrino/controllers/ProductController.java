package newtrino.controllers;

import com.mongodb.gridfs.GridFSDBFile;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductService productService;

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
    @RequestMapping("delete")
    public String deleteProduct(@RequestParam("pname") String productName){
        productService.deleteProduct(productName);
        return Messages.SUCCESS;
    }

    @ResponseBody
    @RequestMapping("search")
    public List<SearchResponseJsonDto> searchProduct(ProductDto productDto){
        return productService.search(productDto);
    }

    @RequestMapping(value = "fetchimage")
    public void fetchProductImage(HttpServletRequest request,HttpServletResponse response,String imageId) {
        try {
            GridFSDBFile userProfilePic = productService.fetchProductPic(imageId);
            OutputStream outputStream = response.getOutputStream();
            userProfilePic.writeTo(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException e){
            System.out.println("Profile pic not set yet");
        }
    }

}
