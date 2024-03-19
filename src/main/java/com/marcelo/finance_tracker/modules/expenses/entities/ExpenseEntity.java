package com.marcelo.finance_tracker.modules.expenses.entities;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "expenses")
public class ExpenseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(unique = true, nullable = false, updatable = false)
    private Integer expenseNumber;

    private String description;

    @Column(nullable = false)
    private Double totalValue;

    private boolean paid;

    @Column(insertable=false, updatable=false)
    private UUID expenseTypeID;

    @ManyToOne
    @JoinColumn(name = "expenseTypeID")
    private ExpenseTypeEntity expenseType;

    private UUID createdByUserID;

    @CreationTimestamp
    private LocalDateTime cretatedAt;
    
}
