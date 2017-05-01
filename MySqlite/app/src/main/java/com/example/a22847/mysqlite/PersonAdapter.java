package com.example.a22847.mysqlite;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by 22847 on 2017/4/14.
 */

public class PersonAdapter extends ArrayAdapter<Person>{
    //listview 每一行（单个对象的属性）展示
    private TextView id_tv;
    private TextView name_tv;
    private TextView age_tv;
    //adapter的参数列表
    private Context context;
    private int resources;
    private List<Person> persons;

    /**
     * 构造函数 PersonAdapter(this,R.layout.person_layout,person) ;this==MainActivity
     * @param context   标注哪个页面调用了，
     * @param resource  被调用的页面id
     * @param objects   传进来的参数类型
     */
    public PersonAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Person> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resources=resource;
        this.persons=objects;
    }
    /**
     *
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
    public View getView(int position, View convertView, ViewGroup parent){
        final Person p=persons.get(position);
        convertView= LayoutInflater.from(context).inflate(resources,parent,false);
        id_tv= (TextView) convertView.findViewById(R.id.id_tv);
        name_tv= (TextView) convertView.findViewById(R.id.name_tv);
        age_tv= (TextView) convertView.findViewById(R.id.age_tv);

        //给每一行的显示项赋值
        id_tv.setText(p.getId()+"");
        name_tv.setText(p.getName());
        age_tv.setText(p.getAge()+"");
        return convertView;
    }
}
