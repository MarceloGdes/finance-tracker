package com.marcelo.finance_tracker.modules.expenses.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseDTO {

    private String description;
    private Double totalValue;
    private boolean paid;
    private UUID expenseTypeId;
    private List<UUID> expenseClassificationIDs;

}
