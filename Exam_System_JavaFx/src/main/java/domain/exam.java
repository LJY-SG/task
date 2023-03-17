package domain;

import java.util.Date;

public class exam {
    private Date time;

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

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
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
