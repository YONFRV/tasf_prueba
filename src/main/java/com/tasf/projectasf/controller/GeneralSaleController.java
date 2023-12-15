/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tasf.projectasf.controller;

import com.tasf.projectasf.model.ResponseProcess;
import com.tasf.projectasf.service.saleService.IGeneralSaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author FREDY
 */
@Controller
@CrossOrigin(origins = {"*"})
@RequestMapping("api/v1")
public class GeneralSaleController {
    
    @Autowired
    private IGeneralSaleService IGeneralSaleService;
   
    @GetMapping(value = "/sale/{idSale}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseProcess> saleGeneralProcesss(@PathVariable  long idSale,@RequestHeader HttpHeaders header) {
        ResponseProcess result = IGeneralSaleService.validationSearchSale(header, idSale);
        if(result.isSuccess()){
            return new ResponseEntity<>(result, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
    }
    
}
