package lk.ijse.dmi.to;

import javafx.scene.control.Button;

import java.time.LocalDate;
import java.time.LocalTime;

public class OrderListController {
    private String OderId;
 private LocalTime time;
   private LocalDate date;
    private String description;
   private int discount;
 private int qty;
  private double unitPrice;
    private String orderId;
    private String orderItemId;
    private String customerId;
    private double amount;
    private Button delete;


    public OrderListController(String oderId, LocalTime time, LocalDate date, String description, int discount, int qty, double unitPrice, String orderId, String orderItemId, String customerId, double amount, Button delete) {
        OderId = oderId;
        this.time = time;
        this.date = date;
        this.description = description;
        this.discount = discount;
        this.qty = qty;
        this.unitPrice = unitPrice;
        this.orderId = orderId;
        this.orderItemId = orderItemId;
        this.customerId = customerId;
        this.amount = amount;
        this.delete = delete;
    }

    public String getOderId() {
        return OderId;
    }

    public void setOderId(String oderId) {
        OderId = oderId;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
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

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Button getDelete() {
        return delete;
    }

    public void setDelete(Button delete) {
        this.delete = delete;
    }
}
