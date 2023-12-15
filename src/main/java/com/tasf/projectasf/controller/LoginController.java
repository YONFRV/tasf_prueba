/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tasf.projectasf.controller;

import com.tasf.projectasf.dto.LoginDto;
import com.tasf.projectasf.model.ResponseProcess;
import com.tasf.projectasf.service.loginService.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;

/**
 *
 * @author FREDY
 */
@Controller
@RequestMapping("api/v1")
@CrossOrigin(origins = {"*"})
public class LoginController {
    
    @Autowired
    private ILoginService iLoginService;
       
    @PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseProcess> loginProcess(@RequestBody LoginDto requestBodyLogin) {
        ResponseProcess result = iLoginService.login(requestBodyLogin);
        if(result.isSuccess()){
            return new ResponseEntity<>(result, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
    }
}
