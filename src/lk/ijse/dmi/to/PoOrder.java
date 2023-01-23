package lk.ijse.dmi.to;

import java.time.LocalDate;
import java.time.LocalTime;

public class PoOrder {

    private String poId;
    private LocalDate date;
    private LocalTime time;
    private String posId;

    public PoOrder() {
    }

    public PoOrder(String poId, LocalDate date, LocalTime time, String posId) {
        this.poId = poId;
        this.date = date;
        this.time = time;
        this.posId = posId;

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
    public String toString(){return poId;}

}
