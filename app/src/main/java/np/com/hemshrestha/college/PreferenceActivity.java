package np.com.hemshrestha.college;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class PreferenceActivity extends AppCompatActivity {

    CheckBox checkbox;
    EditText editText;
    Button button;

    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preference);

        preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        checkbox = (CheckBox) findViewById(R.id.checkBox);
        editText = (EditText) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean check = checkbox.isChecked();
                String text = editText.getText().toString();

                preferences.edit()
                        .putBoolean("check", check)
                        .putString("text", text)
                        .apply();
                finish();
            }
        });


        boolean b = preferences.getBoolean("check", true);

        checkbox.setChecked(b);

        String s = preferences.getString("text", "");
        editText.setText(s);


    }
}
