package javaEnumSingleton;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //task 1
        DataBase db = DataBase.getDB();
        db.connect();
        //////////////////////////////

        //task 2
        LogSys ls = LogSys.getLogSys();
        ls.scannLog();
        ls.scannLog();
        ls.scannLog();
        ls.getLogs();
        /////////////////////////////

        //task 3
        Order ord = new Order("first order");
        ord.changeStatus(OrderStatus.IN_PROGRESS);
        System.out.println(ord.getInfo() + " " + ord.getStasus());
        /////////////////////////////

        //task 4
        Season.WINTER.printString();
        Season.SPRING.printString();
        Season.SUMMER.printString();
        Season.AUTUMN.printString();


    }
}



//task 1
class DataBase {
    public static DataBase db;

    private DataBase() {
    }

    public static DataBase getDB() {
        if (db == null) {
            db = new DataBase();
        }
        return db;
    }

    public void connect() {
        System.out.println("Подключение...");
        System.out.println("База данных подключена");
    }
}
////////////////////////

//task 2

class LogSys {
    private static LogSys instance;
    private ArrayList<String> logs = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    private LogSys() {}
    public static LogSys getLogSys() {
        if (instance == null) {
            instance = new LogSys();
        }
        return instance;
    }

    public void scannLog() {
        this.logs.add(scanner.nextLine().toString());
    }

    public void getLogs() {
        System.out.println(logs);
    }
}
//////////////////////////////////

//task 3

enum OrderStatus {
    NEW,
    IN_PROGRESS,
    DELIVERED,
    CANCELLED
}
class Order {
    private String info;
    private OrderStatus stasus;

    public void changeStatus(OrderStatus newStatus) {
        this.stasus = newStatus;
    }
    public Order(String info) {
        this.info = info;
        this.stasus = OrderStatus.NEW;
    }

    public String getInfo() {
        return info;
    }

    public OrderStatus getStasus() {
        return stasus;
    }
}
/////////////////////////////////

//task 4

enum Season {
    WINTER("Зима"),
    SPRING("Весна"),
    SUMMER("Лето"),
    AUTUMN("Осень");

    private final String seas;
    Season(String seas) {
        this.seas = seas;
    }

    public void printString() {
        System.out.println(seas);
    }
}
