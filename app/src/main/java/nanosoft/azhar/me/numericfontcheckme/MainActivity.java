package nanosoft.azhar.me.numericfontcheckme;

import android.graphics.Typeface;
import android.inputmethodservice.Keyboard;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;

public class MainActivity extends AppCompatActivity {

    private EditText etNumericFont, editText2;
    private static final String[] COUNTRIES = new String[]{
            "Belgium", "France", "Italy", "Germany", "Spain"
    };

    Keyboard keyboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etNumericFont = (EditText) findViewById(R.id.etNumericFont);
        editText2 = (EditText) findViewById(R.id.editText2);

        Typeface face01 = Typeface.createFromAsset(getAssets(), "Digits.ttf");
        Typeface face02 = Typeface.createFromAsset(getAssets(), "waltograph42.otf");
        Typeface face03 = Typeface.createFromAsset(getAssets(), "waltographUI.ttf");
        Typeface face04 = Typeface.createFromAsset(getAssets(), "Apple Butter.ttf");
        Typeface face05 = Typeface.createFromAsset(getAssets(), "YIKES!__.TTF");
        Typeface face09 = Typeface.createFromAsset(getAssets(), "CaviarDreams.ttf");
        Typeface face06 = Typeface.createFromAsset(getAssets(), "CaviarDreams_Bold.ttf");
        Typeface face07 = Typeface.createFromAsset(getAssets(), "CaviarDreams_BoldItalic.ttf");
        Typeface face08 = Typeface.createFromAsset(getAssets(), "CaviarDreams_Italic.ttf");
        etNumericFont.setTypeface(face08);
        //  etNumericFont.setTypeface(face02);
        //   etNumericFont.setTypeface(face03);
        // editText2.setTypeface(face);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, COUNTRIES);
        AutoCompleteTextView textView = (AutoCompleteTextView)
                findViewById(R.id.autoCompleteTextView);
        textView.setAdapter(adapter);

        ArrayAdapter<String> adapterm = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, COUNTRIES);
        MultiAutoCompleteTextView multiAutoCompleteTextView = findViewById(R.id.multiAutoCompleteTextView);
        multiAutoCompleteTextView.setAdapter(adapterm);
        multiAutoCompleteTextView.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
    }


}
