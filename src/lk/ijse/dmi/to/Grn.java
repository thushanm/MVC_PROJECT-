package lk.ijse.dmi.to;

import java.time.LocalDate;
import java.time.LocalTime;

public class Grn {
    private String grnId;
    private LocalDate date;
    private LocalTime time;



    public Grn() {
    }


    public Grn(String grnId, LocalDate date, LocalTime time) {
        this.grnId = grnId;
        this.date = date;
        this.time = time;

    }

    public String getGrnId() {
        return grnId;
    }

    public void setGrnId(String grnId) {
        this.grnId = grnId;
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


}
