package lk.ijse.dmi.model;

import lk.ijse.dmi.utill.CreateNewId;
import lk.ijse.dmi.utill.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StockModel {
    public static String generateNextOrderId() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("SELECT stId FROM stock ORDER BY stId DESC LIMIT 1");
        if (rst.next()) {

            return CreateNewId.generateId("ST", rst.getString(1));
            
        } else {
            return CreateNewId.generateId("ST", null);
        }

    }
}
