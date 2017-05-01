package com.example.a22847.mysqlite;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import static com.example.a22847.mysqlite.R.id.age_tv;
import static com.example.a22847.mysqlite.R.id.id_tv;
import static com.example.a22847.mysqlite.R.id.name_tv;

/**
 * Created by 22847 on 2017/4/16.
 */

public class TeacherCourseAdapter extends ArrayAdapter<TeacherCourse>{

    private TextView term_tv;
    private TextView teacher_id_tv;
    private TextView teacher_name_tv;
    private TextView pattern_tv;
    private TextView html_tv;
    //adapter的参数列表
    private Context context;
    private int resources;
    private List<TeacherCourse> teacherCourses;


    public TeacherCourseAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<TeacherCourse> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resources=resource;
        this.teacherCourses=objects;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        final TeacherCourse tc=teacherCourses.get(position);//从list中获得一个对象
        convertView= LayoutInflater.from(context).inflate(resources,parent,false);
        term_tv= (TextView) convertView.findViewById(R.id.term_tv);
        teacher_id_tv= (TextView) convertView.findViewById(R.id.teacer_id_tv);
        teacher_name_tv= (TextView) convertView.findViewById(R.id.teacher_name_tv);
        pattern_tv=(TextView) convertView.findViewById(R.id.pattern_tv);
        html_tv=(TextView) convertView.findViewById(R.id.html_tv);

        //给每一行的显示项赋值
        term_tv.setText(tc.getTerm());
        teacher_id_tv.setText(tc.getTeacher_id());
        teacher_name_tv.setText(tc.getTeacher_name());
        pattern_tv.setText(tc.getPattern());
        html_tv.setText(tc.getHtml());
        return convertView;
    }
}
