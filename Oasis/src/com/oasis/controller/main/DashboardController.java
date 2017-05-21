package com.oasis.controller.main;

import com.oasis.common.Session;
import com.oasis.controller.Controller;
import com.oasis.factory.UIFactory;
import com.oasis.listener.*;
import com.oasis.ui.UIName;
import com.oasis.utils.SystemFunction;
import javafx.animation.ParallelTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class DashboardController implements Controller {
    @FXML
    public AnchorPane mainSideButton1AnchorPane;
    @FXML
    public AnchorPane mainSideButton2AnchorPane;
    @FXML
    public AnchorPane mainSideButton3AnchorPane;
    @FXML
    public AnchorPane mainSideButton4AnchorPane;
    @FXML
    public AnchorPane mainSideButton5AnchorPane;
    @FXML
    public AnchorPane mainSideButton6AnchorPane;
    @FXML
    public AnchorPane mainSideButton7AnchorPane;

    private boolean isLauncherVisible = false;
    private Parent launcherParent;

    @FXML
    private AnchorPane sideBarAnchorPane;
    @FXML
    private AnchorPane workspaceAnchorPane;

    private ObjectProperty<Button> lastPressedMainSideButton = new SimpleObjectProperty<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setAsDynamic(mainSideButton1AnchorPane);
        setAsDynamic(mainSideButton2AnchorPane);
        setAsDynamic(mainSideButton3AnchorPane);
        setAsDynamic(mainSideButton4AnchorPane);
        setAsDynamic(mainSideButton5AnchorPane);
        setAsDynamic(mainSideButton6AnchorPane);
        setAsDynamic(mainSideButton7AnchorPane);

        SystemFunction.loadDynamicButton(mainSideButton1AnchorPane, Session.APP_CONFIG.getTabButton1(), lastPressedMainSideButton);
        SystemFunction.loadDynamicButton(mainSideButton2AnchorPane, Session.APP_CONFIG.getTabButton2(), lastPressedMainSideButton);
        SystemFunction.loadDynamicButton(mainSideButton3AnchorPane, Session.APP_CONFIG.getTabButton3(), lastPressedMainSideButton);
        SystemFunction.loadDynamicButton(mainSideButton4AnchorPane, Session.APP_CONFIG.getTabButton4(), lastPressedMainSideButton);
        SystemFunction.loadDynamicButton(mainSideButton5AnchorPane, Session.APP_CONFIG.getTabButton5(), lastPressedMainSideButton);
        SystemFunction.loadDynamicButton(mainSideButton6AnchorPane, Session.APP_CONFIG.getTabButton6(), lastPressedMainSideButton);
        SystemFunction.loadDynamicButton(mainSideButton7AnchorPane, Session.APP_CONFIG.getTabButton7(), lastPressedMainSideButton);

        lastPressedMainSideButton.addListener(new ChangeListener<Button>() {
            @Override
            public void changed(ObservableValue<? extends Button> observable, Button oldValue, Button newValue) {
                if(oldValue != null) {
                    oldValue.setStyle(null);
                }

                newValue.setStyle("-fx-font-family: 'Calibri';\n" +
                        "-fx-text-fill: #000000;\n" +
                        "-fx-font-size: 13;\n" +
                        "-fx-background-radius: 0px;\n" +
                        "-fx-background-color: #d27d1e;");
            }
        });
    }

    @Override
    public void refreshView() {

    }

    public void closeButtonOnAction(ActionEvent actionEvent) {
        SystemFunction.exit();
    }

    public void minimizeButtonOnAction(ActionEvent actionEvent) {
        ((Stage) ((Button) (actionEvent.getSource())).getScene().getWindow()).setIconified(true);
    }

    public boolean isLauncherVisible() {
        return isLauncherVisible;
    }

    public void setLauncherVisible(boolean launcherVisible) {
        isLauncherVisible = launcherVisible;
    }

    public void showLauncher() {
        if (!isLauncherVisible()) {
            slideInLauncher();
        } else {
            slideOutLauncher(event -> {
                this.workspaceAnchorPane.getChildren().remove(launcherParent);
            });
        }
    }

    private void slideInLauncher() {
        launcherParent = UIFactory.getUI(UIName.LAUNCHER).getParent();
        this.workspaceAnchorPane.getChildren().add(launcherParent);

        final Duration TIME_SEC = Duration.millis(300);

        TranslateTransition translateTransition = new TranslateTransition(TIME_SEC);
        translateTransition.setFromX(0 - 450);
        translateTransition.setFromY(700 - 300);
        translateTransition.setToX(100);
        translateTransition.setToY(50);

        ScaleTransition scaleTransition = new ScaleTransition(TIME_SEC);
        scaleTransition.setFromX(0);
        scaleTransition.setFromY(0);
        scaleTransition.setToX(1);
        scaleTransition.setToY(1);

        ParallelTransition pt = new ParallelTransition(launcherParent, translateTransition, scaleTransition);
        pt.play();

        setLauncherVisible(true);
    }

    private void slideOutLauncher(EventHandler<ActionEvent> eventEventHandler) {
        final Duration TIME_SEC = Duration.millis(300);

        TranslateTransition translateTransition = new TranslateTransition(TIME_SEC);
        translateTransition.setFromX(100);
        translateTransition.setFromY(50);
        translateTransition.setToX(0 - 450);
        translateTransition.setToY(700 - 300);

        ScaleTransition scaleTransition = new ScaleTransition(TIME_SEC);
        scaleTransition.setFromX(1);
        scaleTransition.setFromY(1);
        scaleTransition.setToX(0);
        scaleTransition.setToY(0);

        ParallelTransition pt = new ParallelTransition(launcherParent, translateTransition, scaleTransition);
        pt.setOnFinished(eventEventHandler);
        pt.play();

        setLauncherVisible(false);
    }

    private void setAsDynamic(AnchorPane anchorPane){
        anchorPane.setOnDragOver(new DynamicPaneDragOverEventHandler());
        anchorPane.setOnDragEntered(new DynamicPaneDragEnteredEventHandler());
        anchorPane.setOnDragExited(new DynamicPaneDragExitedEventHandler());
        anchorPane.setOnDragDropped(new DynamicPaneDragDroppedEventHandler(lastPressedMainSideButton));
    }

    public void setWorkspace(Parent parent) {
        if (isLauncherVisible()) {
            EventHandler<ActionEvent> eventEventHandler = event -> {
                this.workspaceAnchorPane.getChildren().clear();
                this.workspaceAnchorPane.getChildren().add(parent);
            };
            slideOutLauncher(eventEventHandler);
        } else {
            this.workspaceAnchorPane.getChildren().clear();
            this.workspaceAnchorPane.getChildren().add(parent);
        }
    }
}