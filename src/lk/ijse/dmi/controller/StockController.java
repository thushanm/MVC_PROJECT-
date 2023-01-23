package lk.ijse.dmi.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import lk.ijse.dmi.db.DBConnection;
import lk.ijse.dmi.to.Stock;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;

public class StockController {
    public AnchorPane stockAnchor;
    public JFXTextField unitPriceTxt;
    public JFXTextField stIdTxt;
    public JFXTextField descTxt;
    public TableView tblMainStock;
    public TableColumn tblStockID;
    public TableColumn tblQty;
    public TableColumn tblDiscount;
    public TableColumn tblUPrice;
    public TableColumn tblAmount;
    public TableColumn tblEdit;
    public TableColumn tblDescription;



    public void addSaleitemBtn(ActionEvent actionEvent) {
    }

}
