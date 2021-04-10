

import Models.Person;
import Models.Website;
import javafx.application.Platform;
import javafx.beans.binding.When;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class Controller {

  Database db = new Database();

  @FXML
  private TableView tableView;

  @FXML
  private TextField RegisterUsername;
  @FXML
  private TextField RegisterPassword;
  @FXML
  private Button SendRegister;
  @FXML
  private Button RegisterBack;

  @FXML
  private TextField LoginUsername;
  @FXML
  private TextField LoginPassword;
  @FXML
  private Button LoginLogin;
  @FXML
  private Button LoginBack;


  @FXML
  private TextField MainWebsite;
  @FXML
  private TextField MainUsername;
  @FXML
  private TextField MainPassword;

  @FXML
  private Button RootLogin;
  @FXML
  private Button RootRegister;
  @FXML
  private Button RootQuit;




//Needed for testing during dev
  public void Testing() {
    System.out.println("Testing The app");
  }


  public void gotoLogin(ActionEvent actionEvent) throws IOException, SQLException {
    System.out.println("Go To Login With Action Event");

    //Using the window to get the stage and closing previous file and  loading the next fxml file
    Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
    stage.close();
    Helper.LoadScene("/Login.fxml");
  }

  public void gotoRegister(ActionEvent actionEvent) throws IOException, SQLException {
    System.out.println("Go To Register");

    //Using the window to get the stage and closing previous file and  loading the next fxml file
    Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
    stage.close();
    Helper.LoadScene("/Register.fxml");
  }

  public void GotoRoot(ActionEvent actionEvent) throws IOException, SQLException {
    System.out.println("Go To Root");

    //Using the window to get the stage and closing previous file and  loading the next fxml file
    Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
    stage.close();
    Helper.LoadScene("/Root.fxml");
  }

  public void GotoMain(ActionEvent actionEvent) throws Exception {
    System.out.println(LoginUsername.getText());


    String username = LoginUsername.getText();
    String password = LoginPassword.getText();


    try {

      Database db = new Database();



      //Using the window to get the stage and closing previous file and  loading the next fxml file
      Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
      stage.close();
      Helper.LoadScene("/Main.fxml");
      //validating the login
      db.validateLogin(username, password);


    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  public void exit(ActionEvent actionEvent) {
    //Exiting from the program
    Platform.exit();
  }
  //storing password on initial login
  public void StorePassword(ActionEvent actionEvent) {

    String password = MainPassword.getText();
    String website = MainWebsite.getText();
    String username = MainUsername.getText();

    Database db = new Database();
    try{
      db.storeNewWebsiteCred(username, password, website);

      ObservableList<Website> data = tableView.getItems();

      data.add(new Website(website,username,password));

      MainPassword.setText("");
      MainWebsite.setText("");
      MainUsername.setText("");

    }catch (Exception e){
      System.out.println(e.getMessage());
    }

  }
}




















