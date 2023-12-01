package com.mindfulness.mindfulmoment;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper2 extends SQLiteOpenHelper {

    public static  final String DATABASE_TODO ="todolist.db";
    public static final String TABLE_STUDENT ="student_table";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_NAME = "NAME";
    public static final String COLUMN_DATE = "DATE";
    public static final String COLUMN_TIME = "TIME";

    public DatabaseHelper2(Context context) {
        super(context, DATABASE_TODO, null, 1);
        //SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // Define the CREATE TABLE query
        String CREATE_STUDENT_TABLE_QUERY = "CREATE TABLE " + TABLE_STUDENT
                + "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_NAME + " TEXT, "
                + COLUMN_DATE + " DATE, "
                + COLUMN_TIME + " INT)";
        sqLiteDatabase.execSQL(CREATE_STUDENT_TABLE_QUERY);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // This method is called when the database needs to be upgraded.
    }


    public boolean insertData(String name, String course,String marks){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_NAME,name);
        contentValues.put(COLUMN_DATE,course);
        contentValues.put(COLUMN_TIME,marks);
        // Insert the values into the table
        long result = db.insert(TABLE_STUDENT,null,contentValues);
        if(result == -1){
            return false;// Insertion failed
        }else{
            return true;// Insertion successful
        }
    }
    public Cursor getAllData(){
        SQLiteDatabase db = this.getReadableDatabase();
        // Retrieve all data from the table
        Cursor result = db.rawQuery("SELECT * FROM "+TABLE_STUDENT,null);
        return result;
    }

    public boolean updateData(String id,String name,String course,String marks){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_ID,id);
        contentValues.put(COLUMN_NAME,name);
        contentValues.put(COLUMN_DATE,course);
        contentValues.put(COLUMN_TIME,marks);
        // Update the values in the table for the given ID
        long count = db.update(TABLE_STUDENT,contentValues,
                "ID = ?",new String[]{id});
        if(count > 0){
            return true;
        }else{
            return false;
        }
    }

    public int deleteData(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        // Delete the row from the table for the given ID
        return db.delete(TABLE_STUDENT,"ID = ?",new String[]{id});
    }

}
