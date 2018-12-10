package Znakov.Practice3;

import Znakov.Practice3.Model.Student;
import Znakov.Practice3.Service.StudentService;

import java.util.Scanner;

public class Input {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);


        System.out.println("Кількість студентів");
        int quantity=sc.nextInt();
        Student[] students=new Student[quantity];
        for(int i=0;i<quantity;i++){
            String temp;
            Student student=new Student();
            System.out.println("Номер");
            temp=sc.nextLine();
            student.getExamineBook().setNumber(checkInput(temp,sc));
            System.out.println("Ім'я");
            temp=sc.nextLine();
            student.setName(checkInput(temp,sc));
            System.out.println("Прізвище");
            temp=sc.nextLine();
            student.setSurname(checkInput(temp,sc));
            System.out.println("По-батькові");
            temp=sc.nextLine();
            student.setMiddleName(checkInput(temp,sc));
            System.out.println("Курс");
            temp=sc.nextLine();
            student.setCourse(Byte.valueOf(checkInput(temp,sc)));
            System.out.println("Стать");
            temp=sc.nextLine();
            student.setSex(checkInput(temp,sc));
            System.out.println("Країна");
            temp=sc.nextLine();
            student.setCountry(checkInput(temp,sc));

            System.out.println("Екзамени(формат: архітектура-95 )(для завершення вводу введіть \"кінець\" )");
            while (true){
                String ex=sc.nextLine();
                ex=checkInput(ex,sc);
                if(ex.equalsIgnoreCase("кінець")){
                    break;
                }
                student.getExamineBook().addExamine(ex);

            }
            student.getExamineBook().calculateAverageMark();

            students[i]=student;

        }
        StudentService.listOfGood(students,2);
        System.out.println();
        StudentService.listOfGoodInInternationalStudents(students);



    }

    private static String checkInput(String text, Scanner sc){
        if(text.equalsIgnoreCase("")){
            text=sc.nextLine();
            return checkInput(text,sc);

        }
        return text;
    }
}
