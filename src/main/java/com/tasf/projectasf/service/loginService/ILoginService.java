/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tasf.projectasf.service.loginService;

import com.tasf.projectasf.dto.LoginDto;
import com.tasf.projectasf.model.ResponseProcess;


/**
 *
 * @author FREDY
 */
public interface ILoginService {
    ResponseProcess login(LoginDto requestBodyLogin);
}
