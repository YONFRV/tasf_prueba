package com.tasf.projectasf.service.loginService;

import com.google.gson.Gson;
import com.tasf.projectasf.dto.LoginDto;
import com.tasf.projectasf.entity.UserSoftwareEntity;
import com.tasf.projectasf.model.ResponseLogin;
import com.tasf.projectasf.model.ResponseProcess;
import com.tasf.projectasf.repository.UserSoftwareRepository;
import com.tasf.projectasf.segurity.GeneratePasswordEncrypted;
import com.tasf.projectasf.util.ResponceProcessUtil;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author FREDY
 */
@Service
public class LoginService implements ILoginService {
    
    @Autowired
    private UserSoftwareRepository userSoftwareRepository;
    
    @Override
    public ResponseProcess login(LoginDto requestBodyLogin){
        ResponseProcess resultProcess = new ResponseProcess();
        ResponceProcessUtil responUtil = new ResponceProcessUtil();
        if(requestBodyLogin.getUser() != null){
            resultProcess = validationPassword(requestBodyLogin);
        }
        else{
            resultProcess = responUtil.processResponse( false, true, "", "Falta Información" );
        }
        return resultProcess;
    }
    
    private ResponseProcess validationPassword(LoginDto requestBodyLogin){
        ResponseProcess resultProcess = new ResponseProcess();
        ResponceProcessUtil responUtil = new ResponceProcessUtil();
         if(requestBodyLogin.getPassword() != null){
            resultProcess = verificationPasswordAndUser(requestBodyLogin);
        }
        else{
            resultProcess = responUtil.processResponse( false, true, "", "Falta Información" );
        }
        return resultProcess;
    }
    
    private ResponseProcess verificationPasswordAndUser(LoginDto requestBodyLogin){
        ResponseProcess resultProcess = new ResponseProcess();
        ResponceProcessUtil responUtil = new ResponceProcessUtil();
        Gson json = new Gson();
        GeneratePasswordEncrypted processSegurity =new  GeneratePasswordEncrypted();
        String password = processSegurity.encryptPassword(requestBodyLogin.getPassword());
        UserSoftwareEntity userSoftware = userSoftwareRepository.findByUserSoftware(requestBodyLogin.getUser());
        if(userSoftware != null){
            if(userSoftware.getPassword().equals(password)){
                Date myDate = new Date();
                String key =myDate+userSoftware.getPassword()+userSoftware.getUserSoftware();
                String api_key = processSegurity.encryptPassword(key);
                userSoftware.setKey(api_key);
                userSoftwareRepository.save(userSoftware);
                ResponseLogin dataUserSoftw = new ResponseLogin();
                dataUserSoftw.setApikey(api_key);
                dataUserSoftw.setUserName(requestBodyLogin.getUser());
                resultProcess = responUtil.processResponse( true, false, json.toJson(dataUserSoftw),"login" );
                return resultProcess;
            }
        }
        resultProcess = responUtil.processResponse( false, true, "", "Usuario o Contraseña erroneas" );
        return resultProcess;
    }
}
