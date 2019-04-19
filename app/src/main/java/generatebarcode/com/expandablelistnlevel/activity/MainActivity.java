package generatebarcode.com.expandablelistnlevel.activity;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import generatebarcode.com.expandablelistnlevel.R;
import generatebarcode.com.expandablelistnlevel.model.MainModel;


/**
 * Add in parent for more main category
 * Define array for genre (subcategory) for each parent category added
 * Define LinkedHasMap for each subcategory where key is subcategory name, and value is a string array
 */
public class MainActivity extends AppCompatActivity {

    /**
     * The Expandable list view.
     */
    ExpandableListView expandableListView;

    // We have two  main category. (third one is left for example addition)

    /**
     * The Parent Group Names.
     */
    String[] parent = new String[]{"MOVIES", "GAMES"}; // comment this when uncomment bottom
    //String[] parent = new String[]{"MOVIES", "GAMES", "SERIALS"}; // example for 3 main category lists

    /*
    If above line is uncommented uncomment the following too:
    - serials array
    - serials genre list
    - Datastructure for Third level Serials.
    - secondLevel.add(serials);
    - serials category all data
    - data.add(thirdLevelSerials);

     */

    /**
     * The Movies Genre List.
     */

    // We have two  main category. (third one is left for example addition)
    String[] movies = new String[]{"Horror", "Action", "Thriller/Drama"};
    /**
     * The Games Genre List.
     */
    String[] games = new String[]{"Fps", "Moba", "Rpg", "Racing"};

    /**
     * The Serials Genre List.
     */
    // String[] serials = new String[]{"Crime", "Family", "Comedy"};


    /**
     * The Horror movie list.
     */
    // movies category has further genres
    String[] horror = new String[]{"Conjuring", "Insidious", "The Ring"};
    /**
     * The Action Movies List.
     */
    String[] action = new String[]{"Jon Wick", "Die Hard", "Fast 7", "Avengers"};
    /**
     * The Thriller Movies List.
     */
    String[] thriller = new String[]{"Imitation Game", "Tinker, Tailer, Soldier, Spy", "Inception", "Manchester by the Sea"};


    /**
     * The Fps games.
     */
    // games category has further genres
    String[] fps = new String[]{"CS: GO", "Team Fortress 2", "Overwatch", "Battlefield 1", "Halo II", "Warframe"};
    /**
     * The Moba games.
     */
    String[] moba = new String[]{"Dota 2", "League of Legends", "Smite", "Strife", "Heroes of the Storm"};
    /**
     * The Rpg games.
     */
    String[] rpg = new String[]{"Witcher III", "Skyrim", "Warcraft", "Mass Effect II", "Diablo", "Dark Souls", "Last of Us"};
    /**
     * The Racing games.
     */
    String[] racing = new String[]{"NFS: Most Wanted", "Forza Motorsport 3", "EA: F1 2016", "Project Cars"};

    // serials genre list
    /*String[] crime = new String[]{"CSI: MIAMI", "X-Files", "True Detective", "Sherlock (BBC)", "Fargo", "Person of Interest"};

    String[] family = new String[]{"Andy Griffith", "Full House", "The Fresh Prince of Bel-Air", "Modern Family", "Friends"};

    String[] comedy = new String[]{"Family Guy", "Simpsons", "The Big Bang Theory", "The Office"};
*/


    /**
     * Datastructure for Third level movies.
     */
    LinkedHashMap<String, String[]> thirdLevel = new LinkedHashMap<>();
    /**
     * Datastructure for Third level games.
     */
    LinkedHashMap<String, String[]> thirdLevelGames = new LinkedHashMap<>();

    /**
     * Datastructure for Third level Serials.
     */
    // LinkedHashMap<String, String[]> thirdLevelSerials = new LinkedHashMap<>();


    /**
     * The Second level.
     */
    List<String[]> secondLevel = new ArrayList<>();


    /**
     * The Data.
     */
    List<LinkedHashMap<String, String[]>> data = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //PC================================================PC//

        // second level category names (genres)
        secondLevel.add(movies);
        secondLevel.add(games);
        // secondLevel.add(serials);

        // movies category all data
        thirdLevel.put(movies[0], horror);
        thirdLevel.put(movies[1], action);
        thirdLevel.put(movies[2], thriller);
        // games category all data
        thirdLevelGames.put(games[0], fps);
        thirdLevelGames.put(games[1], moba);
        thirdLevelGames.put(games[2], rpg);
        thirdLevelGames.put(games[3], racing);
        // all data
        data.add(thirdLevel);
        data.add(thirdLevelGames);
        //data.add(thirdLevelSerials);

        //PC================================================PC//

      //  dataSet();


        // expandable listview
        expandableListView = (ExpandableListView) findViewById(R.id.expandible_listview);

        // parent adapter
        ThreeLevelListAdapter threeLevelListAdapterAdapter = new ThreeLevelListAdapter(this, parent, secondLevel, data);


        // set adapter
        expandableListView.setAdapter(threeLevelListAdapterAdapter);


        // OPTIONAL : Show one list at a time
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            int previousGroup = -1;

            @Override
            public void onGroupExpand(int groupPosition) {
                if (groupPosition != previousGroup)
                    expandableListView.collapseGroup(previousGroup);
                previousGroup = groupPosition;
            }
        });

        Typeface font = Typeface.createFromAsset( this.getAssets(), "fontawesome_webfont.ttf" );
        Button button = (Button)findViewById( R.id.like );
        button.setTypeface(font);

    }

    void dataSet() {
        //Data Structure
        String[] categories = null;
        String[] products = null;
        String[] variants = null;

        String[] rankings = null;
        int[] rankingsProduct = null;

        MainModel model = new MainModel();
        //For Categories
        for (int i = 0; i < model.getCategories().size(); i++) {
            categories[i] = model.getCategories().get(i).getName();
            for (int j = 0; j < model.getCategories().get(i).getProducts().size(); j++) {
                products[j] = model.getCategories().get(i).getProducts().get(j).getName();
                for (int k = 0; k < model.getCategories().get(i).getProducts().get(j).getVariants().size(); j++) {
                    variants[k] = model.getCategories().get(i).getProducts().get(j).getVariants().get(k).getColor();
                }
                // third level category names
                thirdLevel.put(products[j], variants);
            }
            // second level category names
            secondLevel.add(products);
            data.add(thirdLevel);
        }

        //For Ranking
      /*  for (int i = 0; i < model.getCategories().size(); i++) {
            rankings[i]= model.getRankings().get(i).getRanking();
            for (int j = 0; j < model.getRankings().get(i).getProducts().size(); j++) {
                rankingsProduct[j] = model.getRankings().get(i).getProducts().get(j).getId();
            }
        }*/


        // all data

        //data.add(thirdLevelSerials);


    }
}
