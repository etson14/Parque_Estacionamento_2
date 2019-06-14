
package parque_estacionamento_2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Parque_Estacionamento_2 extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        
       
    Parent root = FXMLLoader.load(getClass().getResource("/parque_estacionamento_2/view/TelaAdminSistema.fxml"));
        Scene scene = new Scene(root);
       
        stage.setTitle("Parque Estacionamento - Uni Piaget");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();

        
    }

   
    public static void main(String[] args) {
        
       launch(args);
         
    }
    
}
