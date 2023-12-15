/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tasf.projectasf.segurity;

import java.security.MessageDigest;
import org.springframework.stereotype.Component;

/**
 *
 * @author FREDY
 */
@Component
public class GeneratePasswordEncrypted {
    
    public String encryptPassword(String password){
       	MessageDigest md = null;
                try{        
                    md = MessageDigest.getInstance("SHA-256");
                    }
                    catch (Exception e) {		
		e.printStackTrace();
	}
        byte[] hash = md.digest(password.getBytes());
	StringBuffer sb = new StringBuffer();
	for(byte b : hash) {        
		sb.append(String.format("%02x", b));
	}
        return sb.toString();
    }
}
