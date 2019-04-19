package generatebarcode.com.expandablelistnlevel.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by manjoor on 26-Oct-18.
 */

public class MainModel {
    List<Categories> categories = new ArrayList<>();
    List<Rankings> rankings = new ArrayList<>();

    public List<Categories> getCategories() {
        return categories;
    }

    public void setCategories(List<Categories> categories) {
        this.categories = categories;
    }

    public List<Rankings> getRankings() {
        return rankings;
    }

    public void setRankings(List<Rankings> rankings) {
        this.rankings = rankings;
    }
}
