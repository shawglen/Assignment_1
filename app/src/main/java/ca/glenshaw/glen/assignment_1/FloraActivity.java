package ca.glenshaw.glen.assignment_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast; //for debugging

/**
 * Flora Activity
 * Creates an 'Activity' to display 1 of 5 items in this category
 * Displays a unique image and text along with a link to the wikipedia's
 * website where the text was borrowed.
 * All images are copyrighted 2017 www.GlenShaw.ca
 * @author glen shaw
 * @version 1.0
 */
public class FloraActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flora);

        //get elements handle
        final ImageView ivImage = (ImageView) findViewById(R.id.imageView);
        final TextView tvText = (TextView) findViewById(R.id.textView);

        //create an intent & set index
        Intent myIntent = getIntent();
        int index = myIntent.getIntExtra("index",1);

        //switch to Display unique image, text, url link
        switch (index)
        {
            case 1:     //Allamanda_cathartica
                ivImage.setImageResource(R.drawable.flora1);                     //set image
                tvText.setText(R.string.floraString1);                           //set text
                Linkify.addLinks(tvText, Linkify.WEB_URLS);                      //set link
                tvText.setMovementMethod(LinkMovementMethod.getInstance());      //set scroll if necc.
                break;
            case 2:     //Nymphaeaceae
                ivImage.setImageResource(R.drawable.flora2);                     //set image
                tvText.setText(R.string.floraString2);                           //set text
                Linkify.addLinks(tvText, Linkify.WEB_URLS);                      //set link
                tvText.setMovementMethod(LinkMovementMethod.getInstance());      //set scroll if necc.
                break;
            case 3:     //Convolvulus
                ivImage.setImageResource(R.drawable.flora3);                     //set image
                tvText.setText(R.string.floraString3);                           //set text
                Linkify.addLinks(tvText, Linkify.WEB_URLS);                      //set link
                tvText.setMovementMethod(LinkMovementMethod.getInstance());      //set scroll if necc.
                break;
            case 4:     //Zinnia
                ivImage.setImageResource(R.drawable.flora4);                     //set image
                tvText.setText(R.string.floraString4);                           //set text
                Linkify.addLinks(tvText, Linkify.WEB_URLS);                      //set link
                tvText.setMovementMethod(LinkMovementMethod.getInstance());      //set scroll if necc.
                break;
            case 5:     //Hibiscus
                ivImage.setImageResource(R.drawable.flora5);                     //set image
                tvText.setText(R.string.floraString5);                           //set text
                Linkify.addLinks(tvText, Linkify.WEB_URLS);                      //set link
                tvText.setMovementMethod(LinkMovementMethod.getInstance());      //set scroll if necc.
                break;
        }
    }
}