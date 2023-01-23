package lk.ijse.dmi.controller;

import com.jfoenix.controls.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.IntegerStringConverter;
import lk.ijse.dmi.db.DBConnection;
import lk.ijse.dmi.model.PoOrderModel;
import lk.ijse.dmi.model.PoOrderModelDetails;
import lk.ijse.dmi.model.SupplierModel;
import lk.ijse.dmi.to.PoOrder;
import lk.ijse.dmi.to.PoOrderDetails;
import lk.ijse.dmi.to.PoOrderTableLoad;
import lk.ijse.dmi.to.Supplier;
import lk.ijse.dmi.utill.CrudUtil;
import lk.ijse.dmi.utill.Regex;
import lk.ijse.dmi.utill.TextFields;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;



public class PoOrderController  {
    public JFXComboBox<Supplier> cmbSid;
    public JFXTextField txtQty;
    public TableView <PoOrderTableLoad>lblMainPoOrder;
    public TableColumn tblPoId;
    public TableColumn tblSupplier;
    public TableColumn tblDescription;
    public TableColumn<PoOrderTableLoad,Integer> tblQty;
    public TableColumn tblUnitPrice;
    public JFXButton poBtn;
    public JFXTextField txtDescription;
    public JFXTextField txtUnitPrice;
    public TableColumn tblDate;
    public TableColumn tblTime;
    public JFXDatePicker date;
    public JFXTimePicker time;
    public JFXTextField txtPoID;
    public TableColumn tblAmount;
  public  ObservableList<PoOrderTableLoad> obPoTableList=FXCollections.observableArrayList();


    public void initialize(){
lblMainPoOrder.setEditable(true);
loadTable();
        loadDataCmb();
    }
    public void loadTable(){
        if(obPoTableList.size()>0){
            obPoTableList.clear();
        }
        lblMainPoOrder.setEditable(true);

     tblPoId.setCellValueFactory(new PropertyValueFactory<>("poId"));
     tblSupplier.setCellValueFactory(new PropertyValueFactory<>("posId"));
     tblDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
     tblQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
     tblDate.setCellValueFactory(new PropertyValueFactory<>("date"));
     tblTime.setCellValueFactory(new PropertyValueFactory<>("time"));
 tblUnitPrice.setCellValueFactory(new PropertyValueFactory<>("UnitPrice"));
    tblAmount.setCellValueFactory(new PropertyValueFactory<>("amount"));

        try {

            ArrayList<PoOrder> allPoOrder = PoOrderModel.getAllpoOrder();
            ArrayList<PoOrderDetails> allPoOrderDetails = PoOrderModelDetails.getAllPoOrderDetails();
            for(PoOrder p:allPoOrder){
                PoOrderTableLoad list=new PoOrderTableLoad();
                list.setPoId(p.getPoId());
                list.setDate(p.getDate());
                list.setTime(p.getTime());
                list.setPosId(p.getPosId());
                obPoTableList.add(list);
            }
            int count=0;
            for(PoOrderDetails p:allPoOrderDetails){
                PoOrderTableLoad poOrderTableLoad = obPoTableList.get(count++);
                poOrderTableLoad.setQty(p.getQty());
                poOrderTableLoad.setDescription(p.getDescription());
                poOrderTableLoad.setUnitPrice(p.getUnitPrice());
                poOrderTableLoad.setAmount(p.getQty()*p.getUnitPrice());

            }
            tblQty.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
            tblQty.setOnEditCommit(event -> {
                PoOrderTableLoad rowValue = event.getRowValue();
                rowValue.setQty(event.getNewValue());
            });
        lblMainPoOrder.setItems(obPoTableList);
            lblMainPoOrder.refresh();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }


    public void loadDataCmb() {
        try {
            ArrayList<Supplier> a1 = new ArrayList(SupplierModel.getAllSupplier());
            for (Supplier a : a1) {
                cmbSid.getItems().addAll(a);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        lblMainPoOrder.refresh();

    }
    public void poOrderBtn(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        if (Regex.setTextColor(TextFields.ID,txtPoID)) {

        }else {
            new Alert(Alert.AlertType.WARNING,"Invalid Id").show();
            return;
        }
        if (Regex.setTextColor(TextFields.NAME,txtDescription)) {

        }else {
            new Alert(Alert.AlertType.WARNING,"Invalid Description").show();
            return;
        }
        if (Regex.setTextColor(TextFields.INTEGER,txtQty)) {

        }else {
            new Alert(Alert.AlertType.WARNING,"Invalid Quantity").show();
            return;
        }
        if (Regex.setTextColor(TextFields.DOUBLE,txtUnitPrice)) {

        }else {
            new Alert(Alert.AlertType.WARNING,"Invalid Price").show();
            return;
        }

int qty=Integer.parseInt(txtQty.getText());
double price=Double.parseDouble(txtUnitPrice.getText());
        boolean b = PoOrderModel.savePo(new PoOrder(txtPoID.getText(), LocalDate.now(), LocalTime.now(), cmbSid.getValue().getId()));
if(b){

    boolean issSaved = PoOrderModelDetails.savePoDetails(new PoOrderDetails(
            txtPoID.getText(),
            txtDescription.getText(),
            qty,
            price
    ));
    if(issSaved){
        new Alert(Alert.AlertType.INFORMATION,"is saved").show();
        obPoTableList.clear();
        initialize();
    }
}

    }
    }


