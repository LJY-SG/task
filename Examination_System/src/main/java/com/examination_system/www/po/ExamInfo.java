package com.examination_system.www.po;

import java.util.Date;

public class ExamInfo {

    private int id;
    private String time;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String address;
    private String subject;

    private String PaperName;

    private String status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getPaperName() {
        return PaperName;
    }

    public void setPaperName(String paperName) {
        PaperName = paperName;
    }

    @Override
    public String toString() {
        return "exam{" +
                "name=" + name +
                ",time=" + time +
                ", address='" + address + '\'' +
                ", subject='" + subject + '\'' +
                ", PaperName='" + PaperName + '\'' +
                '}';
    }
}
