package np.com.hemshrestha.college;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.HashMap;

public class AddContacts extends AppCompatActivity {

    String name, email, phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contacts);

        //if button clicked
        saveContact();
    }

    private void saveContact() {
        name = "Contact_name";
        email = "Contact_email";
        phone = "Contact_phone";

        // check validity
        // if(not valid){
        //   show error;
        //   return;
        // }

        AsyncTask<Void, Void, Void> task = new AsyncTask<Void, Void, Void>(){

            @Override
            protected Void doInBackground(Void... params) {
//
//                HashMap<String, String> map = new HashMap<>();
//                map.put("action", "add");
//                map.put("c_fname", name);
//                map.put("n_home", email);
//                map.put("n_mobile", phone);

                ServerRequest request = new ServerRequest();
                String url = "http://pi.hemshrestha.com.np/test/contacto.php?action=add" +
                        "&c_fname="+name +
                        "&n_home="+email +
                        "&n_mobile="+phone
                        ;

                request.httpGetData(url);


                return null;
            }
        };

        task.execute();
    }

}
