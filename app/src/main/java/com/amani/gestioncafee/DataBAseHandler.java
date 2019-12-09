package com.amani.gestioncafee;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class DataBAseHandler extends SQLiteOpenHelper {
    String password;
    private static final String TABLE_SIGNUP= "signup";
    public static final String KEY_ID = "id";
    public static final String KEY_USER_NAME = " Username";
    public static final String KEY_NAME = "name";
    public static final String KEY_EMAIL="email";
    public static final String KEY_PASSWORD = "password";
    private static final String DATABASE_NAME ="Mydatabase.db" ;
    private static final int DATABASE_VERSION = 1;
    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_SIGNUP + "("
            + KEY_ID + " INTEGER PRIMARY KEY," + KEY_USER_NAME + " TEXT,"+KEY_NAME + " TEXT,"+KEY_EMAIL+ " TEXT,"
             + KEY_PASSWORD + " TEXT " + ")";

    public DataBAseHandler(Context context, Object name, Object factory, int version) {
        // TODO Auto-generated constructor stub
        super(context,  DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SIGNUP);

        // Create tables again
        onCreate(db);

    }



    void addsignup(signupdata signupdata)
    // code to add the new register
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME,signupdata.getName()); // register first Name
        values.put(KEY_USER_NAME, signupdata. getUsername() ); // register last name
        values.put(KEY_EMAIL, signupdata.getEmail());//register email id
        values.put(KEY_PASSWORD, signupdata.getPassword());
        // Inserting Row

        db.insert(TABLE_SIGNUP, null, values);
        db.close(); // Closing database connection

    }




    String getsignup(String username){
        SQLiteDatabase db = this.getReadableDatabase();
        //String selectquery="SELECT * FROM TABLE_REGISTER";
        Cursor cursor=db.query(TABLE_SIGNUP,null,  "email=?",new String[]{username},null, null, null, null);


        if(cursor.getCount()<1){
            cursor.close();
            return "Not Exist";
        }
        else if(cursor.getCount()>=1 && cursor.moveToFirst()){

            password = cursor.getString(cursor.getColumnIndex(KEY_PASSWORD));
            cursor.close();

        }
        return password;


    }


    public String getDatabaseName() {
        return DATABASE_NAME;
    }

    public static String getKeyId() {
        return KEY_ID;
    }

    public static String getTableContacts() {
        return TABLE_SIGNUP;
    }

    public static int getDatabaseVersion() {
        return DATABASE_VERSION;
    }

}


