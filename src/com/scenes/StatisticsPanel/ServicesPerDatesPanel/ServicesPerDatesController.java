package com.scenes.StatisticsPanel.ServicesPerDatesPanel;

import com.App;
import com.assets.services.Exceptions.NoServerResponseException;
import com.assets.services.Exceptions.ResponseException;
import com.assets.services.Helpers.ServicesPerDatesRow;
import com.assets.services.Requests;
import com.scenes.GeneralScenes.ModalWindow.ModalWindow;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class ServicesPerDatesController {
    @FXML
    private DatePicker fromDatePicker, toDatePicker;
    @FXML
    private TableColumn fullNameColumn, fromToColumn, classColumn;
    @FXML
    private TableView table;

    public void submit() {
        LocalDate from = fromDatePicker.getValue();
        LocalDate to = toDatePicker.getValue();
        if (from == null || to == null) {
            ModalWindow.show("Error", "Dates has not selected", ModalWindow.Icon.error);
            return;
        }

        try {
            table.setItems(Requests.getFlightsFullNameClass(from, to,App.getAccessToken()));
        } catch (ResponseException | NoServerResponseException e) {
            ModalWindow.show("Error", e.getSuspendedMessage(), ModalWindow.Icon.error);
        }
    }

    public void initialize() {
        fullNameColumn.setCellValueFactory(new PropertyValueFactory<ServicesPerDatesRow, String>("fullname"));
        fromToColumn.setCellValueFactory(new PropertyValueFactory<ServicesPerDatesRow, String>("fromTo"));
        classColumn.setCellValueFactory(new PropertyValueFactory<ServicesPerDatesRow, String>("airPlaneClass"));
    }
}
