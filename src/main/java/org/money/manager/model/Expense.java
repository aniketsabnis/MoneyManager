package org.money.manager.model;

import jakarta.persistence.*;

@Entity
@Table(name = "expense") // Specifies the table name in the database
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private double amount;

    @ManyToOne // Many expenses can belong to one user
    @JoinColumn(name = "user_id") // Foreign key column referencing appuser
    private AppUser user;

    private String occurrence;
    private String date;
    private String category;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public AppUser getUser() { return user; }
    public void setUser(AppUser user) { this.user = user; }

    public String getOccurrence() { return occurrence; }
    public void setOccurrence(String occurrence) { this.occurrence = occurrence; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
}
