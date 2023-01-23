package lk.ijse.dmi.model;

import lk.ijse.dmi.to.Customer;
import lk.ijse.dmi.utill.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerModel {
    public static boolean save(Customer customer) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("INSERT INTO customer VALUES(?,?,?,?)",
             customer.getId(),customer.getName(),customer.getAddress(),customer.getTelNo());

    }
    public static boolean update(Customer customer) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("UPDATE customer SET Name=?, address=?,tel_no=? WHERE cId=?", customer.getId(),customer.getAddress(),customer.getTelNo(),customer.getTelNo());

    }
    public static ArrayList<Customer> getAllCustomer() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("SELECT * FROM customer");
        ArrayList<Customer> customers = new ArrayList<>();
        while (rst.next()){
           customers.add(new Customer(rst.getString(1), rst.getString(2), rst.getString(3), rst.getInt(4)));
        }
        return customers;
    }
    public static boolean delete(Customer customer) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("DELETE FROM customer WHERE cId=?",customer.getId());
    }

}
