package lk.ijse.dmi.model;

import lk.ijse.dmi.to.User;
import lk.ijse.dmi.utill.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;

public class UserModel {
public  static boolean addUser(User user) throws SQLException, ClassNotFoundException, SQLSyntaxErrorException {

   return CrudUtil.execute("INSERT INTO user VALUES (?,?,?,?)",user.getId(),user.getName(),user.getPwd(),user.getRole());

    }
    public static User checkUserName(String name) throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("SELECT * FROM user WHERE name =?", name);
        if(rst.next()){
            System.out.println("name");
            return new User(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4)
                    );
        }
return null;

    }
    public static User checkUserPwd(String pwd) throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("SELECT * FROM user WHERE password =?", pwd);

        if(rst.next()){

            return new User(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4)
            );
        }
        return null;

    }
}
