package lk.ijse.dmi.utill;

import com.jfoenix.controls.JFXTextField;
import javafx.scene.paint.Paint;



import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    public static boolean isTextFieldValid(TextFields textField,String text){
        String field="";
        switch (textField){
            case ID:
                field="^([A-Z0-9]){1,}$";
                break;
            case NAME:
                field="^[A-z|\\s]{1,}$";
                break;
            case EMAIL:
                field="^([A-z])([A-z0-9.]){1,}[@]([A-z0-9]){1,10}[.]([A-z]){2,5}$";
                break;
            case ADDRESS:
                field="^([A-z0-9]|[/,.@]|\\s){1,}$";
                break;
            case PHONE:
                field="^([+]94{1,3}|[0])([1-9]{2})([0-9]){7}$";
                break;
            case DOUBLE:
                field="^([0-9]){1,}[.]([0-9]){1,}$";
                break;
            case INTEGER:
                field="^([0-9]){1,}$";
                break;
            case NONE_CHARACTER:
                field="^[\\W]{1,}$";
                break;
        }

        Pattern pattern=Pattern.compile(field);
        if(text.trim().isEmpty()){
            return false;
        }
        Matcher matcher= pattern.matcher(text);

        if(matcher.matches()){
            return true;
        }
       return false;
    }public static boolean setTextColor(TextFields location, JFXTextField fields){

        if(Regex.isTextFieldValid(location,fields.getText())){
            fields.setFocusColor(Paint.valueOf("Green"));
                return true;
        }else {
            fields.setFocusColor(Paint.valueOf("Red"));
                return false;
        }
    }
}
