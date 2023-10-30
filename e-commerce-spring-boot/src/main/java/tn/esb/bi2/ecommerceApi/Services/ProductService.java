package tn.esb.bi2.ecommerceApi.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esb.bi2.ecommerceApi.Domains.Product;
import tn.esb.bi2.ecommerceApi.Repositories.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepos;
    //Add a new Product
    public Product addProduct(Product p) throws Exception {
        List<Product> products = productRepos.findAll();//get all product

        if(products.contains(p))
            throw new Exception("Product already exist");
        return productRepos.save(p);
    }

    public List<Product> getAllProducts()
    {
        return productRepos.findAll();
    }
    public Product getProduct(Long id)throws Exception
    {
        Optional<Product> res=productRepos.findById(id);
        if(res.isEmpty())
            throw new Exception("Product not found");
        return res.get();
    }
}
