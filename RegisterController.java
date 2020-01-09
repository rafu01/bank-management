package javafxapplication13;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class RegisterController {

    @FXML
    private AnchorPane registerPane;
    @FXML
    private Label accountCreated;
    @FXML
    private Label accNo;
    @FXML
    private Label accountNumber;
    @FXML
    private TextField name;
    @FXML
    private TextField phone;
    @FXML
    private TextField address;
    @FXML
    private TextField email;
    @FXML
    private PasswordField password;
    @FXML
    private Label success;
    @FXML
    private Label incorrect;
    @FXML
    private Label cross;
    @FXML
    private Label invalidphone;
    @FXML
    private Label invalidemail;
    @FXML
    private Label emailcross;
    @FXML
    private Label numcross;
    @FXML
    private Label digit;

    @FXML
    private void loadHome(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        registerPane.getChildren().setAll(pane);
    }
    @FXML
    private void register(ActionEvent event) throws IOException{
        User user = new User();
        if(name.getText().equals("")||email.getText().equals("")||password.getText().equals("")||phone.getText().equals("")||address.getText().equals("")){
            incorrect.setText("Fill all information");
            cross.setText("X");
        } 
        else if(!email.getText().contains("@")|| (!phone.getText().matches("[0-9]+") || phone.getText().length()!=11)){
            if(!email.getText().contains("@")&&(!phone.getText().matches("[0-9]+") || (phone.getText().length()!=11))){
                emailcross.setText("X");
                invalidemail.setText("Invalid email");
                invalidphone.setText("Invalid Number");
                digit.setText("must contain 11 digits");
                numcross.setText("X");
            }
            else {
                if(!email.getText().contains("@")){
                invalidphone.setText("");
                digit.setText("");
                numcross.setText("");
                emailcross.setText("X");
                invalidemail.setText("Invalid email");
                }
                if(!phone.getText().matches("[0-9]+") || (phone.getText().length()!=11)){
                    emailcross.setText("");
                    invalidemail.setText("");
                    invalidphone.setText("Invalid Number");
                    digit.setText("must contain 11 digits");
                    numcross.setText("X");
                }
            }
            
        }
        else {
            user.takeNameInput(name.getText());
            user.takeEmailInput(email.getText());
            user.takePasswordInput(password.getText());
            user.takePhoneInput(phone.getText());
            user.takeAddressInput(address.getText());
            user.generateId();
            user.save();
            incorrect.setText("");
            cross.setText("");
            emailcross.setText("");
            invalidemail.setText("");
            invalidphone.setText("");
            digit.setText("");
            numcross.setText("");
            accountCreated.setText("Account Created");
            success.setText("Successfully");
            accNo.setText("Account Number:");
            accountNumber.setText(user.getId()+"");
        }
  
    }
    
}
