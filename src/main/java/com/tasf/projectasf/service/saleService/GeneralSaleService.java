/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tasf.projectasf.service.saleService;

import com.google.gson.Gson;
import com.tasf.projectasf.entity.DetailSaleEntity;
import com.tasf.projectasf.entity.GeneralSaleEntity;
import com.tasf.projectasf.entity.ProductsEntity;
import com.tasf.projectasf.entity.UserSoftwareEntity;
import com.tasf.projectasf.model.ResponseProcess;
import com.tasf.projectasf.model.ResponseSale;
import com.tasf.projectasf.model.productValue;
import com.tasf.projectasf.repository.DetailSaleRepository;
import com.tasf.projectasf.repository.GeneralSaleRepository;
import com.tasf.projectasf.repository.ProductsRepository;
import com.tasf.projectasf.repository.UserSoftwareRepository;
import com.tasf.projectasf.util.ResponceProcessUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

/**
 *
 * @author FREDY
 */
@Service
public class GeneralSaleService implements IGeneralSaleService{
      
    @Autowired
    private UserSoftwareRepository userSoftwareRepository;
    @Autowired
    private GeneralSaleRepository generalSaleRepository; 
    @Autowired
    private DetailSaleRepository DetailSaleRepository;
    @Autowired
    private ProductsRepository productsRepository;
  
    @Override
    public ResponseProcess validationSearchSale(HttpHeaders header, long id){
        ResponseProcess resultProcess = new ResponseProcess();
        ResponceProcessUtil responUtil = new ResponceProcessUtil();
        Map<String,String> headers = header.toSingleValueMap();
        String apiKey = headers.get("apikey");
        if(apiKey != null && id > 0){
           resultProcess = processApiKey(apiKey,id);
        }else{
           resultProcess = responUtil.processResponse( false, true, "", "Falta Información" );
        }
        return resultProcess;
    }
    
    private ResponseProcess processApiKey (String apiKey,long id){
        ResponseProcess resultProcess = new ResponseProcess();
        ResponceProcessUtil responUtil = new ResponceProcessUtil();
        UserSoftwareEntity user = userSoftwareRepository.findByKey(apiKey);
        if(user != null){
            resultProcess = processSearchSale(id);
        }
        else{
           resultProcess = responUtil.processResponse( false, true, "", "Error Api key" );
        }
        return resultProcess;
    }
    
    private ResponseProcess processSearchSale(long id){
        ResponseProcess resultProcess = new ResponseProcess();
        ResponceProcessUtil responUtil = new ResponceProcessUtil();
        try{
        GeneralSaleEntity responSale = generalSaleRepository.findByConsecutiveSaleId(id);
        if(responSale != null){
            resultProcess =  processDetailSale(responSale);
        }else{
           resultProcess = responUtil.processResponse( false, true, "", "Factura no encontrada" );
        }
        }catch(Exception e){
           resultProcess = responUtil.processResponse( false, true, "", "Factura no encontrada" );
        }

        return resultProcess;
    }
    
    private ResponseProcess processDetailSale(GeneralSaleEntity responSale){
        ResponseProcess resultProcess = new ResponseProcess();
        ResponceProcessUtil responUtil = new ResponceProcessUtil();
        List<DetailSaleEntity> detailList = DetailSaleRepository.findByNumberSale(responSale.getConsecutiveSaleId());
        List<productValue> productList = new ArrayList<>();
        ResponseSale responseFacture = new ResponseSale();
        productValue productValue = new productValue();
        if(!detailList.isEmpty()){
            responseFacture.setSale(responSale);
            for(DetailSaleEntity detail : detailList){
               Optional<ProductsEntity> product = processSearchProduct(detail.getProductId());
               if(!product.isEmpty()){
                   productValue.setProductId(product.get().getProductId());
                   productValue.setNameProduct(product.get().getName());
                   productValue.setAmount(detail.getAmountProductSale());
                   productValue.setPriceProduct(detail.getPriceProduct());
                   productValue.setTotal(detail.getTotalPriceProduct());
                   productList.add(productValue);
               }
            }
            responseFacture.setListProduct(productList);
            Gson json = new Gson();
            resultProcess = responUtil.processResponse(true, false, json.toJson(responseFacture), "factura # : "+ responSale.getConsecutiveSaleId());
        }
        else{           
           resultProcess = responUtil.processResponse( false, true, "", "Error en Factura" );
        }
        return resultProcess;
    }
    
    private Optional<ProductsEntity> processSearchProduct(long productId){
        return productsRepository.findById(productId);
    }
}
