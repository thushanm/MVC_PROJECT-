package lk.ijse.dmi.model;

import lk.ijse.dmi.to.Grn;
import lk.ijse.dmi.to.GrnDetails;
import lk.ijse.dmi.utill.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GrnModelDeatils {
    public static boolean savePo(GrnDetails grnDetails) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("INSERT INTO grnDetails VALUES(?,?,?,?,?)",
                grnDetails.getDescription(),grnDetails.getQty(),grnDetails.getUnitPrice(),grnDetails.getGrnId(),grnDetails.getItId());
    }
    public static ArrayList<GrnDetails> getAllItem() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("SELECT * FROM grnDetails");
        ArrayList<GrnDetails> grnDetails = new ArrayList<>();
        while (rst.next()){
            grnDetails.add(new GrnDetails(rst.getString(1), rst.getInt(2),rst.getDouble(3), rst.getString(4), rst.getString(5)));
        }
        return grnDetails;
    }public static boolean saveAll(ArrayList<GrnDetails> list) throws SQLException, ClassNotFoundException {
        for (GrnDetails g : list) {
            boolean b = savePo(g);
            if(!b){
                return false;
            }else{
                boolean b1 = ItemModel.addQty(g.getItId(), g.getQty());
                if(!b1){
                    return false;
                }
            }
        }
        return true;
    }
}
