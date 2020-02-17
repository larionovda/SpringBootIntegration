package com.larionov.epam.controller.rest;

import com.larionov.epam.item.Product;
import com.larionov.epam.service.rest.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductService productService;
    private ModelAndView modelAndView = new ModelAndView("index");





    @GetMapping
    public ModelAndView getAllProducts(@RequestParam("page") Optional<Integer> page,
                                       @RequestParam("size") Optional<Integer> size) throws ExecutionException, InterruptedException {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(3);

        Page<Product> productPage = productService.findPaginated(PageRequest.of(currentPage - 1, pageSize));

        modelAndView.addObject("productPage", productPage);

        int totalPages = productPage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            modelAndView.addObject("pageNumbers", pageNumbers);
        }

        return modelAndView;
    }


//    @GetMapping
//    public ModelAndView getAllProducts() throws ExecutionException, InterruptedException {
//        modelAndView.addObject("products", productService.getAllProduct().get());
//        return modelAndView;
//    }

    @GetMapping("/getProductByPrice")
    public ModelAndView getProductsByPrice(@RequestParam(value = "price", required = false) BigDecimal price) throws ExecutionException, InterruptedException {
        modelAndView.addObject("products", productService.getProductsByPrice(price).get());
        return modelAndView;
    }

    @PostMapping
    public void addNewProduct(@ModelAttribute("product") Product newProduct) {
        productService.addNewProducts(newProduct);
    }

    @PostMapping("/updateProduct")
    public void updateProduct(@ModelAttribute("product") Product product) {
        productService.updateProductByArticle(product);
    }

    @DeleteMapping("{article}")
    public void deleteProduct(@PathVariable Long article) {
        productService.deleteProductById(article);
    }

    @RequestMapping("/add-product")
    public ModelAndView redirectToPageAdd() {
        ModelAndView modelAndView = new ModelAndView("addProduct");
        modelAndView.addObject("product", new Product());
        return modelAndView;
    }

    @RequestMapping("/update-product/{id}")
    public ModelAndView redirectToPageUpdate(@PathVariable Long id) throws ExecutionException, InterruptedException {
        ModelAndView modelAndView = new ModelAndView("updateProduct");
        modelAndView.addObject("product", productService.getProductByArticle(id).get());
        return modelAndView;
    }
}


