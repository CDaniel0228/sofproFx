
package Control;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


public class BienvenidaController implements Initializable {

    @FXML
    private ProgressBar barraProgresiva;
    @FXML
    private ImageView logotipo;
    @FXML
    private Button btnSiguiente;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnSiguiente.setVisible(false);
        addImagen();
        barra();
    }
    
     @FXML
    private void onClick(ActionEvent event) {
        siguiente();
    }

    public void barra(){
        TimerTask timerTask = new TimerTask(){
        float count=0;
        @Override
        public void run(){            
            barraProgresiva.setProgress(count+=0.01);
            if(barraProgresiva.getProgress()>=1){
                cancel();
                btnSiguiente.setVisible(true);
            }
        }}; 
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(timerTask, 0, 100); 
     
    }
    
    public void addImagen(){
        logotipo.setImage(new Image(BienvenidaController.class.getResourceAsStream("/Imagen/icono.png")));
    }
    
    public void siguiente(){
        try {    
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/DrawerFXML.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            Stage stage = new Stage();

            stage.setScene(scene);
            stage.show();

            Stage myStage = (Stage) this.barraProgresiva.getScene().getWindow();
            myStage.close();
            
        } catch (IOException ex) {
             Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }

   
    
}
