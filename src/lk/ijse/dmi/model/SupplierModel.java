package lk.ijse.dmi.model;

import lk.ijse.dmi.to.Supplier;
import lk.ijse.dmi.utill.CrudUtil;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SupplierModel {
    public static boolean save(Supplier supplier) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("INSERT INTO supplier VALUES(?,?,?,?)",
        supplier.getId(),supplier.getName(),supplier.getAddress(),supplier.getNumber());

    }
    public static boolean update(Supplier supplier) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("UPDATE supplier SET Name=?, address=?,tel_no=? WHERE sId=?", supplier.getName(), supplier.getAddress(), supplier.getNumber(),supplier.getId());

    }
public static ArrayList<Supplier> getAllSupplier() throws SQLException, ClassNotFoundException {
       ResultSet rst = CrudUtil.execute("SELECT * FROM supplier");
       ArrayList<Supplier> suppliers = new ArrayList<>();
       while (rst.next()){
           suppliers.add(new Supplier(rst.getString(1),rst.getString(2), rst.getString(3),rst.getInt(4)));
       }
       return suppliers;
}
public static boolean delete(Supplier supplier) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("DELETE FROM supplier WHERE sId=?",supplier.getId());
}


}
