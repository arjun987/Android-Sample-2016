package np.com.hemshrestha.college;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class StudentListActivity extends AppCompatActivity {

    ListView listView;

    //String[] listItem = {"item 1", "item 2", "item 3", "item 4","item 1", "item 2", "item 3", "item 4","item 1", "item 2", "item 3", "item 4","item 1", "item 2", "item 3", "item 4"};

    List<Students> studentList;

    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);

        listView = (ListView) findViewById(R.id.listView);

        studentList = new ArrayList<>();
        studentList.add(new Students("Name1","Address","Phone 1","Email","Image"));
        studentList.add(new Students("Name2","Address","Phone 2","Phone","Image"));
        studentList.add(new Students("Name3","Address","Phone 3","Phone","Image"));
        studentList.add(new Students("Name4","Address","Phone 4","Phone","Image"));
        studentList.add(new Students("Name5","Address","Phone 5","Phone","Image"));
        studentList.add(new Students("Name6","Address","Phone 6","Phone","Image"));


        adapter = new ArrayAdapter(getApplicationContext(), R.layout.row_item, R.id.text, studentList){
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {

                View v = getLayoutInflater().inflate(R.layout.row_item, null);

                TextView title = (TextView) v.findViewById(R.id.title);
                TextView text = (TextView) v.findViewById(R.id.text);

                Students s = studentList.get(position);
                title.setText(s.getName());
                text.setText(s.getEmail());

                return v;

                //return super.getView(position, convertView, parent);
            }
        };

        listView.setAdapter(adapter);


    }
}
