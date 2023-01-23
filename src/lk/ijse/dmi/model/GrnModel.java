package lk.ijse.dmi.model;

import lk.ijse.dmi.to.Grn;
import lk.ijse.dmi.to.Item;
import lk.ijse.dmi.utill.CreateNewId;
import lk.ijse.dmi.utill.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GrnModel {
    public static String generateNextOrderId() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("SELECT grnId FROM grn ORDER BY grnId DESC LIMIT 1");
        if (rst.next()) {
            return CreateNewId.generateId("GR", rst.getString(1));
        } else {
            return CreateNewId.generateId("GR", null);
        }

    }public static boolean saveGrn(Grn grn) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("INSERT INTO grn VALUES(?,?,?)",
               grn.getGrnId(),grn.getDate(),grn.getTime());
    }
    public static ArrayList<Grn> getAllItem() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("SELECT * FROM grn");
        ArrayList<Grn> grn = new ArrayList<>();
        while (rst.next()){
            grn.add(new Grn(rst.getString(1), rst.getDate(2).toLocalDate(),rst.getTime(3).toLocalTime()));
        }
        return grn;
}
}
