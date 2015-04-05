
package com.example.androidtrain01.contentProvider;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;



/**
 * 
  * @ClassName: PersonProvider
  * @Description: TODO实现ContentProvider来提供Person数据库统一的访问接口
  * @author Televehicle-luojp
  * @date 2015年3月16日 下午11:44:29
  *
 */
public class PersonProvider extends ContentProvider {  
    private DBOpenHelper dbOpenHelper;  
    private static final UriMatcher MATCHER = new UriMatcher(  
            UriMatcher.NO_MATCH);  
    private static final int PERSONS = 1;  
    private static final int PERSON = 2;  
    static {  
        MATCHER.addURI("com.televehicle.train.personProvider", "person", PERSONS);  
        MATCHER.addURI("com.televehicle.train.personProvider", "person/#", PERSON);  
    }  
  
    @Override  
    public boolean onCreate() {  
        // TODO Auto-generated method stub  
        this.dbOpenHelper = new DBOpenHelper(this.getContext());  
        return false;  
    }  
  
    @Override  
    public Cursor query(Uri uri, String[] projection, String selection,  
            String[] selectionArgs, String sortOrder) {  
        // TODO Auto-generated method stub  
        SQLiteDatabase db = dbOpenHelper.getReadableDatabase();  
        switch (MATCHER.match(uri)) {  
        case PERSONS:  
            return db.query("person", projection, selection, selectionArgs,  
                    null, null, sortOrder);  
  
        case PERSON:  
            long id = ContentUris.parseId(uri);  
            String where = "_id=" + id;  
            if (selection != null && !"".equals(selection)) {  
                where = selection + " and " + where;  
            }  
            return db.query("person", projection, where, selectionArgs, null,  
                    null, sortOrder);  
  
        default:  
            throw new IllegalArgumentException("Unkwon Uri:" + uri.toString());  
        }  
    }  
      
    //返回数据的MIME类型。  
    @Override  
    public String getType(Uri uri) {  
        // TODO Auto-generated method stub  
        switch (MATCHER.match(uri)) {  
        case PERSONS:  
            return "vnd.android.cursor.dir/person";  
  
        case PERSON:  
            return "vnd.android.cursor.item/person";  
  
        default:  
            throw new IllegalArgumentException("Unkwon Uri:" + uri.toString());  
        }  
    }  
  
    // 插入person表中的所有记录 /person  
    // 插入person表中指定id的记录 /person/10  
    @Override  
    public Uri insert(Uri uri, ContentValues values) {  
        // TODO Auto-generated method stub  
        SQLiteDatabase db = dbOpenHelper.getWritableDatabase();  
        switch (MATCHER.match(uri)) {  
        case PERSONS:  
            // 特别说一下第二个参数是当name字段为空时，将自动插入一个NULL。  
            long rowid = db.insert("person", "name", values);  
            Uri insertUri = ContentUris.withAppendedId(uri, rowid);// 得到代表新增记录的Uri  
            this.getContext().getContentResolver().notifyChange(uri, null);  
            return insertUri;  
  
        default:  
            throw new IllegalArgumentException("Unkwon Uri:" + uri.toString());  
        }  
    }  
  
    @Override  
    public int delete(Uri uri, String selection, String[] selectionArgs) {  
        // TODO Auto-generated method stub  
        SQLiteDatabase db = dbOpenHelper.getWritableDatabase();  
        int count = 0;  
        switch (MATCHER.match(uri)) {  
        case PERSONS:  
            count = db.delete("person", selection, selectionArgs);  
            return count;  
  
        case PERSON:  
            long id = ContentUris.parseId(uri);  
            String where = "_id=" + id;  
            if (selection != null && !"".equals(selection)) {  
                where = selection + " and " + where;  
            }  
            count = db.delete("person", where, selectionArgs);  
            return count;  
  
        default:  
            throw new IllegalArgumentException("Unkwon Uri:" + uri.toString());  
        }  
    }  
  
    @Override  
    public int update(Uri uri, ContentValues values, String selection,  
            String[] selectionArgs) {  
        // TODO Auto-generated method stub  
        SQLiteDatabase db = dbOpenHelper.getWritableDatabase();  
        int count = 0;  
        switch (MATCHER.match(uri)) {  
        case PERSONS:  
            count = db.update("person", values, selection, selectionArgs);  
            return count;  
        case PERSON:  
            long id = ContentUris.parseId(uri);  
            String where = "_id=" + id;  
            if (selection != null && !"".equals(selection)) {  
                where = selection + " and " + where;  
            }  
            count = db.update("person", values, where, selectionArgs);  
            return count;  
        default:  
            throw new IllegalArgumentException("Unkwon Uri:" + uri.toString());  
        }  
    }  
  
}
