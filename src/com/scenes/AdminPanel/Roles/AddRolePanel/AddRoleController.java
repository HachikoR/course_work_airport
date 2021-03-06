package com.scenes.AdminPanel.Roles.AddRolePanel;

import com.App;
import com.assets.services.Exceptions.NoServerResponseException;
import com.assets.services.Exceptions.ResponseException;
import com.assets.services.Requests;
import com.scenes.GeneralScenes.ModalWindow.ModalWindow;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class AddRoleController {
    @FXML
    private TextField roleField;

    public void submit() {
        String newRole = roleField.getText().trim();

        //Validation
        if (newRole.equals("") || newRole.length() > 255) {
            ModalWindow.show("Error", "Role cannot be empty or longer than 255 characters", ModalWindow.Icon.error);
            return;
        }

        //API Request
        try {
            Requests.addRole(newRole, App.getAccessToken());

            //Reset field
            roleField.setText("");

            ModalWindow.show("Success", "Role has added", ModalWindow.Icon.success);
        } catch (NoServerResponseException | ResponseException e) {
            ModalWindow.show("Error", e.getSuspendedMessage()+"\nRole has not added", ModalWindow.Icon.error);
        }
    }
}
