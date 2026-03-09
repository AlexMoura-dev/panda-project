
/*
    REPOSITORY:
    Para gravar no banco de dados usamos o Repository.
    Essa interface é responsável por fazer a comunicação com o banco.

    Ao estender JpaRepository, não precisamos implementar nada,
    pois o Spring Data JPA já fornece automaticamente os métodos
    de CRUD (save, findById, findAll, delete, etc).

    Os tipos genéricos significam:
    T -> Tipo da entidade que será persistida no banco (ex: Product)
    ID -> Tipo do id da entidade (ex: UUID, Long, Integer)

 */

package com.example.pandastock.repository;

import com.example.pandastock.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> { //Aceita generics
}
