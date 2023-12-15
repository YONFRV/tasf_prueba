/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tasf.projectasf.model;

import lombok.Data;

/**
 *
 * @author FREDY
 */
@Data
public class productValue {
    private long productId;
    private String nameProduct;
    private int amount;
    private double priceProduct;
    private double total;
}
