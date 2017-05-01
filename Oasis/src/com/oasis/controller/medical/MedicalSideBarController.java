package com.oasis.controller.medical;

import com.oasis.controller.Controller;
import com.oasis.factory.UIFactory;
import com.oasis.ui.UIName;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class MedicalSideBarController implements Controller{
    @FXML
    private Button newTestButton;
    @FXML
    private Button testManagementButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @Override
    public void refreshView() {

    }

    @FXML
    public void newTestButtonOnAction(ActionEvent actionEvent) {
        UIFactory.launchUI(UIName.NEW_TEST, true);
    }

    @FXML
    public void testManagementButtonOnAction(ActionEvent actionEvent) {
        UIFactory.launchUI(UIName.TEST_MANAGEMENT, true);
    }
}
