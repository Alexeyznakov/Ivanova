package Znakov.Practice5.Practice3;

import Znakov.Practice5.Exceptions.MyStudentException;
import Znakov.Practice5.Practice3.Model.Student;
import Znakov.Practice5.Practice3.Service.StudentService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
         int quantity=0;
         while (true) {
             System.out.println("Кількість студентів");
             try {
                 quantity = sc.nextInt();
                 if(quantity<1){
                     MyStudentException.wrongQuantity();
                 }
                 break;
             }catch (MyStudentException ex){
                 System.out.println(ex.getMessage());
             }catch (InputMismatchException ex){
                 System.out.println("Please enter numbers. Try again");
                 sc.nextLine();
             }
         }
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
            while (true) {
                try {


                    System.out.println("Курс");
                    temp = sc.nextLine();
                    temp = checkInput(temp, sc);
                    byte cours=Byte.valueOf(temp);
                    if(cours<1||cours>5){
                        MyStudentException.wrongCourse();
                    }
                    student.setCourse(cours);
                    break;
                }catch (NumberFormatException ex){
                    System.out.println("Please input numbers. Try again");
                }catch (MyStudentException ex){
                    System.out.println(ex.getMessage());
                }
            }
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
