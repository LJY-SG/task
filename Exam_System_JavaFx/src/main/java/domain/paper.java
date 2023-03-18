package domain;

public class paper {
    private int id;

    private String subject;

    private String type;

    private String title;

    private String tk;

    private String choiceA;

    private String choiceB;

    private String choiceC;

    private String choiceD;

    private String difficulty;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTk() {
        return tk;
    }

    public void setTk(String tk) {
        this.tk = tk;
    }

    public String getChoiceA() {
        return choiceA;
    }

    public void setChoiceA(String choiceA) {
        this.choiceA = choiceA;
    }

    public String getChoiceB() {
        return choiceB;
    }

    public void setChoiceB(String choiceB) {
        this.choiceB = choiceB;
    }

    public String getChoiceC() {
        return choiceC;
    }

    public void setChoiceC(String choiceC) {
        this.choiceC = choiceC;
    }

    public String getChoiceD() {
        return choiceD;
    }

    public void setChoiceD(String choiceD) {
        this.choiceD = choiceD;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }


    //选择题输出形式
    public String toString1() {
        return
                type  + "\n" +
                id +
                ". " + title + "\n"+
                "A." + choiceA  + "  " +
                "B." + choiceB  + "  " +
                "C." + choiceC  + "  " +
                "D." + choiceD  + "\t\t"+
                " 难度:" + difficulty  + "\n";
    }

    
    //填空题输出形式
    public String toString2() {
        return
                type + "\n" +
                id +
                ". " + title +
                " " + tk + "\t\t" +
                " 难度:" + difficulty + "\n" ;
    }
}
