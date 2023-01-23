package lk.ijse.dmi.model;

import lk.ijse.dmi.to.OrderDeatis;
import lk.ijse.dmi.utill.CrudUtil;

import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDeataisModel {
    public static boolean saveDeatials(OrderDeatis orderDeatis) throws SQLException, ClassNotFoundException {
       return CrudUtil.execute("INSERT INTO orderdetails VALUES (?,?,?,?,?,?,?)",
              orderDeatis.getDescription(),
               orderDeatis.getDiscount(),
               orderDeatis.getQty(),
               orderDeatis.getUnitPrice(),
               orderDeatis.getOrderId(),
               orderDeatis.getOrderItemId(),
               orderDeatis.getCustomerId());


    }
    public static boolean save(ArrayList<OrderDeatis> list) throws SQLException, ClassNotFoundException {
        for (OrderDeatis orderDeatis : list) {

           if(!saveDeatials(orderDeatis)){
               return false;
           }else{
               boolean b = ItemModel.removeQty(orderDeatis.getOrderItemId(), orderDeatis.getQty());
               if(!b){
                   return false;
               }
           }
        }
        return true;
    }
}
