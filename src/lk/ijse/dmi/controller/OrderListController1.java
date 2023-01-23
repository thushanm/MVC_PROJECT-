package lk.ijse.dmi.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.dmi.model.OrderModel;
import lk.ijse.dmi.model.PoOrderModel;
import lk.ijse.dmi.model.PoOrderModelDetails;
import lk.ijse.dmi.to.Order;
import lk.ijse.dmi.to.OrderListController;
import lk.ijse.dmi.to.PoOrder;
import lk.ijse.dmi.to.PoOrderDetails;

import java.sql.SQLException;
import java.util.ArrayList;

public class OrderListController1 {
    public TableView orderView;
    public TableColumn orderId;
    public TableColumn date;
    public TableColumn time;
    public TableColumn description;
    public TableColumn discount;
    public TableColumn qty;
    public TableColumn uPrice;

ObservableList<OrderListController> ob1 = FXCollections.observableArrayList();
    public void initialize() {
orderId.setCellValueFactory(new PropertyValueFactory<>("OderId"));
date.setCellValueFactory(new PropertyValueFactory<>("date"));
time.setCellValueFactory(new PropertyValueFactory<>("time"));
description.setCellValueFactory(new PropertyValueFactory<>("description"));
discount.setCellValueFactory(new PropertyValueFactory<>("discount"));
qty.setCellValueFactory(new PropertyValueFactory<>("qty"));
qty.setCellValueFactory(new PropertyValueFactory<>("uPrice"));


        ArrayList<Order> allOrder = null;
        try {
            allOrder = OrderModel.getAllItem();
            ArrayList<Order> Order = OrderModel.getAllItem();
            for(Order p:allOrder){
                OrderListController list = new OrderListController();
                list.setOderId(p.getOderId());
                list.setDate(p.getDate());


            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }




    }

}
