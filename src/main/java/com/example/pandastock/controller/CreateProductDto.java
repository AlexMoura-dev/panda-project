/*
    DTOs:
    Nem sempre o que está no database eu quero expor na API e nem para o usuário,
    para isso criamos DTOs, objetos que utilizamos para transferência entre camadas,
    e não poluir demais os campos da api, já que nem todos os campos são geridos
    pelo user, o id como exemplo.
 */

package com.example.pandastock.controller;

public record CreateProductDto(String name, String code, int quantity, double price) {
}
