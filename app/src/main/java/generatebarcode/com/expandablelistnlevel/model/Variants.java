package generatebarcode.com.expandablelistnlevel.model;

/**
 * Created by manjoor on 26-Oct-18.
 */

public class Variants {
    int id = 1;
    String color = "Blue";
    int size  = 42;
    int price = 1000;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
