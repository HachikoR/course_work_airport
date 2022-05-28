package com.scenes.MaintenanceDispatcherPanel.Airplanes.DeleteAirplanePanel;

import com.App;
import com.assets.services.Exceptions.NoServerResponseException;
import com.assets.services.Exceptions.ResponseException;
import com.assets.services.InteractingWithWindow;
import com.assets.services.Requests;
import com.scenes.GeneralScenes.ModalWindow.ModalWindow;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.util.Map;


public class DeleteAirplanePanel {
    static Map<String, Integer> airplaneNumbersId;

    public static void showModal() {
        //Open needed window
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(DeleteAirplanePanel.class.getResource("DeleteAirplanePanel.fxml"));
        InteractingWithWindow.showModal(stage, loader);
        stage.centerOnScreen();

        try {
            //Load all airplane numbers and their id
            airplaneNumbersId = Requests.getAirplaneNumbers(App.getAccessToken());
            ((ComboBox) stage.getScene().lookup("#airplaneNumberComboBox")).getItems().setAll(airplaneNumbersId.keySet());
        } catch (NoServerResponseException | ResponseException e) {
            ModalWindow.show("Error", e.getSuspendedMessage(), ModalWindow.Icon.error);
            ((Stage) stage.getScene().getWindow()).close();
            return;
        }


        stage.show();
    }
}
