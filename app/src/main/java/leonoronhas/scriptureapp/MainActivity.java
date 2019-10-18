package leonoronhas.scriptureapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    //Why do I need this line?
    public final static String EXTRA_MESSAGE = "leonoronhas.scriptureapp.MESSAGE";
    public final static String EXTRA_MESSAGE2 = "leonoronhas.scriptureapp.MESSAGE2";
    public final static String EXTRA_MESSAGE3 = "leonoronhas.scriptureapp.MESSAGE3";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendScripture(View view){
        Intent intent = new Intent(this, DisplayScripture.class);
        EditText editText = findViewById(R.id.editBook);
        EditText editText2 = findViewById(R.id.editChapter);
        EditText editText3 = findViewById(R.id.editVerse);

        String message1 = editText.getText().toString();
        String message2 = editText2.getText().toString();
        String message3 = editText3.getText().toString();


        intent.putExtra(EXTRA_MESSAGE, message1);
        intent.putExtra(EXTRA_MESSAGE2, message2);
        intent.putExtra(EXTRA_MESSAGE3, message3);

        startActivity(intent);
    }
}
