package lk.ijse.dmi.to;

public class GrnDetails {

    private String description;
    private int qty;
    private double unitPrice;
    private String grnId;
    private String itId;
  private double amount;


    public GrnDetails() {
    }


    public GrnDetails(String description, int qty, double unitPrice, String grnId,String itId) {
        this.description = description;
        this.qty = qty;
        this.unitPrice = unitPrice;
        this.grnId = grnId;
        this.itId = itId;
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

    public String getGrnId() {
        return grnId;
    }

    public void setGrnId(String grnId) {
        this.grnId = grnId;
    }

    public String getItId() {
        return itId;
    }

    public void setItId(String itId) {
        this.itId = itId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
