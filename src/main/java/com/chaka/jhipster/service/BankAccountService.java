package com.chaka.jhipster.service;

import com.chaka.jhipster.domain.BankAccount;
import com.chaka.jhipster.repository.BankAccountRepository;
import com.chaka.jhipster.security.AuthoritiesConstants;
import com.chaka.jhipster.security.SecurityUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing BankAccount.
 */
@Service
@Transactional
public class BankAccountService {

	private final Logger log = LoggerFactory.getLogger(BankAccountService.class);

	private final BankAccountRepository bankAccountRepository;

	public BankAccountService(BankAccountRepository bankAccountRepository) {
		this.bankAccountRepository = bankAccountRepository;
	}

	/**
	 * Save a bankAccount.
	 *
	 * @param bankAccount
	 *            the entity to save
	 * @return the persisted entity
	 */
	public BankAccount save(BankAccount bankAccount) {
		log.debug("Request to save BankAccount : {}", bankAccount);
		return bankAccountRepository.save(bankAccount);
	}

	/**
	 * Get all the bankAccounts.
	 *
	 * @param pageable
	 *            the pagination information
	 * @return the list of entities
	 */
	@Transactional(readOnly = true)
	public Page<BankAccount> findAll(Pageable pageable) {
		log.debug("Request to get all BankAccounts");
		Page<BankAccount> page;
		if (SecurityUtils.isCurrentUserInRole(AuthoritiesConstants.ADMIN))
			page = bankAccountRepository.findAll(pageable);
		else
			page = bankAccountRepository.findByUserIsCurrentUser(pageable);
		return page;
	}

	/**
	 * Get one bankAccount by id.
	 *
	 * @param id
	 *            the id of the entity
	 * @return the entity
	 */
	@Transactional(readOnly = true)
	public Optional<BankAccount> findOne(Long id) {
		log.debug("Request to get BankAccount : {}", id);
		return bankAccountRepository.findById(id);
	}

	/**
	 * Delete the bankAccount by id.
	 *
	 * @param id
	 *            the id of the entity
	 */
	public void delete(Long id) {
		log.debug("Request to delete BankAccount : {}", id);
		bankAccountRepository.deleteById(id);
	}
}
