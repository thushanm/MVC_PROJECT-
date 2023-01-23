package lk.ijse.dmi.to;

import javafx.scene.control.Button;

public class Item {
    private String itId;
    private String itsId;
    private String description;
    private int qty;
    private double unitPrice;
    private double amount;
    private int discount;
    private Button update;


    public Item() {
    }





    public Item(String itId, String itsId, String description, int qty,int discount, double unitPrice) {
        this.itId = itId;
        this.itsId = itsId;
        this.description = description;
        this.qty = qty;
        this.unitPrice = unitPrice;
        this.discount = discount;

    }

    public String getItId() {
        return itId;
    }

    public void setItId(String itId) {
        this.itId = itId;
    }

    public String getItsId() {
        return itsId;
    }

    public void setItsId(String itsId) {
        this.itsId = itsId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Button getUpdate() {
        return update;
    }

    public void setUpdate(Button update) {
        this.update = update;
    }

    public  String toString(){return itId+","+description;}

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
}