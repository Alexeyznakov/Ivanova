package Znakov.Practice5.Practice3.Model;
/*Цей клас - це об'єктно-орієнтоване уявлення про Екзамен. Логіки ніякої в ньому немає.
 * Це звичайне POJO для збереження і зберігання інформації*/
public class Subject {
    private String subject;
    private int mark;

    public Subject(String subject,int mark) {
        this.subject = subject;
        this.mark=mark;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return subject+"-"+mark;
    }
}
