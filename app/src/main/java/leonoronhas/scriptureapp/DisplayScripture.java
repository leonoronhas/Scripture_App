package leonoronhas.scriptureapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class DisplayScripture extends AppCompatActivity {

    private String book_input;
    private String chapter_input;
    private String verse_input;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_scripture);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();

        //Retrieve input from UI Thread
        book_input = intent.getStringExtra(MainActivity.EXTRA_book_input);
        chapter_input = intent.getStringExtra(MainActivity.EXTRA_chapter_input);
        verse_input = intent.getStringExtra(MainActivity.EXTRA_verse_input);

        //Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.textView);

        //Saved string with formatting
        String scripture = book_input + " " + chapter_input + ":" + verse_input;

        //Display inputs
        textView.setText(scripture);
    }

    public void save(View view) {
        //Save info in FIle_Name for future use
        SharedPreferences sharedPreferences = this.getSharedPreferences(MainActivity.FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        //Get data from SharedPreferences and save it to each file input
        editor.putString(MainActivity.SAVED_book_input, book_input);
        editor.putString(MainActivity.SAVED_chapter_input, chapter_input);
        editor.putString(MainActivity.SAVED_verse_input, verse_input);

        //Apply for small files or commit() for big ones
        editor.apply();

        //Display interactive message after button is tapped
        Toast.makeText(this, "Scripture saved successfully!", Toast.LENGTH_SHORT).show();
    }

}