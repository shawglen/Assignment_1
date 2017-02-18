package ca.glenshaw.glen.assignment_1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;

/**
 * Main Activity
 * Creates a 'Main Activity' to display 1 of 4 categories.
 * Displays a unique image button for each of the 4 categories.
 * Display 2 buttons
 *  1 that will display the 'Last' displayed item from it's respective category
 *  and the other will display a randomly choosen item from a randomly choosen category
 * All text was borrowed from wikipedia's website.
 * All images are copyrighted 2017 www.GlenShaw.ca.
 * @author glen shaw
 * @version 1.0
 */
public class MainActivity extends AppCompatActivity
{
    //variables
    TextView textViewClicksTotals;
    private int category, index;
    private int counter;
    //SharedPreferences
    private SharedPreferences sharedPrefs;
    //Statics
    private static final int CATEGORY_LIMIT = 4;
    private static final int ITEMS_LIMIT = 5;

    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        //Toast.makeText(this, "OnCREATE", Toast.LENGTH_SHORT).show();  //debugging
        setContentView(R.layout.activity_main);

        //copyright message
        Toast.makeText(this, (R.string.copyright), Toast.LENGTH_LONG).show();

        //set variable handles
        textViewClicksTotals = (TextView) findViewById(R.id.textViewClicksTotals);

        //sharedpreferences
        sharedPrefs = getPreferences(MODE_PRIVATE);

