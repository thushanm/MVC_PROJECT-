package lk.ijse.dmi.model;

import lk.ijse.dmi.to.PoOrder;
import lk.ijse.dmi.to.Supplier;
import lk.ijse.dmi.utill.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;

public class PoOrderModel {
    public static boolean savePo(PoOrder poOrder) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("INSERT INTO poorder VALUES(?,?,?,?)",
             poOrder.getPoId(),poOrder.getDate(),poOrder.getTime(),poOrder.getPosId());
    }
    public static ArrayList<PoOrder> getAllpoOrder() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("SELECT * FROM poorder");
        ArrayList<PoOrder> poOrders = new ArrayList<>();
        while (rst.next()) {
            poOrders.add(new PoOrder(rst.getString(1),
                    rst.getDate(2).toLocalDate(),
                    rst.getTime(3).toLocalTime(),
                    rst.getString(4)));
        }
        return poOrders;
    }
}
