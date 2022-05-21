package com.scenes.AdminPanel.AddRolePanel;

import com.assets.services.InteractingWithWindow;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

import java.io.IOException;

public class AddRolePanel {
    public static void showModal(){
        //Open needed window
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(AddRolePanel.class.getResource("AddRolePanel.fxml"));
        InteractingWithWindow.showModal(stage, loader);
        stage.centerOnScreen();
        stage.show();
    }
}