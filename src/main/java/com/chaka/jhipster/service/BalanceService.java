package com.chaka.jhipster.service;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chaka.jhipster.domain.BankAccount;
import com.chaka.jhipster.domain.Operation;
import com.chaka.jhipster.domain.enumeration.OperationType;
import com.chaka.jhipster.repository.BankAccountRepository;
import com.chaka.jhipster.repository.OperationRepository;

@Service
@Transactional
public class BalanceService {

	private final Logger log = LoggerFactory.getLogger(BalanceService.class);

	private OperationRepository operationRepository;

	private BankAccountRepository bankAccountRepository;

	public BalanceService(OperationRepository operationRepository, BankAccountRepository bankAccountRepository) {
		this.operationRepository = operationRepository;
		this.bankAccountRepository = bankAccountRepository;
	}

	public Operation add(@Valid Operation operation) {
		Operation operationSaved = operationRepository.save(operation);

		bankAccountRepository.findById(operation.getBankAccount().getId()).map(bankAccount -> {
			if (operation.getType().equals(OperationType.DEPOSIT))
				bankAccount.setBalance(bankAccount.getBalance().add(operation.getAmount()));
			else
				bankAccount.setBalance(bankAccount.getBalance().subtract(operation.getAmount()));
			return bankAccount;
		});

		return operationSaved;
	}

}
