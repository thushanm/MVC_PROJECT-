package lk.ijse.dmi.controller;

import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DashbordController {
    public AnchorPane dashbordAnchor;
    public AnchorPane dashbordAnchor1;
    public Label timeLabel;
    public Label dateLable;
    public AnchorPane LableAnchor;
    public Label morningLable1;
    public BorderPane mainDashBord;
    boolean isClick;
  public static  DashbordController dashbordController;

    public void initialize() {


        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                timeLabel.setText(LocalDateTime.now().format(DateTimeFormatter.ofPattern(" HH:mm:ss")));
                dateLable.setText(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
            }
        };
        timer.start();
        dashbordController=this;

    }
    public void posBtn(ActionEvent actionEvent) throws IOException {








        if(!isClick){
            dashbordAnchor.getChildren().add(FXMLLoader.load(getClass().getResource("../view/pos.fxml")));
                isClick=true;
        }else {
            dashbordAnchor.getChildren().clear();
            isClick=false;
        }
    }

    public void grnBtn(ActionEvent actionEvent) throws IOException {
        if(!isClick){
            dashbordAnchor.getChildren().add(FXMLLoader.load(getClass().getResource("../view/Grn.fxml")));
            isClick=true;
        }else {
            dashbordAnchor.getChildren().clear();
            isClick=false;
        }
    }


    public void supplierBtn(ActionEvent actionEvent) throws IOException {
        if(!isClick){
            dashbordAnchor.getChildren().add(FXMLLoader.load(getClass().getResource("../view/Supplier.fxml")));
            isClick=true;
        }else {
            dashbordAnchor.getChildren().clear();
            isClick=false;
        }
    }


    public void stockBtn(ActionEvent actionEvent) throws IOException {
        if(!isClick){
            dashbordAnchor.getChildren().add(FXMLLoader.load(getClass().getResource("../view/Stock.fxml")));
            isClick=true;
        }else {
            dashbordAnchor.getChildren().clear();
            isClick=false;
        }
    }


    public void saleBtn(ActionEvent actionEvent) {
    }

    public void incomeBtn(ActionEvent actionEvent) {
    }

    public void wastageBtn(ActionEvent actionEvent) throws IOException {
        if(!isClick){
            dashbordAnchor.getChildren().add(FXMLLoader.load(getClass().getResource("../view/Wastage.fxml")));
            isClick=true;
        }else {
            dashbordAnchor.getChildren().clear();
            isClick=false;
        }
    }

    public void userBtn(ActionEvent actionEvent) throws IOException {
        if(!isClick){
            dashbordAnchor.getChildren().add(FXMLLoader.load(getClass().getResource("../view/User.fxml")));
            isClick=true;
        }else {
            dashbordAnchor.getChildren().clear();
            isClick=false;
        }
    }

    public void poBtn(ActionEvent actionEvent) throws IOException {
        if(!isClick){
            dashbordAnchor.getChildren().add(FXMLLoader.load(getClass().getResource("../view/Item.fxml")));
            isClick=true;
        }else {
            dashbordAnchor.getChildren().clear();
            isClick=false;
        }
    }

    public void btnCustomer(ActionEvent actionEvent) throws IOException {
        if(!isClick){
            dashbordAnchor.getChildren().add(FXMLLoader.load(getClass().getResource("../view/Customer.fxml")));
            isClick=true;
        }else {
            dashbordAnchor.getChildren().clear();
            isClick=false;
        }
    }

    public void logout(ActionEvent actionEvent) throws IOException {
        Stage stage =(Stage)mainDashBord.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/Login.fxml"))));
    }

    public void userBtn1(ActionEvent actionEvent) throws IOException {
        if(!isClick){
            dashbordAnchor.getChildren().add(FXMLLoader.load(getClass().getResource("../view/User.fxml")));
            isClick=true;
        }else {
            dashbordAnchor.getChildren().clear();
            isClick=false;
        }
    }
}






