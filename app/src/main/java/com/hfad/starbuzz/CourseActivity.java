package com.hfad.starbuzz;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class CourseActivity extends Activity {
    public static final String EXTRA_COURSEID = "courseId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);

        //Get the drink from the intent
        int courseId = (Integer)getIntent().getExtras().get(EXTRA_COURSEID);

        //Create a cursor
        SQLiteOpenHelper starbuzzDatabaseHelper = new StarbuzzDatabaseHelper(this);
        try {
            SQLiteDatabase db = starbuzzDatabaseHelper.getReadableDatabase();
            Cursor cursor = db.query ("COURSES",
                    new String[] {"PREFIX", "COURSENUMBER", "DESCRIPTION"},
                    "_id = ?",
                    new String[] {Integer.toString(courseId)},
                    null, null,null);
            //Move to the first record in the Cursor
            if (cursor.moveToFirst()) {
                //Get the drink details from the cursor
                String prefixText = cursor.getString(0);
                String courseNumberText = cursor.getString(1);
                String descriptionText = cursor.getString(2);

                //Populate the drink name
                TextView prefix = (TextView)findViewById(R.id.name);
                prefix.setText(prefixText + " " + courseNumberText);

                //Populate the drink description
                TextView description = (TextView)findViewById(R.id.description);
                description.setText(descriptionText);


            }
        } catch(SQLiteException e) {
            Toast toast = Toast.makeText(this, "Database unavailable", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}