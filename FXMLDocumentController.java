
package javafxapplication13;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class FXMLDocumentController implements Initializable {
    @FXML
    private AnchorPane rootPane;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    @FXML
    public void loadLogin(ActionEvent event) throws IOException{
        AnchorPane pane = FXMLLoader.load(getClass().getResource("FXML2Login.fxml"));
        rootPane.getChildren().setAll(pane);
    }
    @FXML
    public void loadRegister(ActionEvent event) throws IOException{
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Register.fxml"));
        rootPane.getChildren().setAll(pane);
    }
    
}
