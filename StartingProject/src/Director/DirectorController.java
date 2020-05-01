package Director;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import dbUtil.dbConnection;

public class DirectorController implements Initializable {

	@FXML
	private TextField id;
	@FXML 
	private TextField name;
	@FXML
	private DatePicker dob;
	@FXML 
	private TextField contact;
	@FXML
	private TextField department;
	@FXML
	private TextField ID;
	@FXML 
	private TextField project;
	@FXML
	private TextArea comments;
	@FXML
	private DatePicker date;
	
	@FXML
	private TableView<EmployeeData> employeetable;
	@FXML
	private TableView<ProjectToAssign> projecttable;
	
	@FXML
	private TableColumn<EmployeeData, String> idcol;
	@FXML
	private TableColumn<EmployeeData, String> namecol;
	@FXML
	private TableColumn<EmployeeData, String> dobcol;
	@FXML
	private TableColumn<EmployeeData, String> contactcol;
	@FXML
	private TableColumn<EmployeeData, String> departmentcol;
	@FXML
	private TableColumn<ProjectToAssign, String> IDcol;
	@FXML
	private TableColumn<ProjectToAssign, String> commentscol;
	@FXML
	private TableColumn<ProjectToAssign, String> projectcol;
	@FXML
	private TableColumn<ProjectToAssign, String> datecol;
	
	private Button loadButton;
	private Button projectload;
	private dbConnection dc;
	private ObservableList<EmployeeData> data ;
	private ObservableList<ProjectToAssign> data2;
	

	
	public void initialize(URL url, ResourceBundle rb) {
		
		this.dc = new dbConnection();
	}
	
	@FXML
	private void loadEmployeeData(ActionEvent event) throws SQLException {
		try {
			Connection connec = dbConnection.getConnection();
			this.data = FXCollections.observableArrayList();
			
			ResultSet rs = connec.createStatement().executeQuery("SELECT * FROM Employee");
			while (rs.next()) {
				this.data.add(new EmployeeData(rs.getString(1),rs.getString(2),rs.getString(3), rs.getString(4),rs.getString(5)));
				
			}
		}
		
		catch (SQLException e) {
		System.err.println("Error");
		}

	this.idcol.setCellValueFactory(new PropertyValueFactory("ID") );
	this.namecol.setCellValueFactory(new PropertyValueFactory("Name") );
	this.dobcol.setCellValueFactory(new PropertyValueFactory("DateOfBirth") );
	this.contactcol.setCellValueFactory(new PropertyValueFactory("Contact") );
	this.departmentcol.setCellValueFactory(new PropertyValueFactory("Department") );
	
	this.employeetable.setItems(null);
	this.employeetable.setItems(this.data);
	
	}
	
	
	
	
	@FXML
	private void loadProjectData() throws SQLException {
		try {
			Connection connec = dbConnection.getConnection();
			this.data2 = FXCollections.observableArrayList();
			
			ResultSet rs = connec.createStatement().executeQuery("SELECT * FROM Projects");
			while (rs.next()) {
				this.data2.add(new ProjectToAssign(rs.getString(1),rs.getString(2),rs.getString(3), rs.getString(4)));
				
			}
		}
		
		catch (SQLException e) {
		System.err.println("Error");
		}

	this.IDcol.setCellValueFactory(new PropertyValueFactory("ID") );
	this.projectcol.setCellValueFactory(new PropertyValueFactory("Project") );
	this.commentscol.setCellValueFactory(new PropertyValueFactory("Comments") );
	this.datecol.setCellValueFactory(new PropertyValueFactory("Date") );
	
	
	this.projecttable.setItems(null);
	this.projecttable.setItems(this.data2);
	
	
	}
	
	
	
	
	@FXML
	private void addEmployee(ActionEvent event) {
		String sql = "INSERT INTO 'Employee'('ID','Name','DateOfBirth','Contact','Department') VALUES (?,?,?,?,?)";
		
		try {
			Connection connec = dbConnection.getConnection();
			PreparedStatement stmt = connec.prepareStatement(sql);
			
			stmt.setString(1, this.id.getText());
			stmt.setString(2, this.name.getText());
			stmt.setString(3, this.dob.getEditor().getText());
			stmt.setString(4, this.contact.getText());
			stmt.setString(5, this.department.getText());
			
			
			stmt.execute();
			connec.close();
		}
		catch(SQLException e) {
			 System.err.println("Got an exception!");
		      System.err.println(e.getMessage());
		}
	}
	
	
	
	@FXML
	private void addProject(ActionEvent event) {
		String sql = "INSERT INTO Projects('ID','Project','Comments','Date') VALUES (?,?,?,?)";
		
		try {
			Connection connec = dbConnection.getConnection();
			PreparedStatement stmt = connec.prepareStatement(sql);
			
			stmt.setString(1, this.ID.getText());
			stmt.setString(2, this.project.getText());
			stmt.setString(3, this.comments.getText());
			stmt.setString(4, this.date.getEditor().getText());
			
			stmt.execute();
			connec.close();
		}
		catch(SQLException e) {
			 System.err.println("Got an exception!");
		      System.err.println(e.getMessage());
		}
	}
	
	
	
	@FXML
	private void clearFields(ActionEvent event) {
		this.id.setText("");
		this.name.setText("");
		this.dob.setValue(null);
		this.contact.setText("");
		this.department.setText("");
		this.ID.setText("");
		this.project.setText("");
		this.comments.setText("");
		this.date.setValue(null);
		
	}
	
	
	@FXML
	private void delete(ActionEvent event) {
		String sql ="DELETE FROM Employee WHERE ID = ? AND Name = ? AND DateOfBirth = ? AND Contact = ? AND Department = ?";
		try {
			Connection connec = dbConnection.getConnection();
			PreparedStatement stmt = connec.prepareStatement(sql);
			
			stmt.setString(1, this.id.getText());
			stmt.setString(2, this.name.getText());
			stmt.setString(3, this.dob.getEditor().getText());
			stmt.setString(4, this.contact.getText());
			stmt.setString(5, this.department.getText());
			
			
			stmt.execute();
			connec.close();
		}
		catch (SQLException e) {
	    	e.printStackTrace();
	        
	    }
	}
	
	@FXML
	private void deletepro(ActionEvent event) {
		String sql ="DELETE FROM Projects WHERE ID = ? AND Project = ? AND Comments = ? AND Date = ?";
		try {
			Connection connec = dbConnection.getConnection();
			PreparedStatement stmt = connec.prepareStatement(sql);
			
			stmt.setString(1, this.ID.getText());
			stmt.setString(2, this.project.getText());
			stmt.setString(3, this.comments.getText());
			stmt.setString(4, this.date.getEditor().getText());
			
			
			stmt.execute();
			connec.close();
		}
		catch (SQLException e) {
	    	e.printStackTrace();
	        
	    }
	}
	
		

}