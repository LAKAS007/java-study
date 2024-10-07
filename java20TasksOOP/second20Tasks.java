package java20TasksOOP;

import java.util.*;

public class second20Tasks {
    public static void main(String[] args) {

        //task 1
//        Person person1 = new Person("Alex", 22, "Male");
//        person1.getInfo();
//        person1.addAge(11);
//        person1.setName("Kalin");
//        person1.getInfo();

        ////////////////////////////////////////////////////////////////////////////////////////////

        //task 3
//        Dog dog = new Dog();
//        Cat cat = new Cat();
//        Cow cow = new Cow();
//
//        dog.makeSound();
//        cat.makeSound();
//        cow.makeSound();

        ///////////////////////////////////////////////////////////////////////////////////////


        //test

//        Point p1 = new Point(10, 10);
//        Point p2 = new Point(5, 7);
//
//        Rect rect = new Rect(p1, p2);
//        System.out.println(rect.solveSquare());

        //task 17
//        Scanner scanner = new Scanner(System.in);
//
//        Weapon AK = new Weapon(15);
//        Weapon AR = new Weapon(11);
//        Weapon Glock = new Weapon(7);
//
//        Enemy jack = new Enemy(75, Glock);
//        Enemy boss = new Enemy(125, AR);
//
//        Player player = new Player(100, AK);
//
//        while (player.isAlive() || jack.isAlive() && boss.isAlive()) {
//            if (jack.isAlive()) {
//                jack.shoot(player, 1);
//                System.out.println("Сколько раз выстрелить:");
//                int dam = scanner.nextInt();
//                player.shoot(jack, dam);
//            }
//            else {
//                boss.shoot(player, 1);
//                System.out.println("Сколько раз выстрелить:");
//                int dam = scanner.nextInt();
//                player.shoot(boss, dam);
//            }
//        }

//task 20

        PlayerXO p1 = new PlayerXO("x");
        PlayerXO p2 = new PlayerXO("0");

        Game game = new Game();

        int iter = 0;

        Game.Start();
        while (Game.isWinner()) {
            if (iter % 2 == 0){
                Game.putSign(p1);
            } else if (iter % 2 == 1) {
                Game.putSign(p2);
            }
            Game.showField();
            iter++;
        }

    }
}
//task 1
class Person {
    private String name;
    private int age;
    private String gender;

    public Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public void getInfo() {
        System.out.println("Имя: " + this.name + " Возрвст" + this.age + " Пол: " + this.gender);
    }

    public void addAge(int changeAge) {
        this.age += changeAge;
    }

    public void setName(String name) {
        this.name = name;
    }
}

///////////////////////////////////////////////////////////

//task 2
class Worker extends Person{
    private int salary;
    public Worker(String name, int age, String gender, int salary) {
        super(name, age, gender);
        this.salary = salary;
    }
}

class Manager extends Worker {
    private List<Person> listPerson;
    public Manager(String name, int age, String gender, int salary) {
        super(name, age, gender, salary);
    }
}

///////////////////////////////////////////////////////////

//task 3
interface Animal {
    void makeSound();
}
class Dog implements Animal {
    private final String SOUND = "Gaw";
    @Override
    public void makeSound() {
        System.out.println(this.SOUND);
    }
}
class Cat implements Animal {
    private final String SOUND = "May";
    @Override
    public void makeSound() {
        System.out.println(this.SOUND);
    }
}
class Cow implements Animal {
    private final String SOUND = "My";
    @Override
    public void makeSound() {
        System.out.println(this.SOUND);
    }
}

////////////////////////////////////////////////////////////

//task 4

abstract class Transport {
    public abstract void move();
}

class Car extends Transport {
    @Override
    public void move() {
        System.out.println("Машина поехала");
    }
}

class Bike extends Transport {
    @Override
    public void move() {
        System.out.println("Мотоцикл поехал");
    }
}

////////////////////////////////////////////////////////////////

//task 5

class Book {
    private String title;
    private String author;
    private int year;

    public void gerInfo() {
        System.out.println(this.title + " " + this.author + " " + this.year);
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }
}
class Library {
    private List<Book> lib;
    public void addBook(Book book) {
        lib.add(book);
        System.out.println("Книга добавлена в библиотеку!");
    }

    public void findByTitle(String bookName) {
        for (Book book : lib) {
            if (book.getTitle() == bookName) {
                book.gerInfo();
            }
        }
    }

    public void findByAuthor(String bookAuthor) {
        for (Book book : lib) {
            if (book.getAuthor() == bookAuthor) {
                book.gerInfo();
            }
        }
    }

    public void findByYear(int bookYear) {
        for (Book book : lib) {
            if (book.getYear() == bookYear) {
                book.gerInfo();
            }
        }
    }
}

/////////////////////////////////////////////////////////////////

//task 6

class BankAccount {
    private static int accountID = 0;
    private int accoutnNumber;
    private double balance;

    public BankAccount() {
        accountID++;
        accoutnNumber = accountID;
    }

    public int getAccoutnNumber() {
        return accoutnNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void inMoney(double money) {
        this.balance += money;
        System.out.println("На вашем балансе: " + this.balance);
    }

    public void outMoney(double money) {
        this.balance -= money;
        System.out.println("На вашем балансе: " + this.balance);
    }

}

//////////////////////////////////////////////////////////////////

//task 7
class Counter {
    private static int cnt = 0;

    public Counter() {
        cnt++;
    }
}

//////////////////////////////////////////////////////////////////

//task 8

abstract class Shape {
    abstract void getArea();
}
class Circle extends Shape {

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    void getArea() {
        System.out.println(Math.PI * Math.pow(this.radius, 2));
    }
}
class Rectangle extends Shape {

    private int x;
    private int y;

    public Rectangle(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    void getArea() {
        System.out.println(this.x * this.y);
    }
}

///////////////////////////////////////////////////////////////////

//task 9

class NewAnimal {
    public void move() {

    }
}

class Fish extends NewAnimal {
    @Override
    public void move() {
        System.out.println("Рыба плавает");
    }
}

class NewDog extends NewAnimal {
    @Override
    public void move() {
        System.out.println("Собака бегает");
    }
}

class Bird extends NewAnimal {
    @Override
    public void move() {
        System.out.println("Птица летает");
    }
}

////////////////////////////////////////////////////////////////////

//task 10

class Student {
    private String name;
    private String group;
    private int garde;

    public Student(String name, String group, int garde) {
        this.name = name;
        this.group = group;
        this.garde = garde;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public int getGarde() {
        return garde;
    }

    public void setGarde(int garde) {
        this.garde = garde;
    }
}

class University {
    private List<Student> stList;

    public void addStudent(Student student) {
        stList.add(student);
        System.out.println("Студент добавлен");
    }
}

///////////////////////////////////////////////////////////////////////

//task 11

class Product {
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void getInfo() {
        System.out.println("Name: " + this.name + "Price: " + this.price + "Quantity: " + this.quantity);
    }
}

class Store {
    private LinkedList<Product> storeCatalogue;

    public void addProduct(Product product) {
        storeCatalogue.add(product);
        System.out.println("Продукт добавлен!");
    }

    public void deleteProduct(String productName) {
        for (int i = 0; i < storeCatalogue.size(); i++) {
            if (storeCatalogue.get(i).getName().equals(productName)) {
                storeCatalogue.remove(i);
            }
        }
        System.out.println("Продукт " + productName + " удален из каталога.");
    }

    public void findByName(String productName) {
        for (int i = 0; i < storeCatalogue.size(); i++) {
            if (storeCatalogue.get(i).getName().equals(productName)) {
                storeCatalogue.get(i).getInfo();
            }
        }
    }

}

///////////////////////////////////////////////////////////////////////

//task 12

interface PaymentSystem {
    void pay(double payment);
    void refund(double payment);
}
class CreditCard implements PaymentSystem {
    private double money;
    @Override
    public void pay(double payment) {
        this.money -= payment;
        System.out.println("Платеж прошел, на вашем счету: " + this.money);
    }

    @Override
    public void refund(double payment) {
        this.money += payment;
        System.out.println("Возврат прошел, на вашем счету: " + this.money);
    }
}
class PayPal implements PaymentSystem {
    private double money;
    @Override
    public void pay(double payment) {
        this.money -= payment;
        System.out.println("Платеж прошел, на вашем счету: " + this.money);
    }

    @Override
    public void refund(double payment) {
        this.money += payment;
        System.out.println("Возврат прошел, на вашем счету: " + this.money);
    }
}

///////////////////////////////////////////////////////////////////////

//task 13

class UniqueID {
    private static int staticID;
    public static int makeUniqueID() {
        staticID = (int) Math.random();
        return staticID;
    }
}

///////////////////////////////////////////////////////////////////////

//task 14

class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
class Rect {
    private Point leftUpPoint;
    private Point rightDownPoint;

    public Rect(Point leftUpPoint, Point rightDownPoint) {
        this.leftUpPoint = leftUpPoint;
        this.rightDownPoint = rightDownPoint;
    }

    public Point getLeftUpPoint() {
        return leftUpPoint;
    }

    public void setLeftUpPoint(Point leftUpPoint) {
        this.leftUpPoint = leftUpPoint;
    }

    public Point getRightDownPoint() {
        return rightDownPoint;
    }

    public void setRightDownPoint(Point rightDownPoint) {
        this.rightDownPoint = rightDownPoint;
    }

    public int solveSquare() {
        return Math.abs((Math.abs(this.rightDownPoint.getX())  - Math.abs(this.leftUpPoint.getX())) * (Math.abs(this.leftUpPoint.getY())  - Math.abs(this.rightDownPoint.getY())));
    }
}

///////////////////////////////////////////////////////////////////////

//task 15

//task 16

class Matrix {
    private int[][] matrixx;

    public Matrix(int[][] matrixx) {
        this.matrixx = matrixx;
    }

    public int[][] getMatrixx() {
        return matrixx;
    }

    public static int sumMatrix(Matrix... matric) {
        int cnt = 0;

        for (int i = 0; i < matric.length; i++) {
            for (int j = 0; j < matric[i].matrixx.length; j++) {
                cnt += Arrays.stream(matric[i].matrixx[j]).sum();
            }
        }
        return cnt;
    }

    public static int multiMatrix(Matrix... matric) {
        int multiCnt = 1;

        for (int i = 0; i < matric.length; i++) {
            for (int j = 0; j < matric[i].matrixx.length; j++) {
                multiCnt *= Arrays.stream(matric[i].matrixx[j]).sum();
            }
        }
        return multiCnt;
    }
}

///////////////////////////////////////////////////////////////////////

//task 17

class Player {
    private int hp;
    private Weapon activeWeapon;

    private boolean isAlive = true;

    public Player(int hp, Weapon activeWeapon) {
        this.hp = hp;
        this.activeWeapon = activeWeapon;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public Weapon getActiveWeapon() {
        return activeWeapon;
    }

    public void setActiveWeapon(Weapon activeWeapon) {
        this.activeWeapon = activeWeapon;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public void shoot(Enemy enemy, int shoots) {
        int actualEnemyHP = enemy.getHp();
        int actualDamage = shoots * this.activeWeapon.getDamage();
        enemy.setHp(actualEnemyHP - actualDamage);
    }

    public void isAliving() {
        if (this.hp <= 0) {
            this.isAlive = false;
        }
    }

}

class Enemy {
    private int hp;
    private Weapon activeWeapon;
    private boolean isAlive = true;

    public Enemy(int hp, Weapon activeWeapon) {
        this.hp = hp;
        this.activeWeapon = activeWeapon;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public Weapon getActiveWeapon() {
        return activeWeapon;
    }

    public void setActiveWeapon(Weapon activeWeapon) {
        this.activeWeapon = activeWeapon;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public void shoot(Player player, int shoots) {
        int actualEnemyHP = player.getHp();
        int actualDamage = shoots * this.activeWeapon.getDamage();
        player.setHp(actualEnemyHP - actualDamage);
    }

    public void isAliving() {
        if (this.hp <= 0) {
            this.isAlive = false;
        }
    }
}

class Weapon {
    private int damage;

    public Weapon(int damage) {
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }
}

////////////////////////////////////////////////////////////////////////

//task 18

class Order {
    private List<Productt> orderList = new ArrayList<>();
    private int totalPrice;


    public void addToOrder(Productt productt) {
        orderList.add(productt);
        calcTotPrice();
        System.out.println("Продукт добавлен в заказ");
    }

    private void calcTotPrice() {
        for (Productt productt : orderList) {
            totalPrice += productt.getPrice();
        }
    }
    public void getInfo() {
        for (Productt productt : orderList) {
            productt.print();
        }
    }
}

class Customer {
    private List<Order> orderHistory;

    public void getOrderHistory() {
        for (Order order : orderHistory) {
            order.getInfo();
        }
    }
}

class Productt {
    private String name;
    private int price;

    public Productt(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public void print() {
        System.out.println("Название: " + this.name + "\nЦена за шт: " + this.price + "\n");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

/////////////////////////////////////////////////////////////////////////

//task 19

abstract class Device {
    private String brand;

    abstract void turnOn();
    abstract void turnOff();
}
class SmartPhone extends Device {

    @Override
    public void turnOn() {
        System.out.println("TurnOn");
    }

    @Override
    public void turnOff() {
        System.out.println("TurnOff");
    }

    public void takePhoto() {
        System.out.println("Take Photo");
    }
}
class LapTop extends Device {

    @Override
    public void turnOn() {
        System.out.println("TurnOff");
    }

    @Override
    public void turnOff() {
        System.out.println("Take Photo");
    }

    public void openLapTop() {
        System.out.println("LapTop open");
    }
}

//////////////////////////////////////////////////////////////////////////

//task 20

//  X | X | X
// ___|___|___
//    |   |
//  X | X | X
// ___|___|___
//    |   |
//  X | X | X

class Game {
    private static String[][] field;
    private static Scanner scanner = new Scanner(System.in);

    public static void Start() {
        System.out.println("  |   |  " + "\n___|___|___" + "\n   |   |   " + "\n   |   |  " + "\n___|___|___" + "\n   |   |   " + "\n   |   |  ");
        field = new String[][]{
                {"", "", ""},
                {"", "", ""},
                {"", "", ""}
        };
    }

    public static void putSign(PlayerXO playerXO) {
        System.out.println("Введите поле, в которые вы хоите поставить " + playerXO.getSign());
        System.out.println(" 0, 0 | 0, 1  | 0, 2 " + "\n___|___|___" + "\n   |   |   " + "\n  1, 0 | 1, 1  | 1, 2 " + "\n___|___|___" + "\n  2, 0 | 2, 1  | 2, 2  " + "\n   |   |  ");
        System.out.println("Введите номер ряда: ");
        int x = scanner.nextInt();
        System.out.println("Введите номер стобика: ");
        int y = scanner.nextInt();

        if (field[x][y].isEmpty())
            field[x][y] = playerXO.getSign();
        else {
            System.out.println("Это поле уже занято");
        }
    }

    public static boolean isWinner() {
        if (field[0][0].equals(field[0][1]) && field[0][1].equals(field[0][2])) {
            System.out.println("Победили " + field[0][0]);
            return true;
        }

        if (field[1][0].equals(field[1][1]) && field[1][1].equals(field[1][2])) {
            System.out.println("Победили " + field[1][0]);
            return true;
        }

        if (field[2][0].equals(field[2][1]) && field[2][1].equals(field[2][2])) {
            System.out.println("Победили " + field[2][0]);
            return true;
        }

        if (field[0][0].equals(field[1][0]) && field[1][0].equals(field[2][0])) {
            System.out.println("Победили " + field[0][0]);
            return true;
        }

        if (field[0][1].equals(field[1][1]) && field[1][1].equals(field[2][1])) {
            System.out.println("Победили " + field[1][0]);
            return true;
        }

        if (field[0][2].equals(field[1][2]) && field[1][2].equals(field[2][2])) {
            System.out.println("Победили " + field[2][0]);
            return true;
        }

        if (field[0][0].equals(field[1][1]) && field[1][1].equals(field[2][2])) {
            System.out.println("Победили " + field[1][1]);
            return true;
        }

        if (field[2][0].equals(field[1][1]) && field[1][2].equals(field[0][2])) {
            System.out.println("Победили " + field[1][1]);
            return true;
        }
        return false;
    }

    public static void showField() {
        System.out.println(" "+ field[0][0] +" | " + field[0][1] + "  | " + field[0][2] +" " + "\n___|___|___" + "\n   |   |   " + "\n  " + field[1][0] + " | " + field[1][1] + " | " + field[1][2] + " " + "\n___|___|___" + "\n  " + field[2][0] + " | " + field[2][1] +" | " + field[2][2] +"  " + "\n   |   |  ");

    }
}

class PlayerXO {
    private String sign;

    public PlayerXO(String sign) {
        this.sign = sign;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}




