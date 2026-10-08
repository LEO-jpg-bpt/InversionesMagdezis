package main.java.com.magdezis.loginmagdezis.service;

import main.java.com.ingsf.abarroteria.security.BCrypt;
import main.java.com.macizo.loginmacizo.dto.request.LoginDTORequest;
import main.java.com.macizo.loginmacizo.dto.response.LoginDTOResponse;
import main.java.com.macizo.loginmacizo.repository.MacizoRepository;

/**
 *
 * @author informatica
 */
public class MagdezisService {
     private final MagdezisRepository Repository;
 
    public MagdezisService(MagdezisRepository Repository) {
        this.Repository = Repository;
    }
    public LoginDTOResponse login(LoginDTORequest request){
        if(request == null){
            throw new RuntimeException("Los datos están vacios");
        }else if(request.getEmail() == null || request.getPassword() == null){
            throw new RuntimeException("Uno o los dos campos están vacios");           
        }else if(request.getEmail().isEmpty() || request.getPassword().isEmpty()){
            throw new RuntimeException("No puedes dejar compos en blanco");
        }
        LoginDTOResponse response = Repository.findUserByEmail(request);
        if(response.getContrasenaHash() == null){
            throw new RuntimeException("No se ha podido concretar la operación.");
        }else{
            if(BCrypt.checkpw(request.getPassword(), response.getContrasenaHash())){
                return response; 
//LoginDTOResponse(response.getNombre(), response.getApellido(), response.getNombreRol());
            }
        }
        return null;
    }
}
