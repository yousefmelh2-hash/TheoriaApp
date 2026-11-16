package com.example.yousef;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class HelperDB extends SQLiteOpenHelper {
    private static final String DB_NAME = "driving_b_db.db";
    private static final int DB_VERSION = 1;

    // Table and columns matching your generated database
    public static final String TABLE_QUESTIONS = "questions";
    public static final String COL_ID = "id";
    public static final String COL_CATEGORY = "category";
    public static final String COL_ANSWER_1 = "answer1";
    public static final String COL_ANSWER_2 = "answer2";
    public static final String COL_ANSWER_3 = "answer3";
    public static final String COL_CORRECT_ANSWER = "correct_answer";
    public static final String COL_QUESTION_TEXT = "question_text";
    public static final String COL_IMAGE_URI = "image_uri";


    public HelperDB(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        copyDatabase(context); // Copies assets/driving_b_db.db to the device on first run
    }
    private void copyDatabase(Context context) {
        File dbFile = context.getDatabasePath(DB_NAME);
        if (dbFile.exists()) return;

        dbFile.getParentFile().mkdirs();
        try (InputStream is = context.getAssets().open(DB_NAME);
             OutputStream os = new FileOutputStream(dbFile)) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
    }

    // 1. תמרורים
    public Question getTamrurimQuestion() {
        return getRandomQuestionByCategory("תמרורים");
    }

    // 2. חוקי התנועה
    public Question getHukeiHatnuaQuestion() {
        return getRandomQuestionByCategory("חוקי התנועה");
    }

    // 3. בטיחות בדרכים
    public Question getBetihutBadrachimQuestion() {
        return getRandomQuestionByCategory("בטיחות בדרכים"); // אם לא שינית את השם ב-DB, כתוב כאן "בטיחות"
    }

    // 4. הכרה לאוטו
    public Question getHakaratHarechevQuestion() {
        return getRandomQuestionByCategory("הכרה לאוטו"); // אם לא שינית את השם ב-DB, כתוב כאן "הכרת הרכב"
    }

    // מתודת עזר פנימית שמונעת שכפול קוד ומבצעת את השליפה בפועל
    private Question getRandomQuestionByCategory(String categoryName) {
        SQLiteDatabase db = this.getReadableDatabase();
        Question q = null;

        Cursor cursor = db.rawQuery(
                "SELECT * FROM " + TABLE_QUESTIONS + " WHERE " + COL_CATEGORY + " = ? ORDER BY RANDOM() LIMIT 1",
                new String[]{categoryName}
        );

        if (cursor.moveToFirst()) {
            q = new Question(
                    cursor.getInt(cursor.getColumnIndexOrThrow(COL_ID)),
                    cursor.getString(cursor.getColumnIndexOrThrow(COL_CATEGORY)),
                    cursor.getString(cursor.getColumnIndexOrThrow(COL_ANSWER_1)),
                    cursor.getString(cursor.getColumnIndexOrThrow(COL_ANSWER_2)),
                    cursor.getString(cursor.getColumnIndexOrThrow(COL_ANSWER_3)),
                    cursor.getString(cursor.getColumnIndexOrThrow(COL_CORRECT_ANSWER)),
                    cursor.getString(cursor.getColumnIndexOrThrow(COL_QUESTION_TEXT)),
                    cursor.getString(cursor.getColumnIndexOrThrow(COL_IMAGE_URI))
            );
        }
        cursor.close();
        return q;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
