package lk.ijse.dmi.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import lk.ijse.dmi.model.SupplierModel;
import lk.ijse.dmi.to.Supplier;
import lk.ijse.dmi.utill.Regex;
import lk.ijse.dmi.utill.TextFields;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

import static javafx.scene.input.KeyCode.O;

public class SupplierController {
    public AnchorPane SupplierAnchor;
    public AnchorPane supplierSubAnchor;
    public JFXTextField sIdTxt;
    public JFXTextField sNametxt;
    public JFXTextField sAddressTxt;
    public JFXTextField sttelTxt;
    public Button addBtn1;
    public Button addBtn2;
    public Button addBtn3;
    public TableView supplierView;
    public TableColumn sIdView;
    public TableColumn sNameView;
    public TableColumn sAddressView;
    public TableColumn sTelNoView;
    public TableColumn sControlView;
    public TableColumn colEdit;
    public TableColumn colDelete;
    public TableColumn colUpdate;
    public JFXButton updateBtn;
    public JFXButton deleteBtn;
    boolean isUpdate;
    boolean isDelete;

   public   ObservableList<Supplier> ob1 = FXCollections.observableArrayList();
    public void initialize() {
        if (ob1 !=null){
            ob1.clear();
        }
        sIdView.setCellValueFactory(new PropertyValueFactory<>("id"));
        sNameView.setCellValueFactory(new PropertyValueFactory<>("name"));
        sAddressView.setCellValueFactory(new PropertyValueFactory<>("address"));
        sTelNoView.setCellValueFactory(new PropertyValueFactory<>("number"));
        colEdit.setCellValueFactory(new PropertyValueFactory<>("btnEdit"));
        colDelete.setCellValueFactory(new PropertyValueFactory<>("btnDelete"));
        ArrayList<Supplier> allSupplier = null;
        try {
            allSupplier = SupplierModel.getAllSupplier();

        for (Supplier s : allSupplier) {
            System.out.println(s.getId());
            ob1.add(s);

        }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        supplierView.setItems(ob1);
        supplierView.refresh();


        for (Supplier s : ob1) {
            Button btnEdit = new Button("Edit");
            Button btnDelete = new Button("Delete");
            Button btnUpdate = new Button("Update");
            btnEdit.setStyle("-fx-border-color: blue");
            btnEdit.setStyle("-fx-border-radius: 20");
            btnDelete.setStyle("-fx-border-color: blue");
            btnDelete.setStyle("-fx-border-radius: 20");


            s.setBtnEdit(btnEdit);
            s.getBtnEdit().setOnAction(event -> {
                supplierView.setItems(ob1);
                supplierView.refresh();
                ob1.clear();
                addBtn1.setVisible(false);
                updateBtn.setVisible(true);
                deleteBtn.setVisible(false);

                try {
               ArrayList<Supplier> allSupplier1 = SupplierModel.getAllSupplier();
               for (Supplier s1 : allSupplier1){
                   ob1.add(s1);
               }

                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }


                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure Edit Supplier");
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
supplierView.setItems(ob1);
supplierView.refresh();

            s.setBtnDelete(btnDelete);
            s.getBtnDelete().setOnAction(event -> {
                supplierView.setItems(ob1);
                supplierView.refresh();
                ob1.clear();
                addBtn1.setVisible(false);
                updateBtn.setVisible(false);
                deleteBtn.setVisible(true);


                try {
                    ArrayList<Supplier> allSupplier1 = SupplierModel.getAllSupplier();
                    for (Supplier s1 : allSupplier1){
                        ob1.add(s1);
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
            supplierView.setItems(ob1);
            supplierView.refresh();

        }


        supplierView.setItems(ob1);
        supplierView.refresh();
    }


    public void setTextFieldValue(Supplier s) {
        sIdTxt.setDisable(true);
        sIdTxt.setText(s.getId());
        sNametxt.setText(s.getName());
        sAddressTxt.setText(s.getAddress());
        sttelTxt.setText(s.getNumber()+"");



    }
    public void setTextFieldValueDelete(Supplier s) {
        sIdTxt.setDisable(true);
        sIdTxt.setText(s.getId());
        sNametxt.setDisable(true);
        sNametxt.setText(s.getName());
     sAddressTxt.setDisable(true);
        sAddressTxt.setText(s.getAddress());
        sttelTxt.setDisable(true);
        sttelTxt.setText(s.getNumber()+"");



    }



    public void supplierAddBtn1() throws SQLException, ClassNotFoundException {
    if (Regex.setTextColor(TextFields.ID,sIdTxt)) {

    }else {
        new Alert(Alert.AlertType.WARNING,"Invalid Id").show();
        return;
    }


        if(Regex.setTextColor(TextFields.NAME,sNametxt)){
            addBtn1.setDisable(false);
        }else {
            new Alert(Alert.AlertType.WARNING,"Invalid Name").show();
            return;
        }
     if (Regex.setTextColor(TextFields.ADDRESS,sAddressTxt)){
         addBtn1.setDisable(false);

        }else {
         new Alert(Alert.AlertType.WARNING,"Invalid Address").show();
         return;
     }
     if (Regex.setTextColor(TextFields.PHONE,sttelTxt)) {

         addBtn1.setDisable(false);
     }else {
         new Alert(Alert.AlertType.WARNING,"Invalid Phone Number").show();
         return;
     }


        String sId = sIdTxt.getText();
        String sName = sNametxt.getText();
        String sAddress = sAddressTxt.getText();
        int stel_no = Integer.parseInt(sttelTxt.getText());
        if (SupplierModel.save(new Supplier(sId, sName, sAddress, stel_no))) {
            new Alert(Alert.AlertType.CONFIRMATION, "Supplier is Save").show();
            supplierView.setItems(ob1);
            supplierView.refresh();
initialize();

        } else {
            new Alert(Alert.AlertType.ERROR, "Supplier is Not Save").show();
        }

    }

    public void updateSupplierBtn(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        initialize();

        isUpdate = SupplierModel.update(new Supplier(sIdTxt.getText(),sNametxt.getText(),sAddressTxt.getText(),(Integer.parseInt(sttelTxt.getText()))));
        if(isUpdate){
            new Alert(Alert.AlertType.CONFIRMATION,"Updated").show();
            supplierView.setItems(ob1);
            supplierView.refresh();
            initialize();
        }
        else {
            new Alert(Alert.AlertType.ERROR,"NOT Updated").show();

        }

        supplierView.setItems(ob1);
        supplierView.refresh();
    }

    public void deleteSupplierBtn(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        initialize();

        isUpdate = SupplierModel.delete(new Supplier(sIdTxt.getText(),sNametxt.getText(),sAddressTxt.getText(),(Integer.parseInt(sttelTxt.getText()))));
        if(isDelete){
            new Alert(Alert.AlertType.CONFIRMATION,"Deleted").show();
            supplierView.setItems(ob1);
            supplierView.refresh();
            initialize();
        }
        else {
            new Alert(Alert.AlertType.ERROR,"NOT Deleted").show();

        }
    }
}
