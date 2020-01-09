
package javafxapplication13;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class AccountdataController implements Initializable{

    @FXML
    private AnchorPane loginData;
    @FXML
    private TextField amount1;
    @FXML
    private TextField year;
    @FXML
    private TextField amount2;
    @FXML
    private Label balance;
    static int account;
    SavingsAccount user = new SavingsAccount();
    @FXML
    private Label yourInterest;
    @FXML
    private Label incorrect2;
    @FXML
    private Label cross2;
    @FXML
    private Button checkBalance;
    @FXML
    private Button add;
    @FXML
    private Button withdraw;
    @FXML
    private Button interest;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    public void transferMessage(int acc) {
        account = acc;
    }
    @FXML
    private void loadLogin(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("FXML2Login.fxml"));
        loginData.getChildren().setAll(pane);
    }
    @FXML
    private void checkBalance(ActionEvent event) throws IOException{
        user.accountNumber = account;
        balance.setText(user.checkBalance()+"");
    }
    @FXML
    private void add(ActionEvent event) throws IOException{
        user.accountNumber = account;
        balance.setText(user.addBalance(Double.parseDouble(amount1.getText()))+"");
        yourInterest.setText("Current Balance");
        incorrect2.setText("");
        cross2.setText("");
    }
    @FXML
    private void withdraw(ActionEvent event) throws IOException{
        user.accountNumber = account;
        double amount = Double.parseDouble(amount2.getText());
        if(amount<=user.checkBalance()){
            balance.setText(user.withdrawBalance(amount)+"");
        }
        else {
            balance.setText(user.checkBalance()+"");
            yourInterest.setText("Current Balance");
            incorrect2.setText("Amount can't be more than Balance");
            cross2.setText("X");
        }
    }
    @FXML
    private void checkInterest(ActionEvent event) throws IOException{
        user.accountNumber = account;
        yourInterest.setText("Your Interest:");
        balance.setText(user.calculateInterest(Integer.parseInt(year.getText()))+"");
        incorrect2.setText("");
        cross2.setText("");
    }
}
