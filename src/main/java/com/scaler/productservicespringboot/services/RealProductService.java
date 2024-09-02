package com.scaler.productservicespringboot.services;

import com.scaler.productservicespringboot.dto.FakeStoreRequestDTO;
import com.scaler.productservicespringboot.models.Category;
import com.scaler.productservicespringboot.models.Product;
import com.scaler.productservicespringboot.repository.CategoryRepository;
import com.scaler.productservicespringboot.repository.ProductRepository;
import jakarta.persistence.ManyToOne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Qualifier("RealProductService")
public class RealProductService implements  ProductService{

    ProductRepository productRepository;
    CategoryRepository categoryRepository;

    @Autowired
    public RealProductService(ProductRepository productRepository, CategoryRepository categoryRepository){
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product getSingleProduct(int id) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {

//        return productRepository.getAllProducts();
        return null;
    }

    @Override
    public Product addProduct(Product product) {

//        {
//            "name": "Dell 15\"",
//                "description": "this is a office laptop",
//                "price": 100000,
//                "imgUrl": "",
//                "category":{
//            "title": "laptop"
//        }
//        }

//        or
//        {
//            name: Dell 15",
//            description: "this is a office laptop",
//            price: 100000;
//            imgUrl: null,
//            category:{
//                id: null
//                title: laptop
//            }
//        }
        Optional<Category> optionalCategory = categoryRepository.getCategoriesByTitle(product.getCategory().getTitle());
        if(optionalCategory.isEmpty()){
            Category category = new Category();
            category.setTitle(product.getCategory().getTitle());

            Category newlyAddedCategory = categoryRepository.save(category);
//            let say, id = 4
            product.setCategory(newlyAddedCategory);
            //        {
//            name: Dell 15",
//            description: "this is a office laptop",
//            price: 100000;
//            imgUrl: null,
//            category:{
//                id: 4
//                title: laptop
//            };
//        }
        }
        else{
            Category exsistingCategory = optionalCategory.get();
            product.setCategory(exsistingCategory);
        }
        return productRepository.save(product);
    }



    @Override
    public Product addProduct(FakeStoreRequestDTO fakeStoreRequestDTO) {
        return null;
    }

    @Override
    public List<Product> searchProducts(String searchText) {
        List<Product> ProductsFromDB = productRepository.getProductByName("");

        //core logic for filter products, with whether the products contain searchtext or not
        List<Product> filteredProducts = new ArrayList<>();
        for (Product product : ProductsFromDB) {
            if(product.getName().contains(searchText)){
                filteredProducts.add(product);
            }
        }

        return filteredProducts;
    }

    @Override
    public List<Product> getProductsByCategoryTitle(String searchText) {
        List<Product> products = productRepository.getProductsByCategoryTitle(searchText);
        return products;
    }
}
