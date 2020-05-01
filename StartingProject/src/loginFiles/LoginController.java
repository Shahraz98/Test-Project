package loginFiles;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import Director.DirectorController;
import Employee.EmployeeController;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;




public class LoginController implements Initializable {
	 LoginModel loginModel = new LoginModel();
	 
	  @FXML
	  private Label dbstatus;
	  @FXML
	  private TextField username;
	  @FXML
	  private PasswordField password;
	  @FXML
	  private ComboBox<Option> combobox;
	  @FXML
	  private Button loginButton;
	  
	  public void initialize(URL url, ResourceBundle rb)
	  {
	    if (this.loginModel.isDatabaseConnected()) {
	      this.dbstatus.setText("Connected to the DB");
	    } else {
	      this.dbstatus.setText("Not Connected to the DB");
	    }
	    this.combobox.setItems(FXCollections.observableArrayList(Option.values()));
	  }
	  
	  @FXML
	  public void Login(ActionEvent event)
	  {
	    try
	    {
	      if (this.loginModel.isLogin(this.username.getText(), this.password.getText(), ((Option)this.combobox.getValue()).toString()))
	      {
	        Stage stage = (Stage)this.loginButton.getScene().getWindow();
	        stage.close();
	        switch (((Option)this.combobox.getValue()).toString())
	        {
	        case "Director": 
	          directorLogin();
	          break;
	        case "Employee": 
	          employeeLogin();
	        }
	      }
	      else
	      {
	        this.dbstatus.setText("Wrong Creditials");
	      }
	    }
	    catch (Exception localException) {}
	  }
	  
	  
	  public void employeeLogin()
	  {
	    try
	    {
	      Stage empStage = new Stage();
	      FXMLLoader emploader = new FXMLLoader();
	      Pane root = (Pane)emploader.load(getClass().getResource("/Employee/Employee.fxml").openStream());
	      EmployeeController empController = (EmployeeController)emploader.getController();
	      
	      Scene scene = new Scene(root);
	      empStage.setScene(scene);
	      empStage.setTitle("Employee Dashboard");
	      empStage.setResizable(false);
	      empStage.show();
	    }
	    catch (IOException e)
	    {
	      e.printStackTrace();
	    }
	  }

	  public void directorLogin()
	  {
	    try
	    {
	      Stage dirStage = new Stage();
	      FXMLLoader dirLoader = new FXMLLoader();
	      Pane dirroot = (Pane)dirLoader.load(getClass().getResource("/Director/Director.fxml").openStream());
	      DirectorController dirController = (DirectorController)dirLoader.getController();
	      
	      Scene dirscene = new Scene(dirroot);
	      
	      dirStage.setScene(dirscene);
	      dirStage.setTitle("Director Dashboard");
	      dirStage.setResizable(true);
	      dirStage.show();
	    }
	    catch (IOException e)
	    {
	      e.printStackTrace();
	    }
	  }
	}