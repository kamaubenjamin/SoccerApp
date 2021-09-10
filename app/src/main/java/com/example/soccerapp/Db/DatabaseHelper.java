package com.example.soccerapp.Db;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.soccerapp.Methods.UserModel;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    //Database version
    private static final int DATABASE_VERSION = 1;
    //Database Name
    public static final String DATABASE_NAME = "SOCCER_database";
    //Database Table name
    public static final String TABLE_NAME = "Users";
    //Table columns
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String EMAIL = "email";
    public static final String PASS = "pass";
    public static final String PHONE = "phone";
    private SQLiteDatabase sqLiteDatabase;


    //creating table query
    private static final String CREATE_TABLE = "create table " + TABLE_NAME +"("+ID+
        " INTEGER PRIMARY KEY AUTOINCREMENT," + NAME + " TEXT NOT NULL,"+EMAIL+" TEXT NOT NULL, "+PASS+" TEXT NOT NULL,"+PHONE+" TEXT NOT NULL);";
    //Constructor
    public DatabaseHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    //Add USER Data
    public void addUSER(UserModel StudentModel){
        ContentValues contentValues = new ContentValues();
        contentValues.put( DatabaseHelper.NAME, StudentModel.getName());
        contentValues.put( DatabaseHelper.EMAIL, StudentModel.getEmail());
        contentValues.put( DatabaseHelper.PASS, StudentModel.getPass());
        contentValues.put( DatabaseHelper.PHONE, StudentModel.getPhone());
        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.insert( DatabaseHelper.TABLE_NAME, null,contentValues);
    }
//Select All Data Stored To Display
    public List<UserModel> getEmployeeList(){
        String sql = "select * from " + TABLE_NAME;
        sqLiteDatabase = this.getReadableDatabase();
        List<UserModel> storeStudent = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.rawQuery(sql,null);
        if (cursor.moveToFirst()){
            do {
                int id = Integer.parseInt(cursor.getString(0));
                String name = cursor.getString(1);
                String email = cursor.getString(2);
                String pass = cursor.getString( 3 );
                String phone = cursor.getString( 4 );
                storeStudent.add(new UserModel(id,name,email,pass,phone));
            }while (cursor.moveToNext());
        }
        cursor.close();
        return storeStudent;
    }
    public Boolean checkusername(String username) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from Users where username = ?", new String[]{username});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;

    }
    public  Boolean checkUsernamePassword(String username, String password) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from Users where username = ? and password = ?", new String[]{username, password});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;


    }
    //Not in Use
  /*  public ArrayList<String> checkuserDetails(String username, String password) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor res = MyDB.rawQuery( "Select * from users where username = ? and password = ?", new String[]{username, password} );
        ArrayList array_list = new ArrayList<String>();
        if (res.getCount() > 0) {

            res.moveToFirst();

            while (res.isAfterLast() == false) {
                if (array_list.size() < 2{
                    array_list.add( res.getString( res.getColumnIndex( "username" ) ) );

                }
                res.moveToNext();
            }
        }
        return array_list;
    }

   */






    public void updateSTUDENT(UserModel UserModel){
        ContentValues contentValues = new ContentValues();
        contentValues.put( DatabaseHelper.NAME,UserModel.getName());
        contentValues.put( DatabaseHelper.EMAIL,UserModel.getEmail());
        contentValues.put( DatabaseHelper.PHONE,UserModel.getPhone());
        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.update(TABLE_NAME,contentValues,ID + " = ?" , new String[]
                {String.valueOf(UserModel.getId())});
    }



    public void deleteSTUDENT(int Id){
        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.delete(TABLE_NAME, ID + " = ? ", new String[]
                {String.valueOf(Id)});
    }

}
