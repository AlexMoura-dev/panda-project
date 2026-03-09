
/*
    SERVICE:
    Aqui a lógica do sistema é feito e as regras de négocios são aplicadas,
    essa é uma camada entre o controller e o repository. Aqui também vamos
    converter DTO para entidade.
 */

package com.example.pandastock.service;

import com.example.pandastock.controller.CreateProductDto;
import com.example.pandastock.controller.UpdateProductDTO;
import com.example.pandastock.entity.Product;
import com.example.pandastock.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/*
    DEPENDÊNCIAS:
    Uma dependência é uma classe que outra classe precisa para funcionar.
    Você pode observar um exemplo no código abaixo, onde ProductService
    precisa do ProductRepository para acessar a database.

    Então, podemos dizer que: ProductService depende de ProductRepository.
*/

/*
    @Service indica:
    1️. A classe contém regras de negócio
    2️. O Spring deve criar e gerir um objeto dela
    3️. Esse objeto pode ser injetado em outras classes
*/

@Service
public class ProductService {

    private ProductRepository productRepository;

    // Aqui a nossa injeção de dependências
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    //CREATE PRODUCT:

    //O tipo de retorno da função vai ser o tipo ID, só ele por segurança
    public UUID createProduct(CreateProductDto createProductDTO) {

        //DTO -> ENTITY
        var entity = new Product(
                null,
                createProductDTO.name(),
                createProductDTO.code(),
                createProductDTO.quantity(),
                createProductDTO.price(),
                Instant.now(),
                null
        );

       var productSaved = productRepository.save(entity);

       return productSaved.getProductId();
    }

    //FIND BY ID
    public Optional<Product> getProductById(String productId) {

        return productRepository.findById(UUID.fromString(productId));
    }

    //RETURN ALL
    public List<Product> listProducts() {
//        var protucts = productService.listProducts(); -> não precisa???
        return productRepository.findAll();
    }

    //UPDATE BY ID
    public void updateProductById(String productId,
                                  UpdateProductDTO updateProductDTO) {

        var id = UUID.fromString(productId);
        var productExists = productRepository.findById(id);

        if (productExists.isPresent()) {
            var product = productExists.get();

            if (updateProductDTO.code() != null) {
                product.setCode(updateProductDTO.code());
            }

            if (updateProductDTO.name() != null) {
                product.setName(updateProductDTO.name());
            }

            productRepository.save(product);

        }
    }

    //DELETE BY ID
    public void deleteById(String productId) {

        var id = UUID.fromString(productId);
        var productExists = productRepository.existsById(UUID.fromString(productId));

        if (productExists) {
            productRepository.deleteById(id);
        }
    }

}
