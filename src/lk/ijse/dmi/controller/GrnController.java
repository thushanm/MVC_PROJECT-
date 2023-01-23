package lk.ijse.dmi.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.util.converter.IntegerStringConverter;
import lk.ijse.dmi.db.DBConnection;
import lk.ijse.dmi.model.*;
import lk.ijse.dmi.to.*;
import lk.ijse.dmi.utill.Regex;
import lk.ijse.dmi.utill.TextFields;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Optional;

public class GrnController {
    public AnchorPane grnAnchor;
    public TableView<GrnDetails> tblMainGrn;
    public TableColumn tblPoId;
    public TableColumn tblDescription;
    public TableColumn<GrnDetails, Integer> tblQty;
    public TableColumn tblUnitPrice;
    public TableColumn tblAmount;

    public JFXTextField txtUnitPrice;
    public JFXTextField txtDescription;
    public JFXTextField txtItemId;
    public JFXComboBox<Item> cmbItId;
    public JFXTextField txtgrnId;
    public JFXTextField txtQty;
    double total;


    ObservableList<GrnDetails> obGrnList = FXCollections.observableArrayList();


    public void initialize() {
        System.out.println(LocalTime.now());
        tblQty.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        tblQty.setOnEditCommit(event -> {
            System.out.println("is ok");
        });

        loadDataCmb();


    }


    public void loadDataCmb() {

        try {
            ArrayList<Item> allpoOrder = ItemModel.getAllItem();
            for (Item a : allpoOrder) {
                cmbItId.getItems().addAll(a);
            }
            tblMainGrn.setItems(obGrnList);
            tblMainGrn.refresh();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }


    public void btnAdd(ActionEvent actionEvent) throws SQLException {

        Connection connection=null;
        try {
            connection= DBConnection.getInstance().getConnection();
            connection.setAutoCommit(false);
            String id=GrnModel.generateNextOrderId();
            boolean saveGrn = GrnModel.saveGrn(new Grn(
                    id,
                    LocalDate.now(),
                    LocalTime.now()

            ));
            if(saveGrn){
                System.out.println("addd ");
                ArrayList<GrnDetails> grnDetails=new ArrayList<>();
                for (GrnDetails g: obGrnList) {
                    g.setGrnId(id);
                    grnDetails.add(g);
                }
                boolean saveAll = GrnModelDeatils.saveAll(grnDetails);
                if(saveAll){
                    connection.commit();

                    new Alert(Alert.AlertType.INFORMATION,"completed").show();
                }
            }
            connection.rollback();
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {

            connection.setAutoCommit(true);
        }
        tblMainGrn.setItems(obGrnList);
        tblMainGrn.refresh();
        txtDescription.clear();
        txtQty.clear();
        txtUnitPrice.clear();
        txtItemId.clear();
        txtItemId.clear();


    }


    public void cmbClick(ActionEvent actionEvent) {
        Item value = cmbItId.getValue();
        if (value != null) {
            try {
                txtItemId.setText(value.getItId());
                txtQty.setText(value.getQty() + "");
                txtgrnId.setText(GrnModel.generateNextOrderId());
                txtDescription.setText(value.getDescription());
                txtUnitPrice.setText(String.valueOf(value.getUnitPrice()));


            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        }


    }


    public void btnAddTable(ActionEvent actionEvent) {
        if(Regex.setTextColor(TextFields.INTEGER,txtQty)){

        }
        else {
            new Alert(Alert.AlertType.WARNING,"Please Enter Only Quantity").show();
            return;
        }
       GrnDetails genTable = new GrnDetails(txtDescription.getText(),Integer.parseInt(txtQty.getText()),Double.parseDouble(txtUnitPrice.getText()),txtItemId.getText(),txtItemId.getText());
       if(genTable.getQty()<=0){
           genTable.setQty(1);
        }
       genTable.setAmount(genTable.getQty()*genTable.getUnitPrice());

        obGrnList.add(genTable);




        tblPoId.setCellValueFactory(new PropertyValueFactory<>("ItId"));
        tblDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        tblQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
        tblUnitPrice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        tblAmount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        initialize();




    }
}














