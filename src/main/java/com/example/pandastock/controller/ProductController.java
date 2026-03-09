/*
   CONTROLLER:
   Reponsável por fazer chamadas HTTP e devolver reponse da api, a porta de entrada da aplicação
   Aqui fazemos os endpoints (POST, GET)
 */

package com.example.pandastock.controller;

import com.example.pandastock.entity.Product;
import com.example.pandastock.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityReturnValueHandler;

import java.net.URI;
import java.util.List;


@RestController // Define que Essa classe vai receber requisições HTTP e devolver respostas em JSON.
@RequestMapping ("/api/products") // Define a rota da url até a API
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /*
           A seguir, você vai ver:
           ResponseEntity: tipo de retorno desse metodo.
           Esse metodo vai devolver uma resposta HTTP que contém um objeto Product.
           Resposta HTTP: devolve STATUS, HEADERS e BODY (JSON com as infos do objeto)
        */
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody CreateProductDto createProductDTO) {
        var productId = productService.createProduct(createProductDTO);
        return ResponseEntity.created(URI.create("/api/products/" + productId.toString())).build();
    }


    @GetMapping("{productId}") //Para escrever id do produto no campo do endpoint, pathvariable é pra isso tbm
    public ResponseEntity<Product> getProductById(@PathVariable("productId") String productId) {

        var product = productService.getProductById(productId);
        if (product.isPresent()) {
            return ResponseEntity.ok(product.get());
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @GetMapping
    public ResponseEntity<List<Product>> listProducts() {

        var products = productService.listProducts();
        return ResponseEntity.ok(products);
    }

    @PutMapping("{productId}")
    public ResponseEntity<Void> updateProductById(@PathVariable("ProductId") String productId,
                                                  @RequestBody UpdateProductDTO updateProductDTO) {
        productService.updateProductById(productId, updateProductDTO);
        return ResponseEntity.noContent().build();
    }


    @DeleteMapping("{productId}")
    public ResponseEntity<Void> deleteById(@PathVariable("productId") String productId) {

        productService.deleteById(productId);
        return ResponseEntity.noContent().build();

    }



}
