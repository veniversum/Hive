package gui;

import java.io.IOException;
import java.util.HashMap;

import com.sun.tools.javac.comp.Flow;
import hive.Job;
import hive.JobUniverse;
import hive.Universe;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class mainScreenController {
    @FXML
    private FlowPane universeObjectFlowPane;
    private FlowPane universeProcessFlowPane;
    public void newJobAction(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("newJobPrompt.fxml"));
        Stage newJobPromptStage = new Stage();
        newJobPromptStage.setTitle("Enter Object Details");
        newJobPromptStage.setScene(new Scene(root, 600, 400));
        newJobPromptStage.show();
    }

    public void updateUniverse() {

        for (String s : Universe.nameToObjMap.keySet()) {
            universeObjectFlowPane.getChildren().add(new Button(s));
        }

        for (String s : JobUniverse.nameToJobMap.keySet()) {
            Button foo = new Button(s);
            universeProcessFlowPane.getChildren().add(foo);
        }
    }

}