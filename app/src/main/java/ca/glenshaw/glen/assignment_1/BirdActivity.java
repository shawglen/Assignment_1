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
 * Bird Activity
 * Creates an 'Activity' to display 1 of 5 items in this category
 * Displays a unique image and text along with a link to the wikipedia's
 * website where the text was borrowed.
 * All images are copyrighted 2017 www.GlenShaw.ca
 * @author glen shaw
 * @version 1.0
 */

public class BirdActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bird);

        //get elements handle
        final ImageView ivImage = (ImageView) findViewById(R.id.imageView);
        final TextView tvText = (TextView) findViewById(R.id.textView);

        //create an intent & set index
        Intent myIntent = getIntent();
        int index = myIntent.getIntExtra("index",1);

        //switch to Display unique image, text, url link
        switch (index)
        {
            case 1:     //spoonbill
                ivImage.setImageResource(R.drawable.birds1);                                   //set image
                tvText.setText(R.string.birdsString1);  //set text
                Linkify.addLinks(tvText, Linkify.WEB_URLS);                                    //set link
                tvText.setMovementMethod(LinkMovementMethod.getInstance());                    //set scroll if necc.
                break;
            case 2:     //finch
                ivImage.setImageResource(R.drawable.birds2);                                    //set image
                tvText.setText(R.string.birdsString2);   //set text
                Linkify.addLinks(tvText, Linkify.WEB_URLS);                                     //set link
                tvText.setMovementMethod(LinkMovementMethod.getInstance());                     //set scroll if necc.
                break;
            case 3:     //pelican
                ivImage.setImageResource(R.drawable.birds3);                                   //set image
                tvText.setText(R.string.birdsString3);  //set text
                Linkify.addLinks(tvText, Linkify.WEB_URLS);                                    //set link
                tvText.setMovementMethod(LinkMovementMethod.getInstance());                    //set scroll if necc.
                break;
            case 4:     //hummingbird
                ivImage.setImageResource(R.drawable.birds4);                                   //set image
                tvText.setText(R.string.birdsString4);  //set text
                Linkify.addLinks(tvText, Linkify.WEB_URLS);                                    //set link
                tvText.setMovementMethod(LinkMovementMethod.getInstance());                    //set scroll if necc.
                break;
            case 5:     //sparrow
                ivImage.setImageResource(R.drawable.birds5);                                   //set image
                tvText.setText(R.string.birdsString5);  //set text
                Linkify.addLinks(tvText, Linkify.WEB_URLS);                                    //set link
                tvText.setMovementMethod(LinkMovementMethod.getInstance());                    //set scroll if necc.
                break;
        }
    }
}