package generatebarcode.com.expandablelistnlevel.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by manjoor on 26-Oct-18.
 */

public class Products {
    int id = 1;
    String name = "Nike Sneakers";
    String date_added = "2016-12-09T11:16:11.000Z";
    List<Variants> variants = new ArrayList<>();
    Tax tax;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate_added() {
        return date_added;
    }

    public void setDate_added(String date_added) {
        this.date_added = date_added;
    }

    public List<Variants> getVariants() {
        return variants;
    }

    public void setVariants(List<Variants> variants) {
        this.variants = variants;
    }

    public Tax getTax() {
        return tax;
    }

    public void setTax(Tax tax) {
        this.tax = tax;
    }
}
