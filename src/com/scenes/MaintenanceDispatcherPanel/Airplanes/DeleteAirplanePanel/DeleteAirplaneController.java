package com.scenes.MaintenanceDispatcherPanel.Airplanes.DeleteAirplanePanel;

import com.App;
import com.assets.components.AutoCompleteComboBoxListener;
import com.assets.services.Exceptions.NoServerResponseException;
import com.assets.services.Exceptions.ResponseException;
import com.assets.services.Requests;
import com.scenes.GeneralScenes.ModalWindow.ModalWindow;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

public class DeleteAirplaneController {
    @FXML
    private ComboBox<String> airplaneNumberComboBox;

    public void submit() {
        String number = airplaneNumberComboBox.getValue();
        number = number == null ? "" : number;

        //Validation data
        if (!DeleteAirplanePanel.airplaneNumbersId.containsKey(number)) {
            ModalWindow.show("Error", "Invalid airplane number selected.\n", ModalWindow.Icon.error);
            return;
        }

        //API Request
        try {
            Requests.deleteAirplane(DeleteAirplanePanel.airplaneNumbersId.get(number), App.getAccessToken());

            //Reset and update combobox
            airplaneNumberComboBox.getItems().remove(number);
            airplaneNumberComboBox.setValue("");
            DeleteAirplanePanel.airplaneNumbersId.remove(number);

            ModalWindow.show("Success", "Airplane has removed.\n", ModalWindow.Icon.success);
        } catch (NoServerResponseException | ResponseException e) {
            ModalWindow.show("Error", e.getSuspendedMessage() + "\nAirplane has not removed.\nTry again.", ModalWindow.Icon.error);
        }
    }

    public void initialize(){
        new AutoCompleteComboBoxListener<>(airplaneNumberComboBox);
    }
}
