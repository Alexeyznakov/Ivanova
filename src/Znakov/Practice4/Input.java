package Znakov.Practice4;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Input {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Director director=new Director();
        director.addMusician(new Musician("Oleksiy Znakov",new BigDecimal(1000)));
        director.addMusician(new Musician("Igor",new BigDecimal(800)));
        director.addMusician(new Musician("Dima Balackiy",new BigDecimal(1100)));
        director.addMusician(new Musician("Anton Danilishin",new BigDecimal(1100)));
        Conductor conductor=new Conductor();
        conductor.setName("Test");
        conductor.addSong("Requim for a dream - Mozart");
        conductor.addSong("Four Season - Vivaldi");
        conductor.addSong("Piano Sonata No.14 - Beethoven");
        conductor.addSong("Moon Sonata  - Beethoven");
        director.setConductor(conductor);
         while (true) {
             System.out.println("\u001B[37m1 - Забронювати дату для концерту\n2 - Зіграти концер\n3 - Взяти на роботу музиканта");
             String temp = scanner.nextLine();
             temp = checkInput(temp, scanner);
             switch (temp){
                 case "1":{
                     System.out.println("Введіть дату (формат - 31.05.1999)");
                     director.placeConcert(readData(scanner));
                     break;
                 }
                 case "2":{
                     System.out.println("Введіть дату (формат - 31.05.1999)");
                     director.playConcert(readData(scanner));
                     break;
                 }
                 case "3":{
                     System.out.println("Введіть ім'я");
                     String name=scanner.nextLine();
                     name=checkInput(name,scanner);
                     System.out.println("Enter salary (for example 10.20)");
                     String salary=scanner.nextLine();
                     salary=checkInput(salary,scanner);
                     director.addMusician(new Musician(name,new BigDecimal(Double.valueOf(salary))));
                     break;
                 }
             }
         }


    }
    private static Date readData(Scanner scanner){

        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        String s=scanner.nextLine();
        s=checkInput(s,scanner);
        try {
            return df.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
    private static String checkInput(String text, Scanner sc){
        if(text.equalsIgnoreCase("")){
            text=sc.nextLine();
            return checkInput(text,sc);

        }
        return text;
    }
}
