package np.com.hemshrestha.college;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ContactListActivity extends AppCompatActivity {

    ListView listView;

    List<Students> studentList;

    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);

        listView = (ListView) findViewById(R.id.listView);

        new AsyncTask<Void, Void, String>(){

            @Override
            protected String doInBackground(Void... params) {
                ServerRequest req = new ServerRequest();
                return req.httpGetData("http://api.hemshrestha.com.np?action=list");
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                // populate list
                getDataFromString(s);
                populateData();
            }
        }.execute();


    }

    private void getDataFromString(String s) {
        studentList = new ArrayList<>();
        try {
            JSONObject jObj = new JSONObject(s);
            JSONArray jArr = jObj.getJSONArray("data");
            for (int i = 0; i < jArr.length(); i++) {
                JSONObject j = jArr.getJSONObject(i);
                Students st = new Students(j.getString("c_fname"),j.getString("n_home"),j.getString("n_mobile"),j.getString("n_office"),j.getString("c_lname"));
                studentList.add(st);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void populateData() {

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
