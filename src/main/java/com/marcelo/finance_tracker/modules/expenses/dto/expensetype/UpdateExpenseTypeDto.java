package com.marcelo.finance_tracker.modules.expenses.dto.expensetype;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateExpenseTypeDto {

    private UUID id;
    private String description;
}
