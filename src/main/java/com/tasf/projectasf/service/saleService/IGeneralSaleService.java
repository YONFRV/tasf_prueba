/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tasf.projectasf.service.saleService;

import com.tasf.projectasf.model.ResponseProcess;
import org.springframework.http.HttpHeaders;

/**
 *
 * @author FREDY
 */
public interface IGeneralSaleService {
    ResponseProcess validationSearchSale(HttpHeaders header, long id);
}