        //check if first running of app
        if (savedInstanceState != null)
        {
            //Toast.makeText(this, Integer.toString(category), Toast.LENGTH_SHORT).show();
            //Toast.makeText(this, Integer.toString(index), Toast.LENGTH_SHORT).show();
            //Toast.makeText(this, Integer.toString(counter), Toast.LENGTH_SHORT).show();
            category = sharedPrefs.getInt(getString(R.string.category), 0);
            index = sharedPrefs.getInt(getString(R.string.index), 0);
            counter = sharedPrefs.getInt(getString(R.string.counter), 0);
        }
        else
        {
            category = 0;
            index = 0;
            counter = 0;
        }
        //display counter
        textViewClicksTotals.setText(Integer.toString(counter));
    }

    /**
     * Function to store cat, index, counter on Stop
     */
    @Override
    protected void onStop()
    {
        super.onStop();
        //Toast.makeText(this, "OnSTOP", Toast.LENGTH_SHORT).show();
        SharedPreferences.Editor editor = sharedPrefs.edit();

        // set the key/value pairs
        editor.putInt(getString(R.string.category), category);
        editor.putInt(getString(R.string.index), index);
        editor.putInt(getString(R.string.counter), counter);

        //commit the changes
        editor.commit();
    }

    /**
     * Function to finnish application & store cat, index, counter on exit
     */
    public void finnish()
    {
        //Toast.makeText(this, "Finnish", Toast.LENGTH_SHORT).show();
        SharedPreferences.Editor editor = sharedPrefs.edit();

        // set the key/value pairs
        editor.putInt(getString(R.string.category), category);
        editor.putInt(getString(R.string.index), index);
        editor.putInt(getString(R.string.counter), counter);

        // don't forget to commit the changes
        editor.commit();
        //call super
        super.finish();
    }

    /**
     * Load bird activity
     * @param v
     */
    public void clickBirds(View v)
    {
        incrementCounter();
        //Toast.makeText(this, getString(R.string.birds), Toast.LENGTH_SHORT).show();

        category = 1;
        index = genRandomNumber(ITEMS_LIMIT);
        saveSharedPreferences();

        Intent myIntent = new Intent(this, BirdActivity.class);
        myIntent.putExtra("index",index);

        startActivity(myIntent);
    }

    /**
     * Load mammal activity
     * @param v
     */
    public void clickMammals(View v)
    {
        incrementCounter();
        //Toast.makeText(this, getString(R.string.Mammal), Toast.LENGTH_SHORT).show();

        category = 3;
        index = genRandomNumber(ITEMS_LIMIT);
        saveSharedPreferences();

        Intent myIntent = new Intent(this, MammalActivity.class);
        myIntent.putExtra("index",index);

        startActivity(myIntent);
    }

    /**
     * Load reptile activity
     * @param v
     */
    public void clickReptiles(View v)
    {
        incrementCounter();
        //Toast.makeText(this, getString(R.string.Reptiles), Toast.LENGTH_SHORT).show();

        category = 2;
        index = genRandomNumber(ITEMS_LIMIT);
        saveSharedPreferences();

        Intent myIntent = new Intent(this, ReptileActivity.class);
        myIntent.putExtra("index",index);

        startActivity(myIntent);
    }

    /**
     *  Load flora activity
     * @param v
     */
    public void clickFlora(View v)
    {
        incrementCounter();
        //Toast.makeText(this, getString(R.string.Flora), Toast.LENGTH_SHORT).show();

        category = 4;
        index = genRandomNumber(ITEMS_LIMIT);

        saveSharedPreferences();

        Intent myIntent = new Intent(this, FloraActivity.class);
        myIntent.putExtra("index",index);

        startActivity(myIntent);
    }

    /**
     * Function that displays the last stored activity category AND index
     * @param v
     */
    public void clickLast(View v)
    {
        incrementCounter();
        //Toast.makeText(this, getString(R.string.Last), Toast.LENGTH_SHORT).show();

        sharedPrefs = getPreferences(MODE_PRIVATE);

        category = sharedPrefs.getInt(getString(R.string.category), 0);
        index = sharedPrefs.getInt(getString(R.string.index), 0);

        if(category == 0) //0 on first run
        {
            Toast.makeText(this, getString(R.string.nothingSaved), Toast.LENGTH_SHORT).show();
        }else
        {
            loadActivity(category,index);
        }
    }

    /**
     * Function that generate and opens a random category AND item
     * @param v
     */
    public void clickRandom(View v)
    {
        incrementCounter();
        //Toast.makeText(this, getString(R.string.Random), Toast.LENGTH_SHORT).show();

        //randomize cat & index
        category = genRandomNumber(CATEGORY_LIMIT);
        index = genRandomNumber(ITEMS_LIMIT);

        loadActivity(category,index);

        saveSharedPreferences();
    }

    /**
     * Load an activity function
     * @param cat
     * @param idx
     */
    private void loadActivity (int cat, int idx)
    {
        Intent myIntent;

        switch (cat)
        {
            case 1:
                myIntent = new Intent(this, BirdActivity.class);
                myIntent.putExtra("index",idx);
                startActivity(myIntent);
                break;
            case 2:
                myIntent = new Intent(this, ReptileActivity.class);
                myIntent.putExtra("index",idx);
                startActivity(myIntent);
                break;
            case 3:
                myIntent = new Intent(this, MammalActivity.class);
                myIntent.putExtra("index",idx);
                startActivity(myIntent);
                break;
            case 4:
                myIntent = new Intent(this, FloraActivity.class);
                myIntent.putExtra("index",idx);
                startActivity(myIntent);
                break;
        }
    }

    /**
     * generate random number function
     * @param limit
     * @return int randomly generated number
     */
    public int genRandomNumber(int limit)
    {
        Random rn = new Random();
        int answer = rn.nextInt(limit) + 1;
        return answer;
    }

    /**
     * Increment counter function
     */
    public void incrementCounter()
    {
        counter = Integer.parseInt(textViewClicksTotals.getText().toString());
        textViewClicksTotals.setText(Integer.toString(++counter));
    }

    /**
     * Store shared preferences function
     */
    public void saveSharedPreferences()
    {
        SharedPreferences.Editor editor = sharedPrefs.edit();

        // set the key/value pairs
        editor.putInt(getString(R.string.category), category);
        editor.putInt(getString(R.string.index), index);
        editor.putInt(getString(R.string.counter), counter);

        //commit the changes
        editor.commit();

        //Toast.makeText(this, ("Category = " + category), Toast.LENGTH_SHORT).show();
        //Toast.makeText(this, ("Index = " + index), Toast.LENGTH_SHORT).show();
        //Toast.makeText(this, ("Counter = " + counter), Toast.LENGTH_SHORT).show();
    }

}
