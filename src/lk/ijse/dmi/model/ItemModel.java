package lk.ijse.dmi.model;

import lk.ijse.dmi.to.Item;
import lk.ijse.dmi.to.Supplier;
import lk.ijse.dmi.utill.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemModel {
    public static boolean save(Item item) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("INSERT INTO item VALUES(?,?,?,?,?,?)",item.getItId(),item.getItsId(),item.getDescription(),item.getQty(),item.getDiscount(),item.getUnitPrice());
    }
    public static ArrayList<Item> getAllItem() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("SELECT * FROM item");
        ArrayList<Item> items = new ArrayList<>();
                while (rst.next()){
                   items.add(new Item(rst.getString(1),rst.getString(2),rst.getString(3),rst.getInt(4), rst.getInt(5) ,rst.getDouble(6)));
                }
                return items;
    }public static boolean save(ArrayList<Item> list) throws SQLException, ClassNotFoundException {
        for(Item p:list){
            if(!save(p)){
                return false;
            }
        }
        return true;
    }public static Item search(String id) throws SQLException, ClassNotFoundException {
       ResultSet rst= CrudUtil.execute("SELECT * FROM item WHERE itId=?",id);

      while (rst.next()){
         return new Item(rst.getString(1),rst.getString(2), rst.getString(3), rst.getInt(4), rst.getInt(5), rst.getDouble(6));

       }

       return null;

    } public static boolean update(Item item) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("UPDATE item SET description=?, qty=?,uPrice=? WHERE itId=?", item.getDescription(),item.getQty(),item.getUnitPrice(),item.getDiscount(),item.getItId());

    }public static boolean addQty(String id,int qty) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("UPDATE  item SET qty=qty+? WHERE itId=?",qty,id);
    }
    public static boolean removeQty(String id,int qty) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("UPDATE  item SET qty=qty-? WHERE itId=?",qty,id);
    }

}
