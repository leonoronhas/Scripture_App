package leonoronhas.scriptureapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public final static String EXTRA_book_input = "leonoronhas.scriptureapp.book_input";
    public final static String EXTRA_chapter_input = "leonoronhas.scriptureapp.chapter_input";
    public final static String EXTRA_verse_input = "leonoronhas.scriptureapp.verse_input";
    public final static String FILE_NAME = "DEFAULT NAME";

    EditText bookId;
    EditText chapterId;
    EditText verseId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendScripture(View view) {
        Intent intent = new Intent(this, DisplayScripture.class);
        bookId = findViewById(R.id.editBook);
        chapterId = findViewById(R.id.editChapter);
        verseId = findViewById(R.id.editVerse);

        String book_input1 = bookId.getText().toString();
        String chapter_input = chapterId.getText().toString();
        String verse_input = verseId.getText().toString();


        intent.putExtra(EXTRA_book_input, book_input1);
        intent.putExtra(EXTRA_chapter_input, chapter_input);
        intent.putExtra(EXTRA_verse_input, verse_input);

        startActivity(intent);
    }

    public void loadScripture(View view) {
        SharedPreferences sharedPreferences = this.getSharedPreferences(MainActivity.FILE_NAME, Context.MODE_PRIVATE);

        String book = sharedPreferences.getString(EXTRA_book_input, "");
        String chapter = sharedPreferences.getString(EXTRA_chapter_input, "");
        String verse = sharedPreferences.getString(EXTRA_verse_input, "");

        bookId.setText(book);
        chapterId.setText(chapter);
        verseId.setText(verse);

    }
}