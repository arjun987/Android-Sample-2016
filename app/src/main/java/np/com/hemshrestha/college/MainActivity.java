package np.com.hemshrestha.college;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    LinearLayout ll_student, ll_teacher;
    LinearLayout ll_preference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        ll_student = (LinearLayout) findViewById(R.id.students);
        ll_teacher = (LinearLayout) findViewById(R.id.teachers);
        ll_preference = (LinearLayout) findViewById(R.id.preference);

        ll_student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toast("Student Clicked");
                startActivity(new Intent(getApplicationContext(), StudentListActivity.class));
            }
        });
        ll_preference.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toast("Preference Clicked");
                startActivity(new Intent(getApplicationContext(), PreferenceActivity.class));
            }
        });

        ll_teacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toast("Teacher Clicked");
            }
        });


    }

    private void toast(String s) {
        Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG).show();
    }

}
