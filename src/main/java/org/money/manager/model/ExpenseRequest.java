package org.money.manager.model;

public class ExpenseRequest {
    private String description;
    private double amount;
    private String category;   // Add category field for consistency
    private String occurrence; // "Unplanned", "Daily", "Weekly", "Monthly", or "Yearly"

    // Getters and Setters
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getOccurrence() {
        return occurrence;
    }

    public void setOccurrence(String occurrence) {
        this.occurrence = occurrence;
    }
}
