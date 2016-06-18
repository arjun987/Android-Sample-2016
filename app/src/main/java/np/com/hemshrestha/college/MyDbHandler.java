package np.com.hemshrestha.college;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hereshem on 6/12/16.
 */
public class MyDbHandler extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "college";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_STUDENT = "students";


    public MyDbHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_STUDENT + " ( " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name VARCHAR(50), " +
                "address VARCHAR(250), " +
                "phone VARCHAR(50), " +
                "email VARCHAR(50), " +
                "image VARCHAR(250)" +
                ")";
        Log.i("DB", "onCreate sql = " + sql);
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS " + TABLE_STUDENT;
        Log.i("DB", "onUpdate sql = " + sql);
        db.execSQL(sql);
        onCreate(db);
    }

    public void insertStudent(Students s){
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "INSERT INTO " + TABLE_STUDENT + " (name, address, phone, email, image) VALUES (" +
                "'" + s.name + "', "+
                "'" + s.address + "', "+
                "'" + s.phone + "', "+
                "'" + s.email + "', "+
                "'" + s.image + "'"+
                ")";
        Log.i("DB", "insert sql = " + sql);
        db.execSQL(sql);
        db.close();
    }

    public List<Students> getStudents(){
        List<Students> list = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "SELECT * FROM " + TABLE_STUDENT;
//        Cursor cursor = db.rawQuery(sql, null);
        Cursor cursor = db.query(TABLE_STUDENT, null, null, null, null, null, null);

        if(cursor.moveToFirst()){
            do{
                int id = cursor.getInt(0);
                String name = cursor.getString(1);
                String address = cursor.getString(2);
                String phone = cursor.getString(cursor.getColumnIndex("phone"));
                String email = cursor.getString(cursor.getColumnIndex("email"));

                Students s = new Students(name, address, phone, email, cursor.getString(5));

                list.add(s);

            }while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return list;
    }

}
