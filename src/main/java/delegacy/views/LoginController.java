package delegacy.views;

import delegacy.App;
import delegacy.dao.impl.AdminDaoImpl;
import delegacy.model.Admin;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {
private AdminDaoImpl dao = new AdminDaoImpl();
	
	@FXML
	private TextField usernameField;
	
	@FXML
	private PasswordField passwordField;
	
	@FXML
	private Label errorLabel;
	
	@FXML
	private Button loginButton;
	
	@FXML
	private void initialize(){
		errorLabel.setText("");
	}
	
	@FXML
	private void userLoginAction(){
		try{
			Admin admin = dao.Login(usernameField.getText(), passwordField.getText());
			App.getInstance().setAdmin(admin);
			App.getInstance().changeView("saveCar");
		}catch(Exception e){
			errorLabel.setText(e.getMessage());
		}
	}
}
