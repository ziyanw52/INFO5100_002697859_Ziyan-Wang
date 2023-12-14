package exercises.exercise5;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Singleton Pattern
class ShoppingCart {
    private static ShoppingCart instance;

    private ShoppingCart() {
    }

    public static ShoppingCart getInstance() {
        if (instance == null) {
            instance = new ShoppingCart();
        }
        return instance;
    }

    public void addItem(String item) {
        System.out.println("Please adding item to the shopping cart: " + item);
    }

    // Other shopping cart methods...
}

// Observer Pattern
interface Observer {
    void update(String message);
}

class EmailNotification implements Observer {
    @Override
    public void update(String message) {
        System.out.println("Sending email notification: " + message);
    }
}

class SMSNotification implements Observer {
    @Override
    public void update(String message) {
        System.out.println("Sending SMS notification: " + message);
    }
}

class OrderSubject {
    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void placeOrder(String orderDetails) {
        System.out.println("Placing order: " + orderDetails);
        notifyObservers("Order placed: " + orderDetails);
    }

    private void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}

// Strategy Pattern
interface PaymentStrategy {
    void pay(double amount);
}

class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paying $" + amount + " using credit card ending with " + cardNumber.substring(cardNumber.length() - 4));
    }
}

class ApplePayPayment implements PaymentStrategy {
    private String email;

    public ApplePayPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paying $" + amount + " using ApplePay " + email);
    }
}

public class OnlineShopping {
    public static void main(String[] args) {
        // Singleton Pattern
        ShoppingCart cart = ShoppingCart.getInstance();

        // Observer Pattern
        EmailNotification emailNotification = new EmailNotification();
        SMSNotification smsNotification = new SMSNotification();

        OrderSubject orderSubject = new OrderSubject();
        orderSubject.addObserver(emailNotification);
        orderSubject.addObserver(smsNotification);

        // Strategy Pattern
        System.out.println("Choose payment method: 1 - Credit Card, 2 - ApplePay");
        Scanner scanner = new Scanner(System.in);
        int paymentMethod = scanner.nextInt();

        PaymentStrategy paymentStrategy;
        if (paymentMethod == 1) {
            System.out.println("Enter credit card number: ");
            String cardNumber = scanner.next();
            paymentStrategy = new CreditCardPayment(cardNumber);
        } else {
            System.out.println("Enter ApplePay email: ");
            String email = scanner.next();
            paymentStrategy = new ApplePayPayment(email);
        }

        // Placing an order
        cart.addItem("Product 1");
        cart.addItem("Product 2");

        orderSubject.placeOrder("Product 1, Product 2");

        double totalAmount = 100.0; // Assuming a total amount for the order
        paymentStrategy.pay(totalAmount);
    }
}

