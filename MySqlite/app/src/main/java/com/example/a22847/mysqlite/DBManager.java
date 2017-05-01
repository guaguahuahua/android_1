package com.example.a22847.mysqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 22847 on 2017/4/16.
 */

public class DBManager {
    /**
     * result 存放查询到的String类型的html
     */
    private static String result="";

    /****************************************************************************查询函数---返回值均为String型的网页*****************************************************************************/
    /**
     *查询老师课表
     * @param db              数据库名
     * @param term           学期
     * @param teacher_id    老师id
     * @param teacher_name  老师姓名
     * @param pattern        格式1或2
     * @return                String 类型的网页
     */
    public static String teacherCourseQuery(SQLiteDatabase db,String term,String teacher_id,String teacher_name,String pattern){
        String sql="select html from teacher_course where term='"+term+"' and teacher_id='"+teacher_id+"' and teacher_name='"+teacher_name+"' and pattern='"+pattern+"'";
        Cursor cursor=db.rawQuery(sql,null);
        while(cursor.moveToNext()){
            result=cursor.getString(cursor.getColumnIndex("html"));
        }
        db.close();
        cursor.close();
        return result;
    }

    /**
     *插叙课程课表
     * @param db             数据库名
     * @param term           学期
     * @param course_id     课程编号
     * @param course_name   课程名
     * @                      String 类型的网页
     */
    public static String courseTableQuery(SQLiteDatabase db,String term,String course_id,String course_name){
        String sql="select html from course_table where term='"+term+"' and course_id='"+course_id+"' and course_name='"+course_name+"'";
        Cursor cursor=db.rawQuery(sql,null);
        while(cursor.moveToNext()){
            result=cursor.getString(cursor.getColumnIndex("html"));
        }
        db.close();
        cursor.close();
        return result;
    }

    /**
     *查询教室课表
     * @param db                 数据库名称
     * @param term              学期
     * @param pattern           格式1或2
     * @param area              区域
     * @param teach_building   教学楼
     * @return                  String 类型的网页
     */
    public static String classroomTableQuery(SQLiteDatabase db,String term,String pattern,String area,String teach_building){
        String sql="select html from classroom_table where term='"+term+"' and pattern='"+pattern+"' and area='"+area+"' and teach_building='"+teach_building+"'";
        Cursor cursor=db.rawQuery(sql,null);
        while(cursor.moveToNext()){
            result=cursor.getString(cursor.getColumnIndex("html"));
        }
        db.close();
        cursor.close();
        return result;
    }
    /**
     *查询任选课表
     * @param db     数据库名
     * @param term   学期
     * @param area   区域
     * @return       String 类型的网页
     */
    public static String optionalTableQuery(SQLiteDatabase db,String term,String area){
        String sql="select html from optional_table where term='"+term+"' and area='"+area+"'";
        Cursor cursor=db.rawQuery(sql,null);
        while(cursor.moveToNext()){
            result=cursor.getString(cursor.getColumnIndex("html"));
        }
        db.close();
        cursor.close();
        return result;
    }
    /****************************************************************************插入函数---返回值均为空*****************************************************************************/
    /**
     *向老师课表中插入值
     * @param db             数据库名
     * @param term           学期
     * @param teacher_id     教师id
     * @param teacher_name  教师姓名
     * @param pattern       格式1或2
     * @param html          抓取的静态网页
     */
    public static void insertIntoTeaherCourse(SQLiteDatabase db,String term,String teacher_id,String teacher_name,String pattern,String html){
        String sql="insert into teacher_course values('"+term+"','"+teacher_id+"','"+teacher_name+"','"+pattern+"','"+html+"')";
        db.execSQL(sql);
    }

    /**
     *向课程课表中插入值
     * @param db            数据库名
     * @param term          学期
     * @param course_id     课程id
     * @param course_name   课程名
     * @param html           抓取的静态网页
     */
    public static void insertIntoCourseTable(SQLiteDatabase db,String term,String course_id,String course_name,String html){
        String sql="insert into course_table values('"+term+"','"+course_id+"','"+course_name+"','"+html+"')";
        db.execSQL(sql);
    }

    /**
     *向教室课表中插入值
     * @param db                数据库名
     * @param term              学期
     * @param pattern           格式1或2
     * @param area              校区
     * @param teach_building    教学楼
     * @param html               抓取的静态网页
     */
    public static void insertIntoClassroomTable(SQLiteDatabase db,String term,String pattern,String area,String teach_building,String html){
        String sql="insert into classroom_table values('"+term+"','"+pattern+"','"+area+"','"+teach_building+"','"+html+"')";
        db.execSQL(sql);
    }

