package main.java.com.magdezis.loginmagdezis.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import main.java.com.macizo.loginmacizo.dto.request.LoginDTORequest;
import main.java.com.macizo.loginmacizo.dto.response.LoginDTOResponse;
import main.java.com.macizo.loginmacizo.service.MacizoService;
import main.java.com.macizo.loginmacizo.util.SceneManager;


public class MagdezisController implements Initializable {
       private final MagdezisService Service;
    private final SceneManager sceneManager;

    @FXML
    private Button btnIniciarSesion;

    @FXML
    private TextField txtFieldEmail;

    @FXML
    private TextField txtFieldPassword;
 
    public MacizoController(MacizoService Service, SceneManager sceneManager) {

        this.Service = Service;
        this.sceneManager = sceneManager;

    }
 
    @Override

    public void initialize(URL url, ResourceBundle rb) {

        // TODO

    }
   
    public void handleLogin(){

        if(txtFieldEmail.getText().isEmpty() || txtFieldPassword.getText().isEmpty()){

            throw new RuntimeException("Los campos están vacios");

        }else{
               try{
            LoginDTOResponse response =Service.login(new LoginDTORequest(txtFieldEmail.getText(), txtFieldPassword.getText()));
            sceneManager.showAlertInfo("Bienvenido", "Es bueno verte"+response.getNombre(),"Inicio de sesion correcto. " , Alert.AlertType.INFORMATION);
               }catch(RuntimeException e){
                   sceneManager.showAlertInfo("ERROR", "Verifica los Campos", "No se Ah podido iniciar sesion", Alert.AlertType.WARNING);
               }
        }

    }


}
