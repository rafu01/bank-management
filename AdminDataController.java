
package javafxapplication13;

import java.io.FileNotFoundException;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class AdminDataController {

    @FXML
    private AnchorPane loginData;
    @FXML
    private TextField checkInterest;
    @FXML
    private TextField enterInterest;
    @FXML
    private Label incorrect;
    @FXML
    private Label cross;
    @FXML
    private void loadLogin(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("FXML2Login.fxml"));
        loginData.getChildren().setAll(pane);
    }
    @FXML
    private void checkInterest(ActionEvent event) throws FileNotFoundException{
        Admin admin = new Admin();
        checkInterest.setText(admin.checkInterest()+"");
    }
    @FXML
    private void changeInterest(ActionEvent event) throws IOException{
        Admin admin = new Admin();
        double ni = Double.parseDouble(enterInterest.getText());
        if(ni>0){
            admin.changeInterest(ni);
            checkInterest.setText("");
            incorrect.setText("");
            cross.setText("");
        }
        else{
            incorrect.setText("Interest rate must be greater than 0");
            cross.setText("X");
        }
    }
    
}
