package lk.ijse.dmi.to;

import javafx.scene.control.Button;

import java.time.LocalDate;
import java.time.LocalTime;

public class GrnTableLoad {
    private String grnId;
    private String ItId;
    private String description1;
    private double unitPrice1;
    private int qty1;
    private LocalTime time1;
    private LocalDate date1;
    private double amount1;
    private Button update;


    public GrnTableLoad() {
    }


    public GrnTableLoad(String grnId, String ItId, String description1, double unitPrice1, int qty1, LocalTime time1, LocalDate date1) {

        this.grnId = grnId;
        this.ItId = ItId;
        this.description1 = description1;
        this.unitPrice1 = unitPrice1;
        this.qty1 = qty1;
        this.time1 = time1;
        this.date1 = date1;

    }


    public String getGrnId() {
        return grnId;
    }

    public void setGrnId(String grnId) {
        this.grnId = grnId;
    }

    public String getItId() {
        return ItId;
    }

    public void setItId(String ItId) {
        this.ItId = ItId;
    }

    public String getDescription1() {
        return description1;
    }

    public void setDescription1(String description1) {
        this.description1 = description1;
    }

    public double getUnitPrice1() {
        return unitPrice1;
    }

    public void setUnitPrice1(double unitPrice1) {
        this.unitPrice1 = unitPrice1;
    }

    public int getQty1() {
        return qty1;
    }

    public void setQty1(int qty1) {
        this.qty1 = qty1;
    }

    public LocalTime getTime1(LocalTime now) {
        return time1;
    }

    public void setTime1(LocalTime time1) {
        this.time1 = time1;
    }

    public LocalDate getDate1(LocalDate now) {
        return date1;
    }

    public void setDate1(LocalDate date1) {
        this.date1 = date1;
    }

    public double getAmount1() {
        return amount1;
    }

    public void setAmount1(double amount1) {
        this.amount1 = amount1;
    }

    public Button getUpdate() {
        return update;
    }

    public void setUpdate(Button update) {
        this.update = update;
    }
}