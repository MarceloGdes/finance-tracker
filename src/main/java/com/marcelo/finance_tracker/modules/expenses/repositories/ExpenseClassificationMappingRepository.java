package com.marcelo.finance_tracker.modules.expenses.repositories;

import com.marcelo.finance_tracker.modules.expenses.entities.ExpenseClassificationMappingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ExpenseClassificationMappingRepository extends JpaRepository
        <ExpenseClassificationMappingEntity, UUID> {



}
