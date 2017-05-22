package com.oasis.main;

import com.oasis.factory.UIFactory;
import com.oasis.ui.UI;
import com.oasis.ui.UIName;
import com.oasis.utils.SystemFunction;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.application.Preloader;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.concurrent.Task;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class OasisApplication extends Application {
    BooleanProperty ready = new SimpleBooleanProperty(false);

    @Override
    public void init() throws Exception {
        super.init();

        loadPreloader();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        SystemFunction.start();

        UI ui = UIFactory.getUI(UIName.DASHBOARD);
        Parent parent = ui.getParent();
        Scene scene = new Scene(parent, 1300, 700);
        scene.setOnKeyReleased(event -> {
            if (event.getCode() == KeyCode.ESCAPE) {
                SystemFunction.showLauncher();
            } else if (event.getCode() == KeyCode.Q) {
                SystemFunction.exit();
            }
        });

        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(scene);

        Platform.runLater(() -> primaryStage.show());
//        ready.addListener((observable, oldValue, newValue) -> {
//            if (Boolean.TRUE.equals(newValue)) {
//                Platform.runLater(() -> primaryStage.show());
//            }
//        });
    }

    public static void main(String[] args) {
        launch(args);
    }



    private void loadPreloader() {
        Task task = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                int max = 100;
                for (int i = 1; i <= max; i++) {
                    Thread.sleep(10);
                    notifyPreloader(new Preloader.ProgressNotification(Double.valueOf(i) / max));
                }
                ready.setValue(Boolean.TRUE);

                notifyPreloader(new Preloader.StateChangeNotification(Preloader.StateChangeNotification.Type.BEFORE_START));

                return null;
            }
        };
        new Thread(task).start();
    }
}