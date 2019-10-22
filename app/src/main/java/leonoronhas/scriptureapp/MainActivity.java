package leonoronhas.scriptureapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    //Where the input will be displayed
    public final static String EXTRA_book_input = "leonoronhas.scriptureapp.book_input";
    public final static String EXTRA_chapter_input = "leonoronhas.scriptureapp.chapter_input";
    public final static String EXTRA_verse_input = "leonoronhas.scriptureapp.verse_input";

    //Where the input will be saved
    public final static String SAVED_book_input = "leonoronhas.scriptureapp.book_input";
    public final static String SAVED_chapter_input = "leonoronhas.scriptureapp.chapter_input";
    public final static String SAVED_verse_input = "leonoronhas.scriptureapp.verse_input";

    //Where all files/inputs will be saved for the SharedPreferences
    public final static String FILE_NAME = "DEFAULT NAME";

    private EditText bookId;
    private EditText chapterId;
    private EditText verseId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendScripture(View view) {
        Intent intent = new Intent(this, DisplayScripture.class);

        //Get input according to the input field/EditText
        EditText book = findViewById(R.id.editBook);
        EditText chapter = findViewById(R.id.editChapter);
        EditText verse = findViewById(R.id.editVerse);

        //Converting input to String
        String book_input1 = book.getText().toString();
        String chapter_input = chapter.getText().toString();
        String verse_input = verse.getText().toString();

        //Sending input to UI Thread
        intent.putExtra(EXTRA_book_input, book_input1);
        intent.putExtra(EXTRA_chapter_input, chapter_input);
        intent.putExtra(EXTRA_verse_input, verse_input);

        startActivity(intent);
    }

    //Load saved input
    public void loadScripture(View view) {
        SharedPreferences sharedPreferences = this.getSharedPreferences(MainActivity.FILE_NAME, Context.MODE_PRIVATE);

        //Retrieve the input
        String book = sharedPreferences.getString(MainActivity.SAVED_book_input, "No input found"); //s1 = default value in case of nothing to show
        String chapter = sharedPreferences.getString(MainActivity.SAVED_chapter_input, "No input found");
        String verse = sharedPreferences.getString(MainActivity.SAVED_verse_input, "No input found");

        //Populate the input fields
        bookId = findViewById(R.id.editBook);
        chapterId = findViewById(R.id.editChapter);
        verseId = findViewById(R.id.editVerse);

        //Get input and display to appropriate field
        bookId.setText(book);
        chapterId.setText(chapter);
        verseId.setText(verse);
    }
}