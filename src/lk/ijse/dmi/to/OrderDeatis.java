package lk.ijse.dmi.to;


import javafx.scene.control.Button;

public class OrderDeatis{

    private String description;
    private int discount;
    private int qty;
    private double unitPrice;
    private String orderId;
    private String orderItemId;
    private String customerId;
    private double amount;
    private Button delete;




    public OrderDeatis() {
    }

    public OrderDeatis(String description, int discount, int qty, double unitPrice, String orderId, String orderItemId) {
        this.description = description;
        this.discount = discount;
        this.qty = qty;
        this.unitPrice = unitPrice;
        this.orderId = orderId;
        this.orderItemId = orderItemId;

    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
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

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(String orderItemId) {
        this.orderItemId = orderItemId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Button getDelete() {
        return delete;
    }

    public void setDelete(Button delete) {
        this.delete = delete;
    }


    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
