package Model;

import org.json.JSONException;
import org.json.JSONObject;

public class Medicine {

    private String  id,
                    iCode,
                    gCode,
                    supp,
                    barcode,
                    name,
                    unit,
                    size,
                    color,
                    brand,
                    article,
                    status;
    private Integer qty, minQty, cogs, sell;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getiCode() {
        return iCode;
    }

    public void setiCode(String iCode) {
        this.iCode = iCode;
    }

    public String getgCode() {
        return gCode;
    }

    public void setgCode(String gCode) {
        this.gCode = gCode;
    }

    public String getSupp() {
        return supp;
    }

    public void setSupp(String supp) {
        this.supp = supp;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Integer getMinQty() {
        return minQty;
    }

    public void setMinQty(Integer minQty) {
        this.minQty = minQty;
    }

    public Integer getCogs() {
        return cogs;
    }

    public void setCogs(Integer cogs) {
        this.cogs = cogs;
    }

    public Integer getSell() {
        return sell;
    }

    public void setSell(Integer sell) {
        this.sell = sell;
    }

    // fromJSON fills model from the specified JSONObject
    public Medicine fromJSON (JSONObject jsonObject) {
        try {
            this.id = jsonObject.getString("id");
            this.iCode = jsonObject.getString("i_code");
            this.gCode = jsonObject.getString("g_code");
            this.supp = jsonObject.optString("i_supp");
            this.barcode = jsonObject.getString("i_barcode");
            this.name = jsonObject.getString("i_name");
            this.qty = jsonObject.getInt("i_qty");
            this.minQty = jsonObject.getInt("i_qtymin");
            this.unit = jsonObject.getString("i_unit");
            this.size = jsonObject.getString("i_size");
            this.color = jsonObject.getString("i_color");
            this.brand = jsonObject.getString("i_brands");
            this.article = jsonObject.getString("i_article");
            this.cogs = jsonObject.getInt("i_cogs");
            this.sell = jsonObject.getInt("i_sell");
            this.status = jsonObject.getString("i_status");
        } catch (JSONException exception) {
            // Silent the error
            // System.out.println("Error: " + exception);
        } finally {
            return  this;
        }
    }

}
