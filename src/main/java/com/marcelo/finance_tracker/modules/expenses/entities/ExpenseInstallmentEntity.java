package com.marcelo.finance_tracker.modules.expenses.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "expense_installment")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ExpenseInstallmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "expense_id", nullable = false)
    @JsonBackReference
    private ExpenseEntity expense;

    @Column(nullable = false)
    private Integer installmentNumber;

    @Column(nullable = false)
    private Double value;

    @Column(nullable = false)
    private LocalDate dueDate;

    @Column(nullable = false)
    private boolean paid;

    @CreationTimestamp
    private LocalDateTime createdAt;

}
