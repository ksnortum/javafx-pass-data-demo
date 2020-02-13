package net.snortum.passdatademo.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class DataHolder {
	
	private StringProperty name = new SimpleStringProperty();
	
	public void setName(String name) {
		this.name.set(name);
	}
	
	public String getName() {
		return name.get();
	}
	
	public StringProperty getNameProperty() {
		return name;
	}
}
