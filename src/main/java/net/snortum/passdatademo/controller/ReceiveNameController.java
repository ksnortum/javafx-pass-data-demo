package net.snortum.passdatademo.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import net.snortum.passdatademo.model.DataHolder;

public class ReceiveNameController {
    @FXML private Label receiveNameLabel;

    public void bindName(DataHolder holder) {
    	receiveNameLabel.textProperty().bind(holder.getNameProperty());
    }
}