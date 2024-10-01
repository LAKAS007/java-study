import java.lang.reflect.Array;
import java.net.PasswordAuthentication;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TreeMap;

public class Main {


    public static void main(String[] args) throws Exception {
        // task1
        System.out.println(maxValue(5, 10));

        System.out.println("====================================================================");

        //task2
        System.out.println(devider(10, 2));

        System.out.println("====================================================================");

        //task3
        System.out.println(convertor("123ed"));

        System.out.println("====================================================================");


        //task4
        ageChecker(100);

        System.out.println("====================================================================");

        //task5
        System.out.println(sqt(100));

        System.out.println("====================================================================");

        //task6
        System.out.println(factorial(5));

        System.out.println("====================================================================");

        //task7
        System.out.println(isZerose(new int[]{1, 2, 3, 4, 5, 0}));

        System.out.println("====================================================================");

        //task8
        System.out.println(power(2, 8));

        System.out.println("====================================================================");

        //task9
        System.out.println(stringer("Hello world!", 5));

        System.out.println("====================================================================");

        //task10
        System.out.println(finderInArray(new int[]{1, 2, 3, 4, 5}, 4));

        System.out.println("====================================================================");

        //task11
        System.out.println(convertirToBin(10));

        System.out.println("====================================================================");

        //task12
        System.out.println(isDeviding(10, 2));

        System.out.println("====================================================================");

        //task13
        System.out.println(returnElementByIndex(new int[] {1, 2 ,3 ,4, 5}, 3));

        System.out.println("====================================================================");

        //task14
        System.out.println(passwordChecker("qwerty12345"));

        System.out.println("====================================================================");

        //task15
        System.out.println(isDateCorrect("10.01.2020"));

        System.out.println("====================================================================");

        //task16
        System.out.println(concatString("Hello ", "World!"));

        System.out.println("====================================================================");

        //task17
        System.out.println(returnDevide(111, 10));

        System.out.println("====================================================================");

        //task18
        System.out.println(sqrttt(25));

        System.out.println("====================================================================");

        //task19
        System.out.println(convertTemperature(27));

        System.out.println("====================================================================");

        //task20
        System.out.println(isStringEmpty("not empty"));
    }

    public static int maxValue(int x, int y) {
        if (x > y){
            return x;
        } else if (y > x){
            return y;
        } else {
            System.out.println("Оба числа одинаковые");
            return x;
        }
    }


    public static double devider(double x, double y) {
        if (x == 0 || y == 0) {
            System.out.println("Нельзя делить на 0");
            return 0;
        }
        else {
            return x / y;
        }
    }


    public static int convertor(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException s) {
            System.out.println("Строка не может быть преобразована в число");
            return 0;
        }
    }


    public static void ageChecker(int age) {
        if (age >= 0 && age <= 150) {
            System.out.println("Вам " + age + " лет.");
        }
        else {
            throw new  IllegalArgumentException("Неверно указан возраст");
        }
    }

    public static double sqt(int x) {
        if (x < 0) {
            throw new IllegalArgumentException("Чило не может быть отрецательным");
        } else {
            return Math.sqrt(x);
        }
    }

    public static int factorial(int x) throws Exception {
        if(x < 0) {
            throw new Exception("Число не может бвть отрицательным");
        }
        else if (x == 1 || x == 0) {
            return 1;
        }
        else {
            return x * factorial(x - 1);
        }
    }


    public static String isZerose(int[] array) throws Exception {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                throw new Exception("В массиве обнаружен 0");
            }
        }
        return "В массиве нет 0";
    }

    public static int power(int number, int power) throws Exception {
        if (power < 0) {
            throw new Exception("Степень не может быть отрицательной");
        }
        for (int i = 0; i < power; i++) {
            number *= number;
        }
        return number;
    }

    public static String stringer(String s, int cnt) throws Exception {
        if (cnt > s.length()) {
            throw new Exception("Счетчик не может быть больше длины строки");
        }
        return s.substring(0, cnt);
    }

    public static int finderInArray(int[] array, int goal) throws Exception {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == goal) {
                return array[i];
            }
        }
        throw new Exception("В массиве нет нужного жлемента");
    }

    public static String convertirToBin(int x) throws Exception {
        if (x < 0) {
            throw new Exception("Число отрицательное");
        }
        return Integer.toBinaryString(x);
    }

    public static boolean isDeviding(int number, int devider) {
        if (devider == 0) {
            throw new ArithmeticException("Нельзя делить на 0");
        }
        return number % devider == 0;
    }

    public static int returnElementByIndex(int[] array, int index) {
        if (index > array.length) {
            throw new IndexOutOfBoundsException("Индекс выходит за перделы массива");
        }
        return array[index];
    }

    public static String passwordChecker(String password) throws Exception {
        if (password.length() < 8) {
            throw new Exception("Не надежный пароль");
        }
        return "Пароль надежный";
    }


    public static String isDateCorrect(String date) {
        LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        return "Все ок";
    }

    public static String concatString(String fString, String sString) {
        if (fString == null || sString == null) {
            throw new NullPointerException("Строка не может быть null");
        }
        return fString + sString;
    }

    public static int returnDevide(int x, int y) throws Exception {
        if (y == 0) {
            throw new Exception("Делитель не может равняться 0");
        }
        return x % y;
    }

    public static double sqrttt(int x) throws Exception {
        if (x < 0) {
            throw new Exception("Число не может быть отрицательным");
        }
        return Math.sqrt(x);
    }

    public static double convertTemperature(double temp) {
        if (temp < 273.15) {
            throw new IllegalArgumentException("Температура меньше абсолютного 0");
        }
        return temp * 1.8 + 32;
    }

    public static boolean isStringEmpty(String s) throws Exception {
        if (s.isEmpty() || s == null) {
            throw new Exception("Строка пустая");
        }
        return true;
    }



}