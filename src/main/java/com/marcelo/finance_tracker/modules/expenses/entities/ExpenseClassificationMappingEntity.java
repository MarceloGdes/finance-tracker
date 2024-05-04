package com.marcelo.finance_tracker.modules.expenses.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity(name = "expense_classification_mapping")
public class ExpenseClassificationMappingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "expense_id", nullable = false)
    private ExpenseEntity expense;

    @ManyToOne()
    @JoinColumn(name = "expense_classification_id", nullable = false)
    private ExpenseClassificationEntity expenseClassification;

    @CreationTimestamp
    private LocalDateTime cretatedAt;
}
