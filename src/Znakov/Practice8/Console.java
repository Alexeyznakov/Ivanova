package Znakov.Practice8;

import java.util.*;

public class Console {

    private static List<Integer> numbers=new ArrayList<>();
    private static List<Integer> part1;
    private static List<Integer> part2;


    public static void main(String[] args) {
        populate();
        System.out.println(numbers);
        while (console());


    }

    private static boolean console(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Please choose place to set 0 and divide this list(2 - ...)");
        String temp=scanner.nextLine();
        temp=checkInput(temp,scanner);

        try{
             divideAndSort(Integer.valueOf(temp));
            System.out.println("First list");
            System.out.println(part1);
            System.out.println();
            System.out.println("Second List");
            System.out.println(part2);
            return false;
        }catch (NumberFormatException ex){
            System.out.println("Please input number. Try Again");
        }
        catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
        return true;

    }

    private static void divideAndSort(int pos) throws IllegalArgumentException{
        if(pos<2||pos>numbers.size()-1){
            throw new IllegalArgumentException("Wrong position");
        }
        part1= numbers.subList(0,pos-1);
        part2=numbers.subList(pos-1,numbers.size());
        part1.sort(Comparator.reverseOrder());
        part2.sort(Comparator.reverseOrder());

    }



    private static void populate(){
        Random random=new Random();
        for(int i=0;i<20;i++){
            numbers.add(random.nextInt(50)+1);
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
