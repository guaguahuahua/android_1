package com.example.a22847.mysqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    //调用数据库创建帮主函数
    private MySqliteHelper helper;
    //将查询到的数据进行显示
    private PersonAdapter adapter;
//    private TeacherCourseAdapter tc_adapter;
    private ListView person_lv;
    List<Person> person=new ArrayList<Person>();
//    List<TeacherCourse> teacher_course=new ArrayList<TeacherCourse>();
    //获得用户输入的信息,
    private String term;         //学期号
    private String teacher_id;  //老师id
    private String teacher_name;//老师姓名
    private String pattern;     //按照什么格式显示
    private String html;        //静态的html网页

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        helper=new MySqliteHelper(this);
        //listview 显示数据
        adapter=new PersonAdapter(this,R.layout.person_layout,person);
//        tc_adapter=new TeacherCourseAdapter(this,R.layout.teachercourse_layout,teacher_course);
        person_lv=(ListView)findViewById(R.id.persons_lv);
        person_lv.setAdapter(adapter);//有多少条数据就会自动调用多少次adapter
//        person_lv.setAdapter(tc_adapter);
    }
    public void createdb(View view) {//创建数据库
        SQLiteDatabase db=helper.getWritableDatabase();
        helper.onCreate(db);//调用数据库表的创建方法
    }
    public void insert(View view){
        SQLiteDatabase db=helper.getWritableDatabase();
//        DBManager.insertIntoTeaherCourse(db,"1","0001","dante.zyd","1","test");
//        DBManager.insertIntoCourseTable(db,"1","3120811025","mathematics","this is a test");
//        DBManager.insertIntoClassroomTable(db,"2","2","qujiangxiaoqu","78","test insert into classroom table");
        DBManager.insertIntoOptionalTable(db,"2","jiangsuProvince","test insertIntoOptionaltable");
    }


    public void query(View view){
        SQLiteDatabase db=helper.getReadableDatabase();
        String r=DBManager.teacherCourseQuery(db,"1","0012","gaoyun","2");
//        String r1=DBManager.courseTableQuery(db,"1","2312","fjskf");
//        String r2=DBManager.classroomTableQuery(db,"1","2","XIXIANXINQU","building3");
//        String r3=DBManager.optionalTableQuery(db,"1","QUJIANGXIAOQU");
        System.out.println("r:"+r);
//        System.out.println("r1:"+r1);
//        System.out.println("r2:"+r2);
//        System.out.println("r3:"+r3);
    }

    public void testSpinner(View view) {
        SQLiteDatabase db=helper.getReadableDatabase();
        List<SpinnerContent> result=new ArrayList<SpinnerContent>();
//        result.addAll(DBManager.getCourseSpinner(db));//这块需要addAll方法，不可以将一个集合整体的赋值给另一个集合
//        System.out.println("result.size():"+result.size());
//        for(int i=0;i<result.size();i++){
//            System.out.println(result.get(i).getKey()+" "+result.get(i).getValue());
//        }
//        DBManager.setCourseSpinner(db,"007","bound");
//        DBManager.setTeacherSpinner(db,"007","bound");
//        result.addAll(DBManager.teacherSpinnerVagueSearch(db,"ne"));
//        for(int i=0;i<result.size();i++){
//            System.out.println(result.get(i).getKey()+" "+result.get(i).getValue());
//        }
//        DBManager.insertIntoCampus(db,"fdsljfj","public");
        result.addAll(DBManager.getCampusSpinnerContent(db));
        for(int i=0;i<result.size();i++){
            System.out.println(result.get(i).getKey()+" "+result.get(i).getValue());
        }
    }
}