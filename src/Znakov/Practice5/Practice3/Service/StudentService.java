package Znakov.Practice5.Practice3.Service;

import Znakov.Practice5.Practice3.Model.Student;
import Znakov.Practice5.Practice3.Model.Subject;

/*Цей клас відповідає за логіку обробки інформації(Завдання з практичної).*/
public class StudentService {
    public static  void listOfGood(Student[] students, int course){
        boolean b=true;
        for (Student student : students) {
            if(student.getCourse()!=course){
                continue;
            }
            boolean check=true;
            for (Subject subject : student.getExamineBook().getExamines()) {
                if(subject.getMark()<90){
                    check=false;
                    break;
                }
            }
            if(check){
                System.out.println(student);
                b=false;
            }

        }
        if(b){
            System.out.println("Немає відмінників на "+course+"-му курсі");
        }

    }
    public static  void listOfGoodInInternationalStudents(Student[] students){
        boolean b=true;
        for (Student student : students) {
            if(student.getCountry().equalsIgnoreCase("Україна")){
                continue;
            }
            boolean check=true;
            for (Subject subject : student.getExamineBook().getExamines()) {
                if(subject.getMark()<75){
                    check=false;
                    break;
                }
            }
            if(check){
                System.out.println(student);
                b=false;
            }

        }
        if(b){
            System.out.println("Немає хороших іноземніх студентів");
        }

    }
}
