/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tasf.projectasf.util;

import com.tasf.projectasf.model.ResponseProcess;

/**
 *
 * @author FREDY
 */
public class ResponceProcessUtil {
    
    public ResponseProcess processResponse(boolean success, boolean warning, String data, String menssage ){
        ResponseProcess respon = new ResponseProcess();
        respon.setData(data);
        respon.setMenssage(menssage);
        respon.setSuccess(success);
        respon.setWarning(warning);
        return respon;
    }
    
}
