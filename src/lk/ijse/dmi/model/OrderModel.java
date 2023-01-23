package lk.ijse.dmi.model;

import lk.ijse.dmi.to.Grn;
import lk.ijse.dmi.to.Order;
import lk.ijse.dmi.utill.CreateNewId;
import lk.ijse.dmi.utill.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderModel{
    public static String generateNextOrderId() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("SELECT orderID FROM Orders ORDER BY orderID DESC LIMIT 1");
        if (rst.next()) {
            return CreateNewId.generateId("OR", rst.getString(1));
        } else {
            return CreateNewId.generateId("OR", null);
        }


    }public static boolean save(Order order) throws SQLException, ClassNotFoundException {
    return CrudUtil.execute("INSERT INTO orders VALUE(?,?,?)",
            order.getOderId(),order.getTime(),order.getDate());
    }
    public static boolean Delete(Order order) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("DELETE FROM orders WHERE orderID=? ",order.getOderId());
    }
    public static ArrayList<Order> getAllItem() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("SELECT * FROM order ");
        ArrayList<Order> orders = new ArrayList<>();
        while (rst.next()) {
            orders.add(new Order(rst.getString(1), rst.getTime(2).toLocalTime(), rst.getDate(3).toLocalDate()));
        }
        return orders;
    }
}

