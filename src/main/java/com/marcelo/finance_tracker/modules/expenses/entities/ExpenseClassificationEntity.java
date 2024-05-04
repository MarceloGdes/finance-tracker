package com.marcelo.finance_tracker.modules.expenses.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity(name = "expense_classification")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ExpenseClassificationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String description;

    @OneToMany(mappedBy = "expenseClassification")
    private List<ExpenseClassificationMappingEntity> classifiedExpenses;

    @CreationTimestamp
    private LocalDateTime cretatedAt;
    
}
