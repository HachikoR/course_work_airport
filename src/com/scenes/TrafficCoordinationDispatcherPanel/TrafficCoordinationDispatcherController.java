package com.scenes.TrafficCoordinationDispatcherPanel;

import com.App;
import com.assets.services.InteractingWithWindow;
import com.scenes.TrafficCoordinationDispatcherPanel.AddAirportPanel.AddAirportPanel;
import com.scenes.TrafficCoordinationDispatcherPanel.AddCityPanel.AddCityPanel;
import com.scenes.TrafficCoordinationDispatcherPanel.AddCountryPanel.AddCountryPanel;
import com.scenes.TrafficCoordinationDispatcherPanel.AddFlightPanel.AddFlightPanel;
import com.scenes.TrafficCoordinationDispatcherPanel.AddRoutePanel.AddRoutePanel;
import com.scenes.TrafficCoordinationDispatcherPanel.DeleteAirportPanel.DeleteAirportPanel;
import com.scenes.TrafficCoordinationDispatcherPanel.DeleteCityPanel.DeleteCityPanel;
import com.scenes.TrafficCoordinationDispatcherPanel.DeleteCountryPanel.DeleteCountryPanel;
import com.scenes.TrafficCoordinationDispatcherPanel.DeleteFlightPanel.DeleteFlightController;
import com.scenes.TrafficCoordinationDispatcherPanel.DeleteFlightPanel.DeleteFlightPanel;
import com.scenes.TrafficCoordinationDispatcherPanel.DeleteRoutePanel.DeleteRoutePanel;
import com.scenes.TrafficCoordinationDispatcherPanel.EditAirportPanel.EditAirportPanel;
import com.scenes.TrafficCoordinationDispatcherPanel.EditCityPanel.EditCityPanel;
import com.scenes.TrafficCoordinationDispatcherPanel.EditCountryPanel.EditCountryPanel;
import com.scenes.TrafficCoordinationDispatcherPanel.EditFlightPanel.EditFlightPanel;
import com.scenes.TrafficCoordinationDispatcherPanel.EditRoutePanel.EditRoutePanel;
import com.scenes.TrafficCoordinationDispatcherPanel.ShowAllAirportsPanel.ShowAllAirportsPanel;
import com.scenes.TrafficCoordinationDispatcherPanel.ShowAllFlightsPanel.ShowAllFlightsPanel;
import com.scenes.TrafficCoordinationDispatcherPanel.ShowAllRoutesPanel.ShowAllRoutesPanel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TrafficCoordinationDispatcherController {
    @FXML
    private Text loginText, roleText;

    public void logOut() {
        App.resetAccount();
        Stage stage = (Stage) loginText.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(App.class.getResource("App.fxml"));
        InteractingWithWindow.changeScene(stage, loader);
        stage.centerOnScreen();
    }

    @FXML
    void openAddAirportWindow() {
        AddAirportPanel.showModal();
    }

    @FXML
    void openAddCityWindow() {
        AddCityPanel.showModal();
    }

    @FXML
    void openAddCountryWindow() {
        AddCountryPanel.showModal();
    }

    @FXML
    void openAddFlightWindow() {
        AddFlightPanel.showModal();
    }

    @FXML
    void openAddRouteWindow() {
        AddRoutePanel.showModal();
    }

    @FXML
    void openDeleteAirportWindow() {
        DeleteAirportPanel.showModal();
    }

    @FXML
    void openDeleteCityWindow() {
        DeleteCityPanel.showModal();
    }

    @FXML
    void openDeleteCountryWindow() {
        DeleteCountryPanel.showModal();
    }

    @FXML
    void openDeleteFlightWindow() {
        DeleteFlightPanel.showModal();
    }

    @FXML
    void openDeleteRouteWindow() {
        DeleteRoutePanel.showModal();
    }

    @FXML
    void openEditAirportWindow() {
        EditAirportPanel.showModal();
    }

    @FXML
    void openEditCityWindow() {
        EditCityPanel.showModal();
    }

    @FXML
    void openEditCountryWindow() {
        EditCountryPanel.showModal();
    }

    @FXML
    void openEditFlightWindow() {
        EditFlightPanel.showModal();
    }

    @FXML
    void openEditRouteWindow() {
        EditRoutePanel.showModal();
    }

    @FXML
    void openShowAllAirportsWindow() {
        ShowAllAirportsPanel.showModal();
    }

    @FXML
    void openShowAllFlightsWindow() {
        ShowAllFlightsPanel.showModal();
    }

    @FXML
    void openShowAllRoutesWindow() {
        ShowAllRoutesPanel.showModal();
    }

    public void initialize() {
        loginText.setText(App.getUsername());
        roleText.setText(App.getRole());
    }
}
