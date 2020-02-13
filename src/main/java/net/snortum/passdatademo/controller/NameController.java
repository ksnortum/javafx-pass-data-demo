package net.snortum.passdatademo.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import net.snortum.passdatademo.model.DataHolder;

public class NameController {

    @FXML
    private TextField nameText;

    @FXML
    private Button okButton;
    
    private DataHolder holder;

    @FXML
    void okButtonHandler(ActionEvent event) {
    	getDataHolder().setName(nameText.getText());
    }

    public DataHolder getDataHolder() {
    	return holder;
    }
    
    public void setDataHolder(DataHolder holder) {
    	this.holder = holder;
    }
}
