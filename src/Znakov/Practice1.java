package Znakov;

import java.util.Scanner;

public class Practice1 {
    public static void main(String[] args) {
        System.out.println("Олексій Насадчук");
        System.out.println();
        int k=3;
        short[][] matrix=new short[5][5];
        fillMatrix(matrix);
        printMatrix(matrix);
        System.out.println();
        Scanner scanner=new Scanner(System.in);
        System.out.println("Please select column: ");

        k=scanner.nextInt();
        System.out.println();
        orderMatrix(matrix,k-1);
        System.out.println("Result");
        printMatrix(matrix);
    }
    // Цей метод виводить матрицю
    private static void printMatrix(short[][] matrix){
        for(int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[i].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
    // Цей метод заповнюэ матрицю за допомогою Math.random()
    private static void fillMatrix(short[][] matrix){

        for(int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[i].length;j++){
                matrix[i][j]=(short) (Math.random()*10);
            }
        }
    }
    /*Це метод сортування матрицю по рядку за допомогою сортування "Пузырьком".
      Якщо я знаходжу, що елементи не на своєму місці, то я викликаю метод
      changeColumns, який змінює 2 стовпці місцями(просто по-черзі переставляє
      елменти місцями)*/
    private static void orderMatrix(short[][] matrix,int k){
        boolean check=true;
        int row=0;
        while (check){
            check=false;
            for(int i=row;i<matrix.length-1;i++){
                if(matrix[k][i]>matrix[k][i+1]){
                    changeColumns(i,i+1,matrix);
                    check=true;
                }
            }
        }
    }
    /*Метод переставляє стовпці місцями через простий цикл*/
    private static void changeColumns(int column1,int column2,short[][] matrix){
        short temp=0;
        for(int i=0;i<matrix.length;i++){
            temp=matrix[i][column1];
            matrix[i][column1]=matrix[i][column2];
            matrix[i][column2]=temp;

        }
    }
}
