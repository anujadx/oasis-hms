package com.oasis.controller.patient;

import com.oasis.controller.Controller;
import com.oasis.factory.UIFactory;
import com.oasis.ui.UIName;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

public class PatientSideBarController implements Controller{
    @FXML
    private Button newPatientButton;
    @FXML
    private Button patientManagementButton;
    @FXML
    private Button newTreatmentButton;
    @FXML
    private Button treatmentManagementButton;
    @FXML
    private Button raceButton;
    @FXML
    private Button ethnicityButton;
    @FXML

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @Override
    public void refreshView() {

    }

    @FXML
    public void newPatientButtonOnAction(ActionEvent actionEvent) {
        UIFactory.launchUI(UIName.NEW_PATIENT, true);
    }

    @FXML
    public void patientManagementButtonOnAction(ActionEvent actionEvent) {
        UIFactory.launchUI(UIName.PATIENT_MANAGEMENT, true);
    }

    @FXML
    public void newTreatmentButtonOnAction(ActionEvent actionEvent) {
        UIFactory.launchUI(UIName.NEW_TREATMENT, true);
    }

    @FXML
    public void treatmentManagementButtonOnAction(ActionEvent actionEvent) {
        UIFactory.launchUI(UIName.TREATMENT_MANAGEMENT, true);
    }

    @FXML
    public void raceButtonOnAction(ActionEvent actionEvent) {
        UIFactory.launchUI(UIName.RACE_MANAGEMENT, true);
    }

    @FXML
    public void ethnicityButtonOnAction(ActionEvent actionEvent) {
        UIFactory.launchUI(UIName.ETHNICITY_MANAGEMENT, true);
    }
}