    /**
     *向“任选课表”中插入值
     * @param db       数据库名
     * @param term      学期
     * @param area      校区
     * @param html      抓取的静态网页
     */
    public static void insertIntoOptionalTable(SQLiteDatabase db,String term,String area,String html){
        String sql="insert into optional_table values('"+term+"','"+area+"','"+html+"')";
        db.execSQL(sql);
    }
    /****************************************************************************spinnerContent函数*****************************************************************************/
    /**
     *查询下拉框中所有的课程名
     * @param db 给定数据库对象
     * @return   返回一个list对象，如果有数据，那么其中的数据是SpinnerContent类型的
     */
    public static List<SpinnerContent> getCourseSpinner(SQLiteDatabase db){
        List<SpinnerContent>result=new ArrayList<SpinnerContent>();
        String sql="select * from spinner_course";
        Cursor cursor=db.rawQuery(sql,null);
        Log.i("ring","执行了spinnerCourse中的sql语句");
        while(cursor.moveToNext()){
            String key=cursor.getString(cursor.getColumnIndex("key"));
            String value=cursor.getString(cursor.getColumnIndex("value"));
            SpinnerContent sc=new SpinnerContent(key,value);
            result.add(sc);
        }
        db.close();
        cursor.close();
        return result;
    }

    /**
     *查询下拉框中所有的老师姓名
     * @param db
     * @return   内容同getCourseSpinner
     */
    public static List<SpinnerContent> getTeacherSpinner(SQLiteDatabase db){
        List<SpinnerContent>result=new ArrayList<SpinnerContent>();
        String sql="select * from spinner_teacher";
        Cursor cursor=db.rawQuery(sql,null);
        while(cursor.moveToNext()){
            String key=cursor.getString(cursor.getColumnIndex("key"));
            String value=cursor.getString(cursor.getColumnIndex("value"));
            SpinnerContent sc=new SpinnerContent(key,value);
            result.add(sc);
        }
        db.close();
        cursor.close();
        return result;
    }
    /**
     *插入键值对到数据库
     * @param db     数据库对象
     * @param key    id值
     * @param value  value值
     */
    public static void setCourseSpinner(SQLiteDatabase db,String key,String value){
        String sql="insert into spinner_course values('"+key+"','"+value+"')";
        db.execSQL(sql);
        db.close();
    }

    /**
     *内容和参数同setCourseSpinner
     * @param db
     * @param key
     * @param value
     */
    public static void setTeacherSpinner(SQLiteDatabase db,String key,String value){
        String sql="insert into spinner_teacher values('"+key+"','"+value+"')";
        db.execSQL(sql);
        db.close();
    }

    /****************************************************************************模糊查询函数*****************************************************************************/

    /**
     * 模糊查询函数
     * @param db    数据库对象
     * @param input 用户输入的字符片段
     * @return      返回所有相关的结果，保存在List中
     */
    public static List<SpinnerContent> teacherSpinnerVagueSearch(SQLiteDatabase db,String input){
        List<SpinnerContent> result=new ArrayList<SpinnerContent>();
        String sql="select * from spinner_teacher where value like '%"+input+"%'";
        Cursor cursor=db.rawQuery(sql,null);
        while(cursor.moveToNext()){
            String key=cursor.getString(cursor.getColumnIndex("key"));
            String value=cursor.getString(cursor.getColumnIndex("value"));
            SpinnerContent sc=new SpinnerContent(key,value);
            result.add(sc);
        }
        db.close();
        cursor.close();
        return result;
    }
    /****************************************************************************插入下拉框值函数*****************************************************************************/

    public static void insertIntoCampus(SQLiteDatabase db,String id,String campusName){
        String sql="insert into campus values('"+id+"','"+campusName+"')";
        db.execSQL(sql);
        db.close();
    }
    public static void insertIntoBuilding(SQLiteDatabase db,String id,String buildingName){
        String sql="insert into building values('"+id+"','"+buildingName+"')";
        db.execSQL(sql);
        db.close();
    }
    public static void insertIntoClassroom(SQLiteDatabase db,String id,String classroom){
        String sql="insert into building values('"+id+"','"+classroom+"')";
        db.execSQL(sql);
        db.close();
    }
    /****************************************************************************查询下拉框值函数*****************************************************************************/
    //获取到list
    public static List<SpinnerContent> getCampusSpinnerContent(SQLiteDatabase db){
        String querysql="select * from campus";
        Cursor cursor=db.rawQuery(querysql,null);
        List <SpinnerContent> list=cursorToList(cursor,"campusName");
        cursor.close();
        return list;
    }
    public static List<SpinnerContent> getBuildingSpinnerContent(SQLiteDatabase db){

        String querysql="select * from building";
        Cursor cursor=db.rawQuery(querysql,null);
        List <SpinnerContent> list=cursorToList(cursor,"buildingName");
        cursor.close();
        return list;
    }
    public static List<SpinnerContent> getClassroomSpinnerContent(SQLiteDatabase db){
        String querysql="select * from classroom";
        Cursor cursor=null;
        cursor=db.rawQuery(querysql,null);
        List <SpinnerContent> list=cursorToList(cursor,"classroom");
        cursor.close();
        return list;
    }


    private static List<SpinnerContent> cursorToList(Cursor cursor,String name){
        List<SpinnerContent> list=new ArrayList<>();
        while(cursor.moveToNext()){
            SpinnerContent sc=new SpinnerContent(cursor.getString(cursor.getColumnIndex("id")),cursor.getString(cursor.getColumnIndex(name)));
            list.add(sc);
        }
        return list;
    }


















}
