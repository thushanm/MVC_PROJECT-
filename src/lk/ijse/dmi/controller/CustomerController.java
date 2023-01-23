package lk.ijse.dmi.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.dmi.model.CustomerModel;
import lk.ijse.dmi.to.Customer;
import lk.ijse.dmi.utill.Regex;
import lk.ijse.dmi.utill.TextFields;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

public class CustomerController {
    public JFXTextField txtCId;
    public JFXTextField txtCName;
    public JFXTextField txtCAddess;
    public JFXTextField txtCAddress;
    public JFXTextField txtCTelNumber;
    public Button btnCAdd;
    public TableView tblMainCustomer;
    public TableColumn colCId;
    public TableColumn colCName;
    public TableColumn colSAddress;
    public TableColumn colSTelNo;
    public TableColumn colCEdit;
    public TableColumn colCDelete;
    boolean isUpdate;
    boolean isDelete;

    ObservableList<Customer> ob3 = FXCollections.observableArrayList();


    public void initialize() {
        if (ob3 != null) {
            ob3.clear();
        }
        colCId.setCellValueFactory(new PropertyValueFactory<>("Id"));
        colCName.setCellValueFactory(new PropertyValueFactory<>("Name"));
       colSAddress.setCellValueFactory(new PropertyValueFactory<>("Address"));
        colSTelNo.setCellValueFactory(new PropertyValueFactory<>("TelNo"));
        colCEdit.setCellValueFactory(new PropertyValueFactory<>("btnEdit"));
        colCDelete.setCellValueFactory(new PropertyValueFactory<>("btnDelete"));
        ArrayList<Customer> allCustomer = null;
        try {
            allCustomer = CustomerModel.getAllCustomer();
            for (Customer s : allCustomer) {
                System.out.println(s.getId());
                ob3.add(s);


            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException | NullPointerException e) {
            e.printStackTrace();
        }

        tblMainCustomer.setItems(ob3);
       tblMainCustomer.refresh();


        for (Customer s : ob3) {
            Button btnEdit = new Button("Edit");
            Button btnDelete = new Button("Delete");
            Button btnUpdate = new Button("Update");
            btnEdit.setStyle("-fx-border-color: blue");
            btnEdit.setStyle("-fx-border-radius: 20");
            btnDelete.setStyle("-fx-border-color: blue");
            btnDelete.setStyle("-fx-border-radius: 20");


          s.setBtnEdit(btnEdit);
            s.getBtnEdit().setOnAction(event -> {
               tblMainCustomer.setItems(ob3);
            tblMainCustomer.refresh();
                ob3.clear();
              btnCAdd.setVisible(false);
                btnUpdate.setVisible(true);
         btnDelete.setVisible(false);

                try {
                    ArrayList<Customer> allCustomer1 = CustomerModel.getAllCustomer();
                    for (Customer s1 : allCustomer1){
                        ob3.add(s1);
                    }

                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }


                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure Edit Customer");
                alert.getButtonTypes().clear();
                alert.getButtonTypes().addAll(ButtonType.APPLY, ButtonType.CANCEL);

                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.APPLY) {
                    s.getBtnEdit().setDisable(true);
                    s.getBtnEdit().setOpacity(1);
                    isUpdate = true;
                    setTextFieldValue(s);

                }
            });
            tblMainCustomer.setItems(ob3);
           tblMainCustomer.refresh();

            s.setBtnDelete(btnDelete);
            s.getBtnDelete().setOnAction(event -> {
              tblMainCustomer.setItems(ob3);
              tblMainCustomer.refresh();
                ob3.clear();
                btnCAdd.setVisible(false);
           btnUpdate.setVisible(false);
             btnDelete.setVisible(true);


                try {
                    ArrayList<Customer> allCustomer1 = CustomerModel.getAllCustomer();
                    for (Customer s1 : allCustomer1){
                        ob3.add(s1);
                    }

                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }


                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure Delete Supplier");
                alert.getButtonTypes().clear();
                alert.getButtonTypes().addAll(ButtonType.APPLY, ButtonType.CANCEL);

                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.APPLY) {
                    s.getBtnEdit().setDisable(true);
                    s.getBtnEdit().setOpacity(1);
                    isDelete = true;
                    setTextFieldValueDelete(s);

                }
            });
         tblMainCustomer.setItems(ob3);
            tblMainCustomer.refresh();

        }


      tblMainCustomer.setItems(ob3);
      tblMainCustomer.refresh();
    }
    public void setTextFieldValue(Customer s) {
        txtCId.setDisable(true);
       txtCId.setText(s.getId());
       txtCName.setText(s.getName());
        txtCAddess.setText(s.getAddress());
        txtCTelNumber.setText(s.getTelNo()+"");



    }
    public void setTextFieldValueDelete(Customer s) {
           txtCId.setDisable(true);
       txtCId.setText(s.getId());
      txtCName.setDisable(true);
      txtCName.setText(s.getName());
      txtCAddess.setDisable(true);
        txtCAddess.setText(s.getAddress());
        txtCTelNumber.setDisable(true);
        txtCTelNumber.setText(s.getTelNo()+"");



    }









    public void customerAddBtn(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        if (Regex.setTextColor(TextFields.ID,txtCId)) {

        }else {
            new Alert(Alert.AlertType.WARNING,"Invalid Id").show();
            return;
        }


        if(Regex.setTextColor(TextFields.NAME,txtCName)){

        }else {
            new Alert(Alert.AlertType.WARNING,"Invalid Name").show();
            return;
        }
        if (Regex.setTextColor(TextFields.ADDRESS,txtCAddress)){


        }else {
            new Alert(Alert.AlertType.WARNING,"Invalid Address").show();
            return;
        }
        if (Regex.setTextColor(TextFields.PHONE,txtCTelNumber)) {


        }else {
            new Alert(Alert.AlertType.WARNING,"Invalid Phone Number").show();
            return;
        }


        String cId = txtCId.getText();
        String cName = txtCName.getText();
        String cAddress = txtCAddress.getText();
        int ctel_no = Integer.parseInt(txtCTelNumber.getText());
        if (CustomerModel.save(new Customer(cId,cName,cAddress,ctel_no))) {
            new Alert(Alert.AlertType.CONFIRMATION, "Supplier is Save").show();
           tblMainCustomer.setItems(ob3);
            tblMainCustomer.refresh();
            initialize();

        } else {
            new Alert(Alert.AlertType.ERROR, "Supplier is Not Save").show();
        }

    }

    public void customerUpdateBtn(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        initialize();

        isUpdate = CustomerModel.update(new Customer(txtCId.getText(),txtCName.getText(),txtCAddress.getText(),(Integer.parseInt(txtCTelNumber.getText()))));
        if(isUpdate){
            new Alert(Alert.AlertType.CONFIRMATION,"Updated").show();
           tblMainCustomer.setItems(ob3);
          tblMainCustomer.refresh();
            initialize();
        }
        else {
            new Alert(Alert.AlertType.ERROR,"NOT Updated").show();

        }
    }

    public void customerDeleteBtn(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        initialize();

        isUpdate = CustomerModel.delete(new Customer(txtCId.getText(),txtCName.getText(),txtCAddress.getText(),(Integer.parseInt(txtCTelNumber.getText()))));
        if(isDelete){
            new Alert(Alert.AlertType.CONFIRMATION,"Deleted").show();
           tblMainCustomer.setItems(ob3);
           tblMainCustomer.refresh();
            initialize();
        }
        else {
            new Alert(Alert.AlertType.ERROR,"NOT Deleted").show();

        }
    }

}