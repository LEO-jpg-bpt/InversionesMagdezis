package main.java.com.magdezis.loginmagdezis.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import main.java.com.macizo.loginmacizo.controller.MacizoController;
import main.java.com.macizo.loginmacizo.repository.MacizoRepository;
import main.java.com.macizo.loginmacizo.service.MacizoService;

/**
 *
 * @author informatica
 */
public class SceneManager {
    //atributos
    private final Stage stage;
    
    //constructor
    public SceneManager(Stage stage ){
        this.stage = stage;
    }
     
   //metodos
    public void showLoginView() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/main/resources/view/login-view.fxml"));
        
        loader.setControllerFactory(
            clazz -> {
                if(clazz == MagdezisController.class) {  
                   MagdezisRepository authRepository = new MagdezisRepository();
                   MagdezisService authService = new MagdezisService(authRepository);
                   return new MagdezisController(authService, this);
                }
                try{
                    return clazz.getDeclaredConstructor().newInstance();
                } catch(Exception e) {
                    throw new RuntimeException("error al crear el constructor " + e.getMessage());
                }
            } 
        );
        
        Parent root = loader.load();
        Scene scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.setResizable(false);
        
        // --- AÑADIR EL ÍCONO AQUÍ ---
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/main/java/com/macizo/loginmacizo/resource/MacizoLogo.jpg")));
        
        stage.show();
    }
    
  //alerta modal reutilizable
    public void showAlertInfo(String head, String title, String content, AlertType type){
        Alert alert = new Alert(type);
        alert.initOwner(this.stage);
        alert.setTitle(title);
        alert.setHeaderText(head); // Añadido por si querías usar el parámetro head que recibías
        alert.setContentText(content);
        alert.showAndWait();                                                                                                                               
    }
}