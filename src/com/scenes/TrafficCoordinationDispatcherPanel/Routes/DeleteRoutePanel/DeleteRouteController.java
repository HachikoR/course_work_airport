package com.scenes.TrafficCoordinationDispatcherPanel.Routes.DeleteRoutePanel;

import com.App;
import com.assets.services.Exceptions.NoServerResponseException;
import com.assets.services.Exceptions.ResponseException;
import com.assets.services.Requests;
import com.scenes.GeneralScenes.ModalWindow.ModalWindow;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

public class DeleteRouteController {
    @FXML
    private ComboBox<String> routesComboBox;

    public void submit() {
        String route = routesComboBox.getValue();
        route = route == null ? "" : route;

        //Validation data
        String error = "";
        if (!DeleteRoutePanel.routesId.containsKey(route))
            error += "Invalid route selected\n";
        if (!error.equals("")) {
            ModalWindow.show("Error", error, ModalWindow.Icon.error);
            return;
        }

        //API Request
        try {
            Requests.deleteRoute(DeleteRoutePanel.routesId.get(route), App.getAccessToken());

            //Reset and update combobox
            DeleteRoutePanel.routesId.remove(route);
            routesComboBox.getItems().remove(route);
            routesComboBox.setValue("");

            ModalWindow.show("Error", "Route has deleted", ModalWindow.Icon.success);
        } catch (NoServerResponseException | ResponseException e) {
            ModalWindow.show("Error", e.getSuspendedMessage() + "\nRoute has not deleted", ModalWindow.Icon.error);
        }
    }
}
