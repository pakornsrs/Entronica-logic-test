package model;

import java.time.LocalDate;

public class Invoice {

    private int id;
    private double amount;
    private LocalDate due_date;
    private LocalDate paid_date;

    public Invoice(int id, double amount, LocalDate due_date, LocalDate paid_date) {
        this.id = id;
        this.amount = amount;
        this.due_date = due_date;
        this.paid_date = paid_date;
    }

    public int getId() {
        return this.id;
    }

    public double getAmount() {
        return this.amount;
    }

    public LocalDate getDueDate() {
        return this.due_date;
    }

    public LocalDate getPaidDate() {
        return this.paid_date;
    }

    public String toJson() {
        var paid = this.paid_date == null ? "None" : this.paid_date.toString();
        return String.format("{\"id\":%d, \"amount\":%.2f, \"due_date\":\"%s\", \"paid_date\":\"%s\" }",
                this.id, this.amount, this.due_date, paid);
    }
}
