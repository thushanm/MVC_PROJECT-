package lk.ijse.dmi.to;

import java.time.LocalDate;
import java.time.LocalTime;


public class PoOrderTableLoad {

    private String poId;
    private LocalDate date;
    private LocalTime time;
    private String posId;
    private String poOrderDid;
    private String description;
    private int qty;
    private double unitPrice;
    private double amount;

    public PoOrderTableLoad() {
    }

    public PoOrderTableLoad(String poId, LocalDate date, LocalTime time, String posId, String poOrderDid, String description, int qty, double unitPrice) {
        this.poId = poId;
        this.date = date;
        this.time = time;
        this.posId = posId;
        this.poOrderDid = poOrderDid;
        this.description = description;
        this.qty = qty;
        this.unitPrice = unitPrice;
    }

    public String getPoId() {
        return poId;
    }

    public void setPoId(String poId) {
        this.poId = poId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getPosId() {
        return posId;
    }

    public void setPosId(String posId) {
        this.posId = posId;
    }

    public String getPoOrderDid() {
        return poOrderDid;
    }

    public void setPoOrderDid(String poOrderDid) {
        this.poOrderDid = poOrderDid;
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


    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String toString() {
        return poId + "," + date;
    }
}

