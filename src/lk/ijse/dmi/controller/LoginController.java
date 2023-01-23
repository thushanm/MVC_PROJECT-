package lk.ijse.dmi.controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.dmi.model.UserModel;

import java.io.IOException;
import java.sql.SQLException;

public class LoginController {
    public AnchorPane logAnchoerPane;
    public Label passWong;
    public JFXTextField userI;
    public JFXPasswordField userP;

    public void LoginBtn(ActionEvent actionEvent) throws IOException {

validateLogin();


    }

    private void validateLogin() {
        try {
            if (UserModel.checkUserName(userI.getText())!=null && UserModel.checkUserPwd(userP.getText())!=null){
                Stage stage = (Stage) logAnchoerPane.getScene().getWindow();
                stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/dashbord.fxml"))));
                stage.setMaximized(true);
                stage.setResizable(true);
                System.out.println(true);
            }
            else{
                System.out.println("worng");
                passWong.setVisible(true);
            }
        } catch (SQLException | ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }

    public void loginPwd(ActionEvent actionEvent) {
        validateLogin();
    }

    public void userId(ActionEvent actionEvent) {
        userP.requestFocus();
    }
}

