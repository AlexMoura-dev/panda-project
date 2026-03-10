package com.example.pandastock.controller;

public record UpdateProductDto(String name, String code, int quantity, double price) {
}
