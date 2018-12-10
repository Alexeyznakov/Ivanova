package Znakov.Practice5.Practice3.Model;

import java.util.ArrayList;
import java.util.List;

/*Цей клас - це об'єктно-орієнтоване уявлення про Студента. Логіки ніякої в ньому немає.
 * Це звичайне POJO для збереження і зберігання інформації. В цьому класі також присутній
 * вкладений класс Залікова книга. Я прийняв рішення зробити залікову книгу вкладеним класом,
 * бо вона не може існувати без студента.*/
public class Student {

    private String surname;
    private String name;
    private String middleName;
    private byte course;
    private ExamineBook examineBook;
    private String country;
    private String sex;

    public Student() {
        examineBook=new ExamineBook();
    }


    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public byte getCourse() {
        return course;
    }

    public void setCourse(byte course) {
        this.course = course;
    }

    public ExamineBook getExamineBook() {
        return examineBook;
    }


    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        sb.append("Студент ["+examineBook.number).append("] - ").append(surname).append(" ")
                .append(name).append(" ").append(middleName).append(". Курс - ").append(course).append(". ")
                .append("Країна - ").append(country).append(". Стать - ").append(sex).append(". ")
                .append(examineBook);
        return sb.toString();
    }

    public class ExamineBook {

        private String number;
        private List<Subject> examines;
        private double averageMark;

        public ExamineBook() {

            examines=new ArrayList<>();
        }





        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public List<Subject> getExamines() {
            return examines;
        }

        public void addExamine(String examine)
        {
            String [] args=examine.split("-");
            this.examines.add(new Subject(args[0],Integer.valueOf(args[1])));
        }

        public void calculateAverageMark()
        {
        if(examines.size()==0){
            return;
        }
        else {
            double val=0;
            for (Subject examine : examines) {
                val+=examine.getMark();
            }
            examineBook.averageMark=val/examines.size();

        }
        }

        @Override
        public String toString() {
            StringBuilder s=new StringBuilder();
            s.append("{Екзамени - ").append(examines).append(" ; ").append("Середня оцінка - ")
                    .append(averageMark).append("}");

            return s.toString();
        }
    }
}
