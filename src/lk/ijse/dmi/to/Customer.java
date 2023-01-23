package lk.ijse.dmi.to;

import javafx.scene.control.Button;

public class Customer {
   private String Id;
 private String Name;
 private String Address;
    private int TelNo;
    private Button btnEdit;
    private Button btnDelete;


    public Customer() {
    }


    public Customer(String id, String name, String address, int telNo) {
        Id = id;
        Name = name;
        Address = address;
        TelNo = telNo;

    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public int getTelNo() {
        return TelNo;
    }

    public void setTelNo(int telNo) {
        TelNo = telNo;
    }

    public Button getBtnEdit() {
        return btnEdit;
    }

    public void setBtnEdit(Button btnEdit) {
        this.btnEdit = btnEdit;
    }

    public Button getBtnDelete() {
        return btnDelete;
    }

    public void setBtnDelete(Button btnDelete) {
        this.btnDelete = btnDelete;
    }
    public String toString(){return Id+","+Name;}
}