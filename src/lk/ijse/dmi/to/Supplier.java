package lk.ijse.dmi.to;

import javafx.scene.control.Button;

public class Supplier  {
    private String id;
    private String name;
    private String address;
    private int number;
        private Button btnEdit;
        private Button btnDelete;


    public Supplier(String id, String name, String address, int number) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.number = number;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
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

    public String toString() {
return id+","+ name;
    }
}

