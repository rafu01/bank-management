
package javafxapplication13;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class FXML2LoginController implements Initializable {
    @FXML
    private AnchorPane loginPane;
    @FXML
    private TextField email1;
    @FXML
    private PasswordField password1;
    @FXML
    private TextField adminemail;
    @FXML
    private PasswordField adminpass;
    @FXML
    private Label incorrect;
    @FXML
    private Label cross;
    @FXML
    private Label incorrect2;
    @FXML
    private Label cross2;
    SavingsAccount user = new SavingsAccount();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    @FXML
    public void loadHome(ActionEvent event) throws IOException{
        AnchorPane pane = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        loginPane.getChildren().setAll(pane);
    }
    @FXML
    public void submit1(ActionEvent event) throws IOException{
        String id = email1.getText();
        String pass = password1.getText();
        if(id.equals("")){
            cross.setText("X");
            incorrect.setText("Provide information");
        }
        else if(user.access(Integer.parseInt(id),pass)){
            user.accountNumber = Integer.parseInt(id);
            AccountdataController scene2Controller = new AccountdataController();
            scene2Controller.transferMessage(user.accountNumber);
            AnchorPane pane = FXMLLoader.load(getClass().getResource("Accountdata.fxml"));
            loginPane.getChildren().setAll(pane);
        }
        else {
            cross.setText("X");
            incorrect.setText("Incorrect Information");
            incorrect2.setText("");
            cross2.setText("");
        }
    }
    @FXML
    public void submit2(ActionEvent event) throws IOException{
       if(adminemail.getText().equals("admin") && adminpass.getText().equals("admin1")){
            AnchorPane pane = FXMLLoader.load(getClass().getResource("AdminData.fxml"));
            loginPane.getChildren().setAll(pane);
       }
       else{
           cross.setText("");
           incorrect.setText("");
           incorrect2.setText("Invalid information");
           cross2.setText("X");
       }
    }
}
