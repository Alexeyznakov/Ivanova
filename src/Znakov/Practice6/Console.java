package Znakov.Practice6;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Scanner;

public class Console {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (true)

        {
            System.out.println("Please file path ");
            String fileName = scanner.nextLine();
            fileName = checkInput(fileName, scanner);
            try {
                BufferedReader bufferedReader=new BufferedReader(new FileReader(fileName));

                StringBuilder sb=new StringBuilder();

                String temp;
                while ((temp=bufferedReader.readLine())!=null){
                    sb.append(temp).append("\n");
                }

                System.out.println("Please text what i will replace");
                String text=scanner.nextLine();
                text=checkInput(text,scanner);


                System.out.println("Please text what i will place");
                String textForChange=scanner.nextLine();
                textForChange=checkInput(textForChange,scanner);
                if(!sb.toString().contains(text)){
                    System.out.println("No substring.");
                    return;
                }
                String poesion=sb.toString();
                poesion=poesion.replace(text,textForChange);

                FileOutputStream fos=new FileOutputStream(fileName);
                fos.write(poesion.getBytes(Charset.defaultCharset()));
                fos.flush();
                fos.close();
                break;

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
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
