package lk.ijse.dmi.model;

import lk.ijse.dmi.to.PoOrder;
import lk.ijse.dmi.to.PoOrderDetails;
import lk.ijse.dmi.utill.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

public class PoOrderModelDetails {
    public static boolean savePoDetails(PoOrderDetails poOrderDetails) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("INSERT INTO poorderdetails VALUES(?,?,?,?)",
               poOrderDetails.getPoOrderDid(),poOrderDetails.getDescription(),poOrderDetails.getQty(),poOrderDetails.getUnitPrice());
    }
    public static ArrayList<PoOrderDetails> getAllPoOrderDetails() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("SELECT * FROM poorderdetails");
        ArrayList<PoOrderDetails> poOrderDetails = new ArrayList<>();
                while (rst.next()){
                   poOrderDetails.add(new PoOrderDetails(rst.getString(1),rst.getString(2),rst.getInt(3),rst.getDouble(4)));
                }
                return poOrderDetails;
    }public static boolean save(ArrayList<PoOrderDetails> list) throws SQLException, ClassNotFoundException {
        for(PoOrderDetails p:list){
            if(!savePoDetails(p)){
                return false;
            }
        }
        return true;
    }public static ArrayList<PoOrderDetails> search(String id) throws SQLException, ClassNotFoundException {
       ResultSet rst= CrudUtil.execute("SELECT * FROM poorderdetails WHERE poOderDId=?",id);
       ArrayList<PoOrderDetails> list=new ArrayList<>();
       while (rst.next()){
           list.add(new PoOrderDetails(rst.getString(1),rst.getString(2),rst.getInt(3),rst.getDouble(4)));

       }

       return list;

    }

}
