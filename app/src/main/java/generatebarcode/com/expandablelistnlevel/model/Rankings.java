package generatebarcode.com.expandablelistnlevel.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by manjoor on 26-Oct-18.
 */

public class Rankings {
    String ranking = "Most Viewed Products";
    List<RankingProducts> products = new ArrayList<>();

    public String getRanking() {
        return ranking;
    }

    public void setRanking(String ranking) {
        this.ranking = ranking;
    }

    public List<RankingProducts> getProducts() {
        return products;
    }

    public void setProducts(List<RankingProducts> products) {
        this.products = products;
    }
}
