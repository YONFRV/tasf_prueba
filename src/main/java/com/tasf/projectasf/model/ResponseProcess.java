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
public class ResponseProcess {
    private boolean success;    
    private boolean warning;
    private String Data;
    private String menssage;
}
