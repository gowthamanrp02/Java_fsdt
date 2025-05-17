import java.util.Scanner;

class Person {
    String name;
    int age;

    Person(String name) {
        this.name = name;
        this.age = 18;
    }

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

class Product {
    int pid;
    double price;
    int quantity;

    Product(int pid, double price, int quantity) {
        this.pid = pid;
        this.price = price;
        this.quantity = quantity;
    }
}

class Account {
    double balance;

    Account() {
        balance = 0;
    }

    Account(double balance) {
        this.balance = balance;
    }

    void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient Balance.");
        }
    }

    void displayBalance() {
        System.out.println("Current Balance: " + balance);
    }
}

class Employee extends Person {
    int employeeID;
    double salary;

    Employee(String name, int age, int employeeID, double salary) {
        super(name, age);
        this.employeeID = employeeID;
        this.salary = salary;
    }

    void displayEmployee() {
        super.display();
        System.out.println("Employee ID: " + employeeID + ", Salary: " + salary);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1.1 Person Example
        System.out.println("1.1 Person:");
        Person p1 = new Person("Alice");
        Person p2 = new Person("Bob", 25);
        p1.display();
        p2.display();

        // 1.2 Product Example
        System.out.println("\n1.2 Product:");
        Product[] products = new Product[5];
        for (int i = 0; i < 5; i++) {
            System.out.println("Enter pid, price and quantity for product " + (i + 1));
            int pid = sc.nextInt();
            double price = sc.nextDouble();
            int quantity = sc.nextInt();
            products[i] = new Product(pid, price, quantity);
        }

        // Find product with highest price
        double maxPrice = products[0].price;
        int maxPid = products[0].pid;
        for (Product prod : products) {
            if (prod.price > maxPrice) {
                maxPrice = prod.price;
                maxPid = prod.pid;
            }
        }
        System.out.println("Product ID with highest price: " + maxPid);

        // Total amount spent
        double totalAmount = calculateTotalAmount(products);
        System.out.println("Total amount spent on all products: " + totalAmount);

        // 1.3 Account Example
        System.out.println("\n1.3 Account:");
        Account acc1 = new Account();
        acc1.deposit(1000);
        acc1.withdraw(200);
        acc1.displayBalance();

        Account acc2 = new Account(5000);
        acc2.withdraw(6000); // test insufficient balance
        acc2.deposit(1500);
        acc2.displayBalance();

        // 1.4 Inheritance Example
        System.out.println("\n1.4 Employee:");
        Employee emp = new Employee("Charlie", 30, 101, 55000);
        emp.displayEmployee();
    }

    public static double calculateTotalAmount(Product[] products) {
        double total = 0;
        for (Product p : products) {
            total += p.price * p.quantity;
        }
        return total;
    }
}
