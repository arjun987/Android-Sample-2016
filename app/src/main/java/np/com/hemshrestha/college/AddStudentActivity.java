package np.com.hemshrestha.college;

import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AddStudentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        String deviceId = Settings.System.getString(getContentResolver(),
                Settings.System.ANDROID_ID);
        DatabaseReference myRef = database.getReference(deviceId);

        DatabaseReference myName = myRef.child("name");
        myName.setValue("Hello, Worldetqwet!");

        myRef.child("email").setValue("hello@myemail.com");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.child("name").getValue(String.class);
                Log.d("firebase", "Value is: " + value);
                Toast.makeText(getApplicationContext(), value, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("firebase", "Failed to read value.", error.toException());
            }
        });

        //saveStudent();
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
