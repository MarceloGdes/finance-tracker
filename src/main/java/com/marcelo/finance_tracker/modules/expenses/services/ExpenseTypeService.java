package com.marcelo.finance_tracker.modules.expenses.services;

import com.marcelo.finance_tracker.modules.expenses.dto.expensetype.CreateExpenseTypeDto;
import com.marcelo.finance_tracker.modules.expenses.dto.expensetype.UpdateExpenseTypeDto;
import com.marcelo.finance_tracker.modules.expenses.entities.ExpenseTypeEntity;
import com.marcelo.finance_tracker.modules.expenses.repositories.ExpenseTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ExpenseTypeService {

    @Autowired
    private ExpenseTypeRepository repository;

    //TODO: Realizar testes e validar se precisa de mais validações
    public ExpenseTypeEntity create(CreateExpenseTypeDto dto) {

        var expenseType = ExpenseTypeEntity.builder()
                .description(dto.getDescription())
                .build();

        return repository.save(expenseType);
    }

    public List<ExpenseTypeEntity> getExpenseTypes() {
        return repository.findAll();
    }

    public ExpenseTypeEntity updateExpenseType(UpdateExpenseTypeDto dto) throws ResponseStatusException {

//      Se o Optional estiver vazio, a exceção é lançada ResponseStatusException.
//      Caso contrário, ele retorna o objeto ExpenseTypeEntity encontrado.
        ExpenseTypeEntity expenseType = repository
                .findById(dto.getId())
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tipo de despesa não encontrado"));

        expenseType.setDescription(dto.getDescription());


        return repository.save(expenseType);

    }

    public void deleteExpenseType(UUID id) throws DataIntegrityViolationException, ResponseStatusException{
        ExpenseTypeEntity expenseType = repository
                .findById(id)
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tipo de despesa não encontrado"));

        repository.delete(expenseType);
    }

    public ExpenseTypeEntity getExpenseTypesById(UUID id) throws ResponseStatusException{
        ExpenseTypeEntity expenseType = repository
                .findById(id)
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tipo de despesa não encontrado"));

        return expenseType;
    }



}
