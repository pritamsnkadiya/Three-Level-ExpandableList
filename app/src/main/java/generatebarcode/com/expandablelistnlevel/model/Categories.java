package generatebarcode.com.expandablelistnlevel.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by manjoor on 26-Oct-18.
 */

public class Categories {
    int id = 1;
    String name = "Casuals";
    List<Products> products = new ArrayList<>();
    List<Integer> child_categories = new ArrayList<>();

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

    public List<Products> getProducts() {
        return products;
    }

    public void setProducts(List<Products> products) {
        this.products = products;
    }

    public List<Integer> getChild_categories() {
        return child_categories;
    }

    public void setChild_categories(List<Integer> child_categories) {
        this.child_categories = child_categories;
    }
}
