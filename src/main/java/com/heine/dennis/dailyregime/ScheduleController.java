package com.heine.dennis.dailyregime;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class ScheduleController {
    @FXML
    private Button welcomeText;

    @FXML
    protected static VBox header;

    @FXML
    protected  void onCloseClick()
    {
        Stage stage = (Stage) welcomeText.getScene().getWindow();
        stage.close();
    }

    @FXML
    protected void onNewTaskButtonClick() {
        try {
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(ScheduleApplication.class.getResource("AddItemController.fxml"));

            AnchorPane scn = fxmlLoader.load();
            Scene scene = new Scene(scn);

            AnchorPane root = scn;
            stage.setResizable(false);
            stage.setTitle("Add Task");
            stage.setScene(scene);
            stage.setOnHidden(onHidden());
            stage.show();

        }catch(Exception e){System.out.println(e.getMessage()+e.getStackTrace());}
    }

    private EventHandler<WindowEvent> onHidden() {
        return new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                new OutputPrinter(ScheduleApplication.root).print();
            }
        };
    }
}