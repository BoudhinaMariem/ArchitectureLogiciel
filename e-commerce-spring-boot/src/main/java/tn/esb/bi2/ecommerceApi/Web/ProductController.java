package tn.esb.bi2.ecommerceApi.Web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esb.bi2.ecommerceApi.Domains.Product;
import tn.esb.bi2.ecommerceApi.Services.ProductService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/products")
//The path will be http://localhost:9592/products
public class ProductController {
    @Autowired
    private ProductService productServ;
    @PostMapping("/add")
    //url=http://localhost:9592/products/add
    public Product addNewProduct(@Valid @RequestBody Product p) throws Exception {
        return productServ.addProduct(p);
    }
    @GetMapping("/all")
    //url=http://localhost:9592/products/all
    public List<Product> getAll()throws Exception {
        return productServ.getAllProducts();
    }
    @GetMapping("/{id}")
    //url=http://localhost:9592/products/5

    public Product getProductById(@PathVariable Long id)throws Exception {
        return productServ.getProduct(id);
    }
}
