/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package browser1;

import java.net.URL;
import java.util.ResourceBundle;
import static javafx.application.ConditionalFeature.FXML;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebHistory.Entry;
import javafx.scene.web.WebView;

/**
 * FXML Controller class
 *
 * @author dipu
 */
public class MainPageController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private TextField userUrlField;
    @FXML
    private Button backwardButton;
    @FXML
    private Button forwardButton;
    @FXML
    private Button homeButton;
    @FXML
    private Button reloadButton;
    
    @FXML
    private WebView webview;
    
    private String homeUrl ="https://www.google.com/?gws_rd=cr,ssl&ei=dQWMV7GIOYz0vgTd-LfYCg&fg=1";
    private String userUrl;
    private String updateUrl;
    private String lastUrl;
    
    String bfString = null;
    
    BackwardForwardControl bfControl = new BackwardForwardControl();
    
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        final WebEngine engine = webview.getEngine();
        engine.load(homeUrl);//for starting time load.
        userUrlField.setText(homeUrl);
        lastUrl = homeUrl;
        bfControl.set_backward(lastUrl);
        bfControl.set_forward();
        
        EventHandler<ActionEvent> toEnter= new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
                UrlEdit ue = new UrlEdit();
                userUrl=userUrlField.getText();
                userUrl = ue.urlEdit(userUrl);
                lastUrl=userUrl;
                engine.load(userUrl);
                engine.setJavaScriptEnabled(true);  
                
                bfControl.set_backward(lastUrl);
                bfControl.set_forward();
            }
        };
        
        userUrlField.setOnAction(toEnter);
        
        backwardButton.setOnAction(e -> engine.getHistory().go(-1));
        forwardButton.setOnAction(e -> engine.getHistory().go(1));
        
        engine.locationProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                userUrlField.setText(newValue);
            }  
        });
        
        reloadButton.setOnAction(new EventHandler<ActionEvent>() {
          @Override
          public void handle(ActionEvent event) {
              engine.reload();
          }
        });
        
        homeButton.setOnAction(new EventHandler<ActionEvent>() {
          @Override
          public void handle(ActionEvent event) {
              homeUrl= "https://www.google.com/?gws_rd=cr,ssl&ei=dQWMV7GIOYz0vgTd-LfYCg&fg=1";
              lastUrl=homeUrl;
             engine.load(homeUrl);
             engine.setJavaScriptEnabled(true);
          }
      });
        
    }
}
