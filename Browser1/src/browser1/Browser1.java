/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package browser1;

import com.sun.javaws.Main;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *
 * @author dipu
 */
public class Browser1 extends Application {
   
    TabPane root;
    
    public void start(Stage primaryStage) throws Exception {
        
        
        Parent browser = FXMLLoader.load(getClass().getResource("MainPage.fxml"));
        Tab browserTab = new Tab("New Tab", browser);
        Tab addTab = new Tab("+", null);
        addTab.setClosable(false);  
        addTab.setOnSelectionChanged(new EventHandler<Event>() {
            @Override
            public void handle(Event event) {
                addNewTab();
            }
        });
        
        root = new TabPane(browserTab, addTab);
        Scene scene = new Scene(root);
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent t) {
                Platform.exit();
                System.exit(0);
            }
        });
        primaryStage.setScene(scene);
        primaryStage.setTitle("Beta Browser");
        scene.getStylesheets().add(getClass().getResource("mainpage.css").toExternalForm());
        primaryStage.show();
        
    }
    
    final void addNewTab() {
        try {
            Parent browser = FXMLLoader.load(getClass().getResource("MainPage.fxml"));
            Tab browserTab = new Tab("New Tab", browser);
            root.getTabs().add(root.getTabs().size() - 1, browserTab);
            root.getSelectionModel().select(browserTab);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
