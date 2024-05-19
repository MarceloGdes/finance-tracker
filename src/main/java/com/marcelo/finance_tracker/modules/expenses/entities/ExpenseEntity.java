package com.marcelo.finance_tracker.modules.expenses.entities;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.*;
import lombok.Builder;
import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity(name = "expense")

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

    @ManyToOne
    @JoinColumn(name = "expense_type_id", unique = false)
    private ExpenseTypeEntity expenseType;


    @OneToMany(mappedBy = "expense")
    private List<ExpenseClassificationMappingEntity> classificationsMapping;

    @OneToMany(mappedBy = "expense")
    private List<ExpenseInstallmentEntity> installments;

//    @Column(nullable = true)
//    private UUID createdByUserID;

    @CreationTimestamp
    private LocalDateTime cretatedAt;
    
}
