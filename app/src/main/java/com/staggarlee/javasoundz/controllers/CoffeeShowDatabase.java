/*package com.staggarlee.javasoundz.controllers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import com.staggarlee.javasoundz.models.CoffeeShow;

/**
 * Created by nicolas on 5/27/15.
 */
/*
public class CoffeeShowDatabase extends SQLiteOpenHelper {

    //Create a database for the specific venue
    private static final int DB_VERSION = 1;
    private static final String DB_NAME = CoffeeShow.getLocation() + ".db";

    //Create a table to list all the shows at this venue, by date
    public static final String TABLE_SHOWS = "SHOWS";
    public static final String COLUMN_DATE = "DATE";
    public static final String COLUMN_VENUE = "VENUE";
    private static String CREATE_SHOWS =
                    "CREATE TABLE " + TABLE_SHOWS +
                    " ( " + BaseColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_DATE + " INTEGER" +
                    COLUMN_VENUE + " TEXT)";

    // Creating a table for each show, named after the date of the show
    public static final String TABLE_SETS = "SETS";
    public static final String COLUMN_ARTIST = "ARTIST";
    public static final String COLUMN_SET_LENGTH = "SET_LENGTH";
    public static final String FOREIGN_KEY_COLUMN_DATE = "DATE";
    public static final String COLUMN_SET_SLOT = "SET_SLOT";

    private static String CREATE_SHOW =
                    "CREATE TABLE " + TABLE_SETS +
                    " ( " + BaseColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_ARTIST + " TEXT, " +
                    COLUMN_VENUE + " TEXT, " +
                    COLUMN_SET_SLOT + " INTEGER, " +
                    COLUMN_SET_LENGTH + " INTEGER, " +
                    "FOREIGN KEY ( " + FOREIGN_KEY_COLUMN_DATE + " INTEGER" + " ))";


    public CoffeeShowDatabase(Context context) {
        super(context, DB_NAME, null, DB_VERSION);

    }

    public void setCoffeeShowDatabase(CoffeeShow coffeeshow) {

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_SHOWS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
*/