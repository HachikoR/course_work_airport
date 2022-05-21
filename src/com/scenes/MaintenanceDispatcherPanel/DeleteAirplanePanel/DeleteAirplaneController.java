package com.scenes.MaintenanceDispatcherPanel.DeleteAirplanePanel;

import com.App;
import com.assets.services.Exceptions.CustomException;
import com.assets.services.Exceptions.NoServerResponseException;
import com.assets.services.Exceptions.ResponseException;
import com.assets.services.Requests;
import com.scenes.ModalWindow.ModalWindow;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class DeleteAirplaneController {
    @FXML
    private ComboBox<String> airplaneNumberComboBox;

    public void submit() {
        String number = airplaneNumberComboBox.getValue();
        if (number == null || !DeleteAirplanePanel.airplaneNumbersId.containsKey(number)) {
            ModalWindow.show("Error", "Invalid airplane number selected.\n", ModalWindow.Icon.error);
            return;
        }

        try {
            Requests.deleteAirplane(DeleteAirplanePanel.airplaneNumbersId.get(number), App.getAccessToken());
            airplaneNumberComboBox.getItems().remove(number);
            airplaneNumberComboBox.setValue(null);
            ModalWindow.show("Error", "Airplane has removed.\n", ModalWindow.Icon.success);
        } catch (NoServerResponseException | ResponseException e) {
            ModalWindow.show("Error", e.getSuspendedMessage() + "\nAirplane has not removed.\nTry again.", ModalWindow.Icon.error);
            ((Stage) airplaneNumberComboBox.getScene().getWindow()).close();
        }
    }
}