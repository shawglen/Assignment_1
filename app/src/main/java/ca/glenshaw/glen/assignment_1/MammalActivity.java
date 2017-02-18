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
 * Mammal Activity
 * Creates an 'Activity' to display 1 of 5 items in this category
 * Displays a unique image and text along with a link to the wikipedia's
 * website where the text was borrowed.
 * All images are copyrighted 2017 www.GlenShaw.ca
 * @author glen shaw
 * @version 1.0
 */
public class MammalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mammal);

        //get elements handle
        final ImageView ivImage = (ImageView) findViewById(R.id.imageView);
        final TextView tvText = (TextView) findViewById(R.id.textView);

        //create an intent & set index
        Intent myIntent = getIntent();
        int index = myIntent.getIntExtra("index",1);

        //switch to Display unique image, text, url link
        switch (index)
        {
            case 1:     //Mandrill
                ivImage.setImageResource(R.drawable.mammal1);                   //set image
                tvText.setText(R.string.mammalString1);                         //set text
                Linkify.addLinks(tvText, Linkify.WEB_URLS);                     //set link
                tvText.setMovementMethod(LinkMovementMethod.getInstance());     //set scroll if necc.
                break;
            case 2:     //Gray_wolf
                ivImage.setImageResource(R.drawable.mammal2);                   //set image
                tvText.setText(R.string.mammalString2);                         //set text
                Linkify.addLinks(tvText, Linkify.WEB_URLS);                     //set link
                tvText.setMovementMethod(LinkMovementMethod.getInstance());     //set scroll if necc.
                break;
            case 3:     //Tiger
                ivImage.setImageResource(R.drawable.mammal3);                   //set image
                tvText.setText(R.string.mammalString3);                         //set text
                Linkify.addLinks(tvText, Linkify.WEB_URLS);                     //set link
                tvText.setMovementMethod(LinkMovementMethod.getInstance());     //set scroll if necc.
                break;
            case 4:     //American_black_bear
                ivImage.setImageResource(R.drawable.mammal4);                   //set image
                tvText.setText(R.string.mammalString4);                         //set text
                Linkify.addLinks(tvText, Linkify.WEB_URLS);                     //set link
                tvText.setMovementMethod(LinkMovementMethod.getInstance());     //set scroll if necc.
                break;
            case 5:     //Red_fox
                ivImage.setImageResource(R.drawable.mammal5);                   //set image
                tvText.setText(R.string.mammalString5);                         //set text
                Linkify.addLinks(tvText, Linkify.WEB_URLS);                     //set link
                tvText.setMovementMethod(LinkMovementMethod.getInstance());     //set scroll if necc.
                break;
        }
    }
}