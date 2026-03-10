package com.example.pandastock.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.UUID;


//Definindo a entidade tabela para os produtos e suas colunas
@Entity
@Table(name = "tb_products")
public class Product {

    // Usamos private para validar os dados
    // ex: (throw new IllegalArgumentException)
    // Para acessar eles vamos usar setters e getters
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID productId;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    @Column(name = "quantidy")
    private int quantity;

    @Column(name = "price")
    private double price;

    /*
       CAMPOS DE AUDITÓRIA -> Cria um objeto que:
       mostra na tabela quando um item foi criado e
       quando um item foi atualizado, podemos usar esses
       objetos na tela e em determinadas situações também
    */

    @CreationTimestamp
    private Instant creationTimeStamp; //Instant mostra a data atual

    @UpdateTimestamp
    private Instant updateTimeStamp;

    /*
       Construtor vazio exigido pelo JPA.
       Usado pelo Hibernate para instanciar o objeto
       ao recuperar dados do banco e preencher os seus
       atributos no novo objeto instanciado dessa classe.
    */
    public Product() {

    }


    // ===================================================================


    //Criando um construtor para a gente conseguir usar instanciar objetos manualmente
    public Product(UUID productId, String name, String code,
                   int quantity, double price, Instant creationTimeStamp,
                   Instant updateTimeStamp
    ) {
        this.productId = productId;
        this.name = name;
        this.code = code;
        this.quantity = quantity;
        this.price = price;
        this.creationTimeStamp = creationTimeStamp;
        this.updateTimeStamp = updateTimeStamp;
    }

    //GETTERS E SETTERS -> para modificar atributos privados
    public UUID getProductId() {
        return productId;
    }

    public void setProductId(UUID productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Instant getCreationTimeStamp() {
        return creationTimeStamp;
    }

    public void setCreationTimeStamp(Instant creationTimeStamp) {
        this.creationTimeStamp = creationTimeStamp;
    }

    public Instant getUpdateTimeStamp() {
        return updateTimeStamp;
    }

    public void setUpdateTimeStamp(Instant updateTimeStamp) {
        this.updateTimeStamp = updateTimeStamp;
    }

}
