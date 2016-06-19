package np.com.hemshrestha.college;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    LinearLayout ll_student;
    LinearLayout ll_add_student;
    LinearLayout ll_preference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        ll_student = (LinearLayout) findViewById(R.id.students);
        ll_add_student = (LinearLayout) findViewById(R.id.add_student);
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

        ll_add_student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toast("Add Student Clicked");
                startActivity(new Intent(getApplicationContext(), AddStudentActivity.class));
            }
        });

        findViewById(R.id.add_contacts).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toast("Add Contact Clicked");
                startActivity(new Intent(getApplicationContext(), AddContacts.class));
            }
        });

    }

    private void toast(String s) {
        Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG).show();
    }

}
