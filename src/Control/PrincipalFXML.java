
package Control;

import javafx.scene.image.Image;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class PrincipalFXML extends Application {
    
 @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(PrincipalFXML.class.getResource("/Vista/Bienvenida.fxml"));
        Pane root = (Pane)loader.load();
        
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/Estilos/botones.css").toString());
        

        stage.getIcons().add(new Image(PrincipalFXML.class.getResourceAsStream("/Imagen/icono.png")));
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
