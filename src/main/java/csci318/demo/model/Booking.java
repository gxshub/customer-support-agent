package csci318.demo.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Booking {
    @Id
    private String bookingNumber;
    @Column
    private LocalDate bookingBeginDate;
    @Column
    private LocalDate bookingEndDate;
    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Booking() {
    }

    public Booking(String bookingNumber, LocalDate bookingBeginDate, LocalDate bookingEndDate, Customer customer) {
        this.bookingNumber = bookingNumber;
        this.bookingBeginDate = bookingBeginDate;
        this.bookingEndDate = bookingEndDate;
        this.customer = customer;
    }

    public String getBookingNumber() {
        return bookingNumber;
    }

    public void setBookingNumber(String bookingNumber) {
        this.bookingNumber = bookingNumber;
    }

    public LocalDate getBookingBeginDate() {
        return bookingBeginDate;
    }

    public void setBookingBeginDate(LocalDate bookingBeginDate) {
        this.bookingBeginDate = bookingBeginDate;
    }

    public LocalDate getBookingEndDate() {
        return bookingEndDate;
    }

    public void setBookingEndDate(LocalDate bookingEndDate) {
        this.bookingEndDate = bookingEndDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingNumber='" + bookingNumber + '\'' +
                ", bookingBeginDate=" + bookingBeginDate +
                ", bookingEndDate=" + bookingEndDate +
                ", customer=" + customer +
                '}';
    }
}