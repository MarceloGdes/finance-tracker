package com.marcelo.finance_tracker.modules.expenses.entities;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "expenses")
public class ExpenseEntity {
    
    //TO DO: criar um repositório para essa entidade e tentar salvar os dados na tabela para teste

    @Id()
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(unique = true)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int expenseNumber;

    private String description;

    private Double totalValue;

    private boolean paid;

    // @OneToOne
    // private List<ExpenseTypeEntity> expenseType;

    @CreationTimestamp
    private LocalDateTime cretatedAt;
    
}
