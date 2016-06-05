package np.com.hemshrestha.college;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class StudentListActivity extends AppCompatActivity {

    ListView listView;

    String[] listItem = {"item 1", "item 2", "item 3", "item 4","item 1", "item 2", "item 3", "item 4","item 1", "item 2", "item 3", "item 4","item 1", "item 2", "item 3", "item 4"};

    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);

        listView = (ListView) findViewById(R.id.listView);

        adapter = new ArrayAdapter(getApplicationContext(), R.layout.row_item, R.id.text, listItem);

        listView.setAdapter(adapter);


    }
}
