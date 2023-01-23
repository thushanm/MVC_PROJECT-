package lk.ijse.dmi.controller;

import com.jfoenix.controls.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.dmi.model.CustomerModel;
import lk.ijse.dmi.model.ItemModel;
import lk.ijse.dmi.model.SupplierModel;
import lk.ijse.dmi.to.Customer;
import lk.ijse.dmi.to.GrnTableLoad;
import lk.ijse.dmi.to.Item;
import lk.ijse.dmi.to.Supplier;
import lk.ijse.dmi.utill.Regex;
import lk.ijse.dmi.utill.TextFields;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;


public class ItemController {
    public JFXComboBox<Supplier> cmbSid;
    public JFXTextField txtQty;
    public TableColumn tblSupplier;
    public TableColumn tblDescription;
    public TableColumn<Item,Integer> tblQty;
    public TableColumn tblUnitPrice;
    public JFXTextField txtDescription;
    public JFXTextField txtUnitPrice;
    public JFXTimePicker time;
    public TableColumn tblAmount;
  public  ObservableList<Item> obItemTableList=FXCollections.observableArrayList();
    public TableColumn tblUpdate;
    public JFXButton itemR;
    public JFXTextField txtItemID;
    public TableColumn tblItemId;
    public TableView<Item> tblMainItemOrder;
    public JFXButton itemRUpdate;
    public TableColumn tblDiscount;
    public JFXTextField txtDiscount;
    boolean isUpdate;


    public void initialize() {
        tblMainItemOrder.setEditable(true);
        loadTable();
        loadDataCmb();

        for (Item s : obItemTableList) {
            Button btnEdit = new Button("Edit");
            btnEdit.setStyle("-fx-border-color: blue");
            btnEdit.setStyle("-fx-border-radius: 20");
            s.setUpdate(btnEdit);
            s.getUpdate().setOnAction(event -> {
                if (obItemTableList.size() > 0) {
                    obItemTableList.clear();
                }
             itemR.setVisible(false);
              itemRUpdate.setVisible(true);
                try {
                    ArrayList<Item> allItem = ItemModel.getAllItem();
                    for (Item s1 : allItem){
                        obItemTableList.add(s1);
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
                    s.getUpdate().setDisable(true);
                    s.getUpdate().setOpacity(1);
                    isUpdate = true;
                    setTextFieldValue(s);

                }
            });




        }
    }
    public void setTextFieldValue(Item s) {
        txtItemID.setDisable(true);
        txtItemID.setText(s.getItId());
        txtDescription.setText(s.getDescription());
        txtQty.setText(s.getQty() + "");
     txtUnitPrice.setText(s.getUnitPrice() + "");
    }
        public void loadTable() {
            if (obItemTableList.size() > 0) {
                obItemTableList.clear();
            }
            tblMainItemOrder.setEditable(true);

            tblItemId.setCellValueFactory(new PropertyValueFactory<>("itId"));
            tblSupplier.setCellValueFactory(new PropertyValueFactory<>("itsId"));
            tblDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
            tblQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
            tblUpdate.setCellValueFactory(new PropertyValueFactory<>("update"));
            tblUnitPrice.setCellValueFactory(new PropertyValueFactory<>("UnitPrice"));
            tblDiscount.setCellValueFactory(new PropertyValueFactory<>("discount"));
            tblAmount.setCellValueFactory(new PropertyValueFactory<>("amount"));

            try {

                ArrayList<Item> allItem = ItemModel.getAllItem();

                for (Item p : allItem) {
                    Item list = new Item();
                    list.setItId(p.getItId());
                    list.setItsId(p.getItsId());
                    list.setDescription(p.getDescription());
                    list.setQty(p.getQty());
                    list.setDiscount(p.getDiscount());
                    list.setUnitPrice(p.getUnitPrice());
                    list.setAmount((p.getQty() * p.getUnitPrice()-p.getDiscount())*105/100);
                    obItemTableList.add(list);
                }


         /*   tblQty.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
            tblQty.setOnEditCommit(event -> {
                PoOrderTableLoad rowValue = event.getRowValue();
                rowValue.setQty(event.getNewValue());
            });*/
                tblMainItemOrder.setItems(obItemTableList);
                tblMainItemOrder.refresh();
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
    }




    public void itemBtn(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        if (Regex.setTextColor(TextFields.ID, txtItemID)) {

        } else {
            new Alert(Alert.AlertType.WARNING, "Invalid Id").show();
            return;
        }
        if (Regex.setTextColor(TextFields.NAME, txtDescription)) {

        } else {
            new Alert(Alert.AlertType.WARNING, "Invalid Description").show();
            return;
        }
        if (Regex.setTextColor(TextFields.INTEGER, txtQty)) {

        } else {
            new Alert(Alert.AlertType.WARNING, "Invalid Quantity").show();
            return;
        }
        if (Regex.setTextColor(TextFields.INTEGER, txtDiscount)) {

        } else {
            new Alert(Alert.AlertType.WARNING, "Invalid Discount").show();
            return;
        }
        if (Regex.setTextColor(TextFields.DOUBLE, txtUnitPrice)) {

        } else {
            new Alert(Alert.AlertType.WARNING, "Invalid Price").show();
            return;
        }

int qty=Integer.parseInt(txtQty.getText());
int discount = Integer.parseInt(txtDiscount.getText());
double price=Double.parseDouble(txtUnitPrice.getText());
        System.out.println("qty"+Integer.parseInt(txtQty.getText()));
        System.out.println("unit price"+Double.parseDouble(txtUnitPrice.getText()));
    if(ItemModel.save(new Item(txtItemID.getText(),cmbSid.getValue().getId(),txtDescription.getText(),qty,discount,price))){
        new Alert(Alert.AlertType.INFORMATION,"is saved").show();
  obItemTableList.clear();
        initialize();
    }
    else {
        new Alert(Alert.AlertType.ERROR,"is Not saved").show();
    }
}

    public void itemUpdateBtn(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        initialize();


        isUpdate = ItemModel.update(new Item(txtItemID.getText(),cmbSid.getValue().getId(),txtDescription.getText(),Integer.parseInt(txtQty.getText()),Integer.parseInt(txtDiscount.getText()),Double.parseDouble(txtUnitPrice.getText())));
        if(isUpdate){
            new Alert(Alert.AlertType.CONFIRMATION,"Updated").show();

            initialize();
        }
        else {
            new Alert(Alert.AlertType.ERROR,"NOT Updated").show();

        }
    }


}




