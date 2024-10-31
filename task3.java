package lab3;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// Interface for common functions related to ticket booking
interface CommonFunctions {
    void searchTicket();
    void bookTicket();
    void cancelTicket();
    void makePayment();
    void fillDetails();
}

// Class representing a Customer
class Customer {
    String customerId;
    private String name;
    private String address;
    private int phoneNo;
    private int age;
    private List<Ticket> tickets;

    public Customer(String customerId, String name, String address, int phoneNo, int age) {
        this.customerId = customerId;
        this.name = name;
        this.address = address;
        this.phoneNo = phoneNo;
        this.age = age;
        this.tickets = new ArrayList<>(); // Initialize the list
    }

    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    public List<Ticket> getTickets() {
        return tickets;
    }
}

// Class representing an Agent that implements common functions
class Agent implements CommonFunctions {
    private int id;
    private String name;

    public Agent(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public void searchTicket() {
        System.out.println("Searching for tickets...");
    }

    @Override
    public void bookTicket() {
        System.out.println("Booking a ticket...");
    }

    @Override
    public void cancelTicket() {
        System.out.println("Cancelling a ticket...");
    }

    @Override
    public void makePayment() {
        System.out.println("Making payment...");
    }

    @Override
    public void fillDetails() {
        System.out.println("Filling details...");
    }
}

// Class representing a Ticket
class Ticket {
    private String source;
    private String destination;
    private Date dateOfJourney;
    private String time;
    private String busNo;
    private String seatNo;

    public Ticket(String source, String destination, Date dateOfJourney, String time, String busNo, String seatNo) {
        this.source = source;
        this.destination = destination;
        this.dateOfJourney = dateOfJourney;
        this.time = time;
        this.busNo = busNo;
        this.seatNo = seatNo;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", dateOfJourney=" + dateOfJourney +
                ", time='" + time + '\'' +
                ", busNo='" + busNo + '\'' +
                ", seatNo='" + seatNo + '\'' +
                '}';
    }
}

// Class for managing bookings at the counter
class BookingCounter {
    private List<Ticket> bookedTickets;

    public BookingCounter() {
        bookedTickets = new ArrayList<>(); // Initialize the list
    }

    public void addBookedTicket(Ticket ticket) {
        bookedTickets.add(ticket);
    }

    public List<Ticket> getBookedTickets() {
        return bookedTickets;
    }
}

// Class for handling refunds
class Refund {
    private float amount;
    private String customerId;

    public Refund(float amount, String customerId) {
        this.amount = amount;
        this.customerId = customerId;
    }

    public void refundAmount() {
        System.out.println("Refunding " + amount + " to customer " + customerId);
    }
}

// Main class to test the functionality
public class task3 {
    public static void main(String[] args) {
        // Create instances for testing
        Customer customer = new Customer("C001", "John Doe", "123 Main St", 1234567890, 30);
        Agent agent = new Agent(1, "Agent Smith");

        // Create a ticket and add it to the customer
        Ticket ticket = new Ticket("City A", "City B", new Date(), "10:00 AM", "Bus 123", "A1");
        customer.addTicket(ticket);

        // Simulate agent actions
        agent.searchTicket();
        agent.bookTicket();
        agent.makePayment();

        // Display customer tickets
        System.out.println("Customer Tickets:");
        for (Ticket t : customer.getTickets()) {
            System.out.println(t);
        }

        // Handle a refund
        Refund refund = new Refund(50.0f, customer.customerId);
        refund.refundAmount();
    }
}
