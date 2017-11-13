package com.hfad.starbuzz;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class StarbuzzDatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "starbuzz"; // the name of our database
    private static final int DB_VERSION = 4; // the version of the database

    StarbuzzDatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        updateMyDatabase(db, 0, DB_VERSION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        updateMyDatabase(db, oldVersion, newVersion);
    }

    private static void insertDrink(SQLiteDatabase db, String name, String description,
                                    int resourceId) {
        ContentValues drinkValues = new ContentValues();
        drinkValues.put("NAME", name);
        drinkValues.put("DESCRIPTION", description);
        drinkValues.put("IMAGE_RESOURCE_ID", resourceId);
        db.insert("DRINK", null, drinkValues);
    }

    private static void insertCourses(SQLiteDatabase db, String prefix, String CourseNumber,
                                    String Description) {
        ContentValues courseValues = new ContentValues();
        courseValues.put("PREFIX", prefix);
        courseValues.put("COURSENUMBER", CourseNumber);
        courseValues.put("DESCRIPTION", Description);
        db.insert("COURSES", null, courseValues);
    }

    private void updateMyDatabase(SQLiteDatabase db, int oldVersion, int newVersion) {
        /*if (oldVersion < 1) {
            db.execSQL("CREATE TABLE DRINK (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "NAME TEXT, "
                    + "DESCRIPTION TEXT, "
                    + "IMAGE_RESOURCE_ID INTEGER);");
            insertDrink(db, "Latte", "Espresso and steamed milk", R.drawable.latte);
            insertDrink(db, "Cappuccino", "Espresso, hot milk and steamed-milk foam",
                    R.drawable.cappuccino);
            insertDrink(db, "Filter", "Our best drip coffee", R.drawable.filter);
        }
        if (oldVersion < 2) {
            db.execSQL("ALTER TABLE DRINK ADD COLUMN FAVORITE NUMERIC;");
        }*/
        if (true){
            db.execSQL("CREATE TABLE COURSES (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "PREFIX TEXT, "
                    + "COURSENUMBER TEXT, "
                    + "DESCRIPTION TEXT);");
            insertCourses(db, "CS", "116", "Entry Course");
            insertCourses(db, "CS", "216", "Data Structures");
            insertCourses(db, "CS", "316", "Algorithims");
            insertCourses(db, "CS", "401", "Networking");
            insertCourses(db, "CS", "403", "Android Development");

        }
    }
}
