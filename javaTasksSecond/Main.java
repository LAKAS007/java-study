package javaTasksSecond;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        char[][] array = new char[][]{{'a', 'b', 'c', 'd', 'e'}, {'g', 'h', 'i', 'j', 'k', 'l'}, {'m', 'n', 'o', 'p', 'q', 'r'}, {'s', 't', 'u', 'v', 'w', 'x'}};
        //======================================first task===================================
        printArray(array);
        changeArray(array);
        printArray(array);

        System.out.println("==============================================================================");
        //======================================second task===================================

        int[][] ints = insertArray(3, 3);
        printArray(ints);
        mirrorSwitchArray(ints);
        printArray(ints);

    }


    public static int[][] mirrorSwitchArray(int[][] array) {
        int changePlace;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
             if ( i == j || i > 0 && j < i) {
                 continue;
             }
             changePlace = array[i][j];
             array[i][j] = array[j][i];
             array[j][i] = changePlace;
            }
        }
        return array;
    }

    public static void changeArray(char[][] arr) {

        for (int i = 1; i < arr.length - 1; i++) {
            for (int j = 1; j < arr[i].length - 1; j++){
                arr[i][j] = '-';
            }
        }
    }

    public static int[][] insertArray(int lineSize, int elInLineSize) {
        Scanner scanner = new Scanner(System.in);
        int lineCnt = 0;
        int elCnt = 0;

        int[][] newArr = new int[lineSize][elInLineSize];

        for (int i = 0; i < newArr.length; i++) {
            for (int j = 0; j < newArr[i].length; j++) {
                System.out.println("Введите [" + lineCnt +"][" + elCnt + "]элемент массива");
                elCnt++;
                newArr[i][j] = scanner.nextInt();
            }
            lineCnt++;
            elCnt = 0;
        }
        return newArr;
    }

    private static void printArray(char[][] chars) {
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars[i].length; j++) {
                System.out.print(chars[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    private static void printArray(int[][] chars) {
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars[i].length; j++) {
                System.out.print(chars[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}


