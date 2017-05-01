package com.example.a22847.mysqlite;

/**
 * Created by 22847 on 2017/4/16.
 */

public class TeacherCourse {
    private String term;
    private String teacher_id;
    private String teacher_name;
    private String pattern;
    private String html;

    public TeacherCourse(String term, String teacher_id, String teacher_name, String pattern, String html) {
        this.term = term;
        this.teacher_id = teacher_id;
        this.teacher_name = teacher_name;
        this.pattern = pattern;
        this.html = html;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(String teacher_id) {
        this.teacher_id = teacher_id;
    }

    public String getTeacher_name() {
        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }
}
