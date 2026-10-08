package main.java.com.magdezis.loginmagdezis;
import javafx.application.Application;
import javafx.application.Application.launch;
import javafx.stage.Stage;
import main.java.com.macizo.loginmacizo.util.SceneManager;



public class MainApp extends Application{
    //atributo
    private Stage stage;
    
    @Override 
    public void start(Stage stage ) throws Exception{
       this.stage  = stage;
       SceneManager sceneManager = new SceneManager(stage);
       sceneManager.showLoginView();
       stage.show();
    }
   
    public static void main(String[] args) {
     launch();
    }
    
}
