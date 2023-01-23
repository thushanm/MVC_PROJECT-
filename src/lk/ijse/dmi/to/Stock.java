package lk.ijse.dmi.to;

public class Stock {
    private String stId;
    private String disc;
    private double uPrice;


  

    public Stock(String stId, String disc, double uPrice) {
        this.stId = stId;
        this.disc = disc;
        this.uPrice = uPrice;
    }



    public String getStId() {
        return stId;
    }

    public void setStId(String stId) {
        this.stId = stId;
    }

    public String getDisc() {
        return disc;
    }

    public void setDisc(String disc) {
        this.disc = disc;
    }


    public double getuPrice() {
        return uPrice;
    }

    public void setuPrice(double uPrice) {
        this.uPrice = uPrice;
    }
}
