/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tasf.projectasf.model;

import com.tasf.projectasf.entity.GeneralSaleEntity;
import java.util.List;
import lombok.Data;

/**
 *
 * @author FREDY
 */
@Data
public class ResponseSale {
    private GeneralSaleEntity sale;
    private List<productValue> listProduct;
}
