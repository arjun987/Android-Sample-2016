package np.com.hemshrestha.college;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class AddStudentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        saveStudent();
    }

    private void saveStudent() {

        String name = "Adrin";
        String email = "Adrinsdgsd";
        String phone = "Adrinasgdsg";
        String address = "Adrinadg";
        String image = "Adrindg";

        MyDbHandler db = new MyDbHandler(getApplicationContext());
        Students s = new Students(name, email, phone, address, image);
        db.insertStudent(s);


    }
}
