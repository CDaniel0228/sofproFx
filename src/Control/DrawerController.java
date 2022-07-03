
package Control;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class DrawerController implements Initializable {

    @FXML
    private Pane homePanel;
    @FXML
    private Button btnProducto;
    @FXML
    private Button btnCaracteristica;
    @FXML
    private Button btnEvaluar;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        panelProducto();
    } 
    
    private void panelProducto(){          
        try {  
            homePanel.getChildren().clear();  
            homePanel.getChildren().add(FXMLLoader.load(getClass().getResource("/Vista/HomeFXML.fxml")));   
        } catch (IOException ex) {
             Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }        
        
    }

    @FXML
    private void onClick(ActionEvent evt) {
        if(evt.getSource()==btnProducto){
            panelProducto();
        }
        else if(evt.getSource()==btnCaracteristica){
            try {   
                homePanel.getChildren().clear(); 
                homePanel.getChildren().add(FXMLLoader.load(getClass().getResource("/Vista/CaracteristicasFXML.fxml")));   
            } catch (IOException ex) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            }   
        }else if(evt.getSource()==btnEvaluar){
            try {   
                homePanel.getChildren().clear(); 
                homePanel.getChildren().add(FXMLLoader.load(getClass().getResource("/Vista/EvaluarFXML.fxml")));   
            } catch (IOException ex) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            }  
        }
    }
    
     
    
}
