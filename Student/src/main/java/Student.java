import java.util.ArrayList;

public class Student {
    public String id;
    public String name;
    public String sex;
    public String birthdate;
    public String email;
    public String note;
    public Student(String id, String name, String sex, String birthdate, String email, String note) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.birthdate = birthdate;
        this.email = email;
        this.note = note;
    }

    public Student() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
