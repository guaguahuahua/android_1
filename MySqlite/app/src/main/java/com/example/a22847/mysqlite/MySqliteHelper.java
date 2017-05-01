package com.example.a22847.mysqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
    /**
     * SQLiteOpenHelper:帮助类
     */
    public class MySqliteHelper extends SQLiteOpenHelper{
    /**
     * 继承了父类的构造函数
     * @param context  上下文环境
     * @param name     数据库名称
     * @param factory 游标工厂
     * @param version 版本>=1
     */
    public MySqliteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    /**
     * 自行创建的构造函数
     */
    public MySqliteHelper(Context context){
        super(context,"infor.db",null,1);
        Log.i("执行构造函数","///");
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
//        String sql="create table person (id Integer,name varchar(10),age Integer)";
//        String sql="create table teacher_course(term varchar(8),teacher_id varchar(32),teacher_name varchar(32),pattern varchar(8),html text)";
//        String sql="create table course_table(term varchar(32),course_id varchar(32),course_name varchar(32),html text)";
//        String sql="create table classroom_table(term varchar(32),pattern varchar(32),area varchar(32),teach_building varchar(32),html text)";
//        String sql="create table optional_table(term varchar(32),area varchar(32),html text)";
//        String sql="create table spinner_course(key varchar(32),value varchar(32))";
//        String sql="create table spinner_teacher(key varchar(32),value varchar(32))";
        String sql1="create table campus(id varchar(32),campusName varchar(32))";
        String sql2="create table building(id varchar(32),buildingName varchar(32))";
        String sql3="create table classroom(id varchar(32),classroom varchar(32))";
        db.execSQL(sql2);
        db.execSQL(sql3);
        Log.i("创建数据库","///");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.i("数据库升级","///");
    }
    public void onOpen(SQLiteDatabase db){
        super.onOpen(db);
        Log.i("打开数据库","///");
    }
}
