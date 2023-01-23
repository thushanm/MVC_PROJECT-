package lk.ijse.dmi.to;

import java.time.LocalDate;
import java.time.LocalTime;

public class Order {
    private String OderId;
    private LocalTime time;
    private LocalDate date;


    public Order() {
    }


    public Order(String oderId, LocalTime time, LocalDate date) {
        OderId = oderId;
        this.time = time;
        this.date = date;
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
}
