package Director;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class EmployeeData {

	private final StringProperty ID;
    private final StringProperty Name;
	private final StringProperty DateOfBirth;
	private final StringProperty Contact;
	private final StringProperty Department;
	
	
	public EmployeeData(String id, String name, String dob, String contact, String department) {
		
		this.ID = new SimpleStringProperty(id);
		this.Name = new SimpleStringProperty(name);
		this.DateOfBirth = new SimpleStringProperty(dob);
		this.Contact = new SimpleStringProperty(contact);
		this.Department = new SimpleStringProperty(department);
		
	}
	 public String getID()
	  {
	    return (String)this.ID.get();
	  }
	  
	  public String getName()
	  {
	    return (String)this.Name.get();
	  }
	  
	  public String getDateOfBirth()
	  {
	    return (String)this.DateOfBirth.get();
	  }
	  
	  public String getContact()
	  {
	    return (String)this.Contact.get();
	  }
	  
	  public String getDepartment()
	  {
	    return (String)this.Department.get();
	  }
	  
	 
	  
	  public void setID(String value)
	  {
	    this.ID.set(value);
	  }
	  
	  public void setName(String value)
	  {
	    this.Name.set(value);
	  }
	  
	  public void setDateOfBirth(String value)
	  {
	    this.DateOfBirth.set(value);
	  }
	  
	  public void setContact(String value)
	  {
	    this.Contact.set(value);
	  }
	  
	  public void setDepartment(String value)
	  {
	    this.Department.set(value);
	  }
	  

	  
	  public StringProperty idProperty() {
		  return this.ID;
	  }
	  
	  public StringProperty nameProperty() {
		  return this.Name;
	  }
	  
	  public StringProperty dobProperty() {
		  return this.DateOfBirth;
	  }
	  
	  public StringProperty contactProperty() {
		  return this.Contact;
	  }
	  
	  public StringProperty departmentProperty() {
		  return this.Department;
	  }
	  
	
	  
	  
	
}