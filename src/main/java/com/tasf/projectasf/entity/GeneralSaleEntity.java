/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tasf.projectasf.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author FREDY
 */
@Entity
@Table(name = "general_sale")
@Data
public class GeneralSaleEntity {
    @Id
    private long consecutiveSaleId;
    private String descriprion;
    private double totalValue;
    private int totalProduct;
    private long detailSaleId;
}
