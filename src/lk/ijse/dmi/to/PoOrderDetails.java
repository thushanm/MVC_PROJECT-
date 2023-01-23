package lk.ijse.dmi.to;

public class PoOrderDetails {

    private String poOrderDid;
    private String description;
    private int qty;
    private double UnitPrice;


    public PoOrderDetails(String poOrderDid, String description, int qty, double UnitPrice) {
        this.poOrderDid = poOrderDid;
        this.description = description;
        this.qty = qty;
        this.UnitPrice = UnitPrice;
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

    public double getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(double uPrice) {
        this.UnitPrice = UnitPrice;


    }

}


