package domain;

public class bank {
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

    private String result;

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

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    //选择题
    public String toString1() {
        return "bank{" +
                "题号=" + id + "\t" +
                ", 科目=" + subject + "\t" +
                ", 题型=" + type + "\t" +
                ", 题目:" + title + "\t" +
                ", A." + choiceA + "\t" +
                ", B." + choiceB + "\t" +
                ", C." + choiceC + "\t" +
                ", D." + choiceD + "\t" +
                " 难度=" + difficulty + "\t" +
                " 答案=" + result + "\t" +
                '}';
    }

    //填空题
    public String toString2() {
        return "bank{" +
                "题号=" + id + "\t" +
                "科目='" + subject + "\t" +
                "题型='" + type  + "\t" +
                "题目='" + title + "\t" +
                tk  + "\t" +
                " 难度=" + difficulty + "\t" +
                " 答案=" + result + "\t" +
                '}';
    }

}
