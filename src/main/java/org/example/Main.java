package org.example;

import java.util.Dictionary;
import java.util.Random;
import java.util.Scanner;

public class Main {

    static Scanner in = new Scanner(System.in);
    static Random rnd = new Random();

    public static void main(String[] args) {

        System.out.print("Введите размер массива: ");
        int size = in.nextInt();
        String mass [][] = new String[size][size];

        for(int i = 0; i<size; i++){
            for(int j=0; j<size; j++){
                mass[i][j] = rnd.nextInt(2) == 1 ? Integer.toString(rnd.nextInt(10)) : "*";
                System.out.print(mass[i][j] + "\t");
            }
            System.out.println();
        }

        try {
            try {
                System.out.println("Результат: " + Ex1_2_3(mass));
            }
            catch (MyArraySizeException exception){
                exception.printStackTrace();
            }
        }
        catch (MyArrayDataException exception){
            exception.printStackTrace();
        }
    }

    public static int Ex1_2_3(String mass [][]) throws MyArraySizeException, MyArrayDataException{

        int sum = 0;
        if (mass.length != 4) {
            throw new MyArraySizeException();
        }

        for (int i = 0; i < mass.length; i++){
            for (int j = 0; j < mass[i].length; j++){
                try{
                    sum += Integer.parseInt(mass[i][j]);
                }
                catch (NumberFormatException exception){
                    throw new MyArrayDataException(i, j);
                }
                finally {
                    continue;
                }
            }
        }
        return sum;
    }


    private static class MyArraySizeException extends Throwable {
        MyArraySizeException(){
            System.out.println("Массив ненужного размера! Его считать я не буду! :(");
        }
    }

    private static class MyArrayDataException extends Exception {
        MyArrayDataException(int i, int j){
            System.out.println("Неверный формат в " + (i + 1) + " строке и " + (j + 1) + " столбце!\n" +
                    "Но сумму я всё равно посчитаю :)");
        }
    }
}


