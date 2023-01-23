package lk.ijse.dmi.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import lk.ijse.dmi.model.UserModel;
import lk.ijse.dmi.to.User;

import java.sql.SQLException;

public class UserController {
    public AnchorPane userAnchor;

    public JFXTextField txtUid;
    public JFXTextField txtName;
    public JFXTextField txtPassword;
    public JFXTextField txtRole;

    public void btnSaveUser(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String uId=txtUid.getText();
        String name =txtName.getText();
        String pass = txtPassword.getText();
        String role = txtRole.getText();
        System.out.println(name);
        System.out.println(role);
        System.out.println(pass);
        System.out.println(uId);

        if(UserModel.addUser(new User(uId,name,pass,role))){
            new Alert(Alert.AlertType.CONFIRMATION,"SUCCUSS ADD").show();

        }
        else {
            new Alert(Alert.AlertType.ERROR,"UNSUCCUSS ADD").show();
        }

    }
}
