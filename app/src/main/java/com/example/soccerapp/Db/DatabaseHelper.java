package com.example.soccerapp.Db;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.soccerapp.Methods.TeamsModel;
import com.example.soccerapp.Methods.UserModel;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    //Database version
    private static final int DATABASE_VERSION = 3;
    //Database Name
    public static final String DATABASE_NAME = "SOCCER_database";
    //Database Table name
    public static final String TABLE_NAME = "Users";
    public static final String TABLE2_NAME = "Arsenal";
    public static final String TABLE3_NAME = "Chelsea";
    public static final String TABLE4_NAME = "Liverpool";
    public static final String TABLE5_NAME = "Leicester";
    public static final String TABLE6_NAME = "ManU";
    public static final String TABLE7_NAME = "ManC";
    public static final String TABLE8_NAME = "spurs";


    //Table  Users columns
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String EMAIL = "email";
    public static final String PASS = "pass";
    public static final String PHONE = "phone";
    private SQLiteDatabase sqLiteDatabase;

    //Table Arsenal Columns
    public static final String ARSENAL_ID = "id";
    public static final String ARSENAL_NAME = "name";
    public static final String ARSENAL_POSITION = "position";
    public static final String ARSENAL_AGE = "age";

    private SQLiteDatabase sqLiteDatabase1;

    //Table Chelsea Columns
    public static final String CHELSEA_ID = "id";
    public static final String CHELSEA_NAME = "name";
    public static final String CHELSEA_POSITION = "email";
    public static final String CHELSEA_AGE = "age";

    private SQLiteDatabase sqLiteDatabase2;

    //Table Liverpool Columns
    public static final String LIVERPOOL_ID = "id";
    public static final String LIVERPOOL_NAME = "name";
    public static final String LIVERPOOL_POSITION = "email";
    public static final String LIVERPOOL_AGE = "age";

    private SQLiteDatabase sqLiteDatabase3;

    //Table Leicester Columns
    public static final String LEICESTER_ID = "id";
    public static final String LEICESTER_NAME = "name";
    public static final String LEICESTER_POSITION = "position";
    public static final String LEICESTER_AGE = "age";

    private SQLiteDatabase sqLiteDatabase4;

    //Table Manchester United Columns
    public static final String MANU_ID = "id";
    public static final String MANU_NAME = "name";
    public static final String MANU_POSITION = "position";
    public static final String MANU_AGE = "age";

    private SQLiteDatabase sqLiteDatabase5;

    //Table Manchester City Columns
    public static final String MANC_ID = "id";
    public static final String MANC_NAME = "name";
    public static final String MANC_POSITION = "position";
    public static final String MANC_AGE = "age";

    private SQLiteDatabase sqLiteDatabase6;


    //Table Spurs Columns
    public static final String SPURS_ID = "id";
    public static final String SPURS_NAME = "name";
    public static final String SPURS_POSITION = "position";
    public static final String SPURS_AGE = "age";

    private SQLiteDatabase sqLiteDatabase7;




    //creating table query
    private static final String CREATE_TABLE = "create table " + TABLE_NAME +"("+ID+
        " INTEGER PRIMARY KEY AUTOINCREMENT," + NAME + " TEXT NOT NULL,"+EMAIL+" TEXT NOT NULL, "+PASS+" TEXT NOT NULL,"+PHONE+" TEXT NOT NULL);";

    private static final String CREATE_TABLE1 = "create table " + TABLE2_NAME +"("+ARSENAL_ID+
            " INTEGER PRIMARY KEY AUTOINCREMENT," + ARSENAL_NAME + " TEXT NOT NULL,"+ARSENAL_POSITION+" TEXT NOT NULL, "+ARSENAL_AGE+" TEXT NOT NULL);";

    private static final String CREATE_TABLE2 = "create table " + TABLE3_NAME +"("+CHELSEA_ID+
            " INTEGER PRIMARY KEY AUTOINCREMENT," + CHELSEA_NAME + " TEXT NOT NULL,"+CHELSEA_POSITION+" TEXT NOT NULL, "+CHELSEA_AGE+" TEXT NOT NULL);";


    private static final String CREATE_TABLE3 = "create table " + TABLE3_NAME +"("+CHELSEA_ID+
            " INTEGER PRIMARY KEY AUTOINCREMENT," + CHELSEA_NAME + " TEXT NOT NULL,"+CHELSEA_POSITION+" TEXT NOT NULL, "+CHELSEA_AGE+" TEXT NOT NULL);";

    private static final String CREATE_TABLE4 = "create table " + TABLE4_NAME +"("+LIVERPOOL_ID+
            " INTEGER PRIMARY KEY AUTOINCREMENT," + LIVERPOOL_NAME + " TEXT NOT NULL,"+LIVERPOOL_POSITION+" TEXT NOT NULL, "+LIVERPOOL_AGE+" TEXT NOT NULL);";

    private static final String CREATE_TABLE5 = "create table " + TABLE5_NAME +"("+LEICESTER_ID+
            " INTEGER PRIMARY KEY AUTOINCREMENT," + LEICESTER_NAME + " TEXT NOT NULL,"+LEICESTER_POSITION+" TEXT NOT NULL, "+LEICESTER_AGE+" TEXT NOT NULL);";


    private static final String CREATE_TABLE6 = "create table " + TABLE6_NAME +"("+MANU_ID+
            " INTEGER PRIMARY KEY AUTOINCREMENT," + MANU_NAME + " TEXT NOT NULL,"+MANU_POSITION+" TEXT NOT NULL, "+MANU_AGE+" TEXT NOT NULL);";


    private static final String CREATE_TABLE7 = "create table " + TABLE7_NAME +"("+MANC_ID+
            " INTEGER PRIMARY KEY AUTOINCREMENT," + MANC_NAME + " TEXT NOT NULL,"+MANC_POSITION+" TEXT NOT NULL, "+MANC_AGE+" TEXT NOT NULL);";


    private static final String CREATE_TABLE8 = "create table " + TABLE8_NAME +"("+SPURS_ID+
            " INTEGER PRIMARY KEY AUTOINCREMENT," + SPURS_NAME + " TEXT NOT NULL,"+SPURS_POSITION+" TEXT NOT NULL, "+SPURS_AGE+" TEXT NOT NULL);";



    //Constructor
    public DatabaseHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(CREATE_TABLE);
        db.execSQL( CREATE_TABLE1 );
        db.execSQL( CREATE_TABLE2 );
        db.execSQL( CREATE_TABLE3 );
        db.execSQL( CREATE_TABLE4 );
        db.execSQL( CREATE_TABLE5 );
        db.execSQL( CREATE_TABLE6 );
        db.execSQL( CREATE_TABLE7 );
        db.execSQL( CREATE_TABLE8 );
    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE2_NAME);
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE3_NAME);
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE4_NAME);
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE5_NAME);
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE6_NAME);
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE7_NAME);
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE8_NAME);


        onCreate(db);
       // onCreate(db);
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

    //Add Arsenal Player Details

    public void addARSENAL(TeamsModel teamsModel){
        ContentValues contentValues = new ContentValues();
        contentValues.put( DatabaseHelper.ARSENAL_NAME, teamsModel.getName());
        contentValues.put( DatabaseHelper.ARSENAL_POSITION, teamsModel.getPosition());
        contentValues.put( DatabaseHelper.ARSENAL_AGE, teamsModel.getAge());

        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.insert( DatabaseHelper.TABLE2_NAME, null,contentValues);
    }

    //Add Chelsea Player Details

    public void addCHELSEA(TeamsModel teamsModel){
        ContentValues contentValues = new ContentValues();
        contentValues.put( DatabaseHelper.CHELSEA_NAME, teamsModel.getName());
        contentValues.put( DatabaseHelper.CHELSEA_POSITION, teamsModel.getPosition());
        contentValues.put( DatabaseHelper.CHELSEA_AGE, teamsModel.getAge());

        sqLiteDatabase2 = this.getWritableDatabase();
        sqLiteDatabase2.insert( DatabaseHelper.TABLE3_NAME, null,contentValues);
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

    //Display ArsenalPlayers Details
    public List<TeamsModel> getArsenalPlayerList(){
        String sql = "select * from " + TABLE2_NAME;
        sqLiteDatabase1 = this.getReadableDatabase();
        List<TeamsModel> storePlayer = new ArrayList<>();
        Cursor cursor = sqLiteDatabase1.rawQuery(sql,null);
        if (cursor.moveToFirst()){
            do {
                int Id = Integer.parseInt(cursor.getString(0));
                String name = cursor.getString(1);
                String position = cursor.getString(2);
                String age = cursor.getString( 3 );

                storePlayer.add(new TeamsModel(Id,name,position,age));
            }while (cursor.moveToNext());
        }
        cursor.close();
        return storePlayer;
    }

    //Display ChelseaPlayers Details
    public List<TeamsModel> getChelseaPlayerList(){
        String sql = "select * from " + TABLE3_NAME;
        sqLiteDatabase1 = this.getReadableDatabase();
        List<TeamsModel> storePlayer = new ArrayList<>();
        Cursor cursor = sqLiteDatabase1.rawQuery(sql,null);
        if (cursor.moveToFirst()){
            do {
                int Id = Integer.parseInt(cursor.getString(0));
                String name = cursor.getString(1);
                String position = cursor.getString(2);
                String age = cursor.getString( 3 );

                storePlayer.add(new TeamsModel(Id,name,position,age));
            }while (cursor.moveToNext());
        }
        cursor.close();
        return storePlayer;
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

    public void updateARSENAL(TeamsModel teamsModel){
        ContentValues contentValues = new ContentValues();
        contentValues.put( DatabaseHelper.ARSENAL_NAME,teamsModel.getName());
        contentValues.put( DatabaseHelper.ARSENAL_POSITION,teamsModel.getPosition());
        contentValues.put( DatabaseHelper.ARSENAL_AGE,teamsModel.getAge());
        sqLiteDatabase1 = this.getWritableDatabase();
        sqLiteDatabase1.update(TABLE2_NAME,contentValues,ID + " = ?" , new String[]
                {String.valueOf(teamsModel.getID())});
    }

    public void updateCHELSEA(TeamsModel teamsModel){
        ContentValues contentValues = new ContentValues();
        contentValues.put( DatabaseHelper.CHELSEA_NAME,teamsModel.getName());
        contentValues.put( DatabaseHelper.CHELSEA_POSITION,teamsModel.getPosition());
        contentValues.put( DatabaseHelper.CHELSEA_AGE,teamsModel.getAge());
        sqLiteDatabase2 = this.getWritableDatabase();
        sqLiteDatabase2.update(TABLE3_NAME,contentValues,ID + " = ?" , new String[]
                {String.valueOf(teamsModel.getID())});
    }


    public void deleteCHELSEA(int Id){
        sqLiteDatabase2= this.getWritableDatabase();
        sqLiteDatabase2.delete(TABLE3_NAME, ID + " = ? ", new String[]
                {String.valueOf(Id)});
    }


    public void deleteARSENAL(int Id){
        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.delete(TABLE2_NAME, ID + " = ? ", new String[]
                {String.valueOf(Id)});
    }





}
