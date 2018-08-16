package com.chaka.jhipster.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.chaka.jhipster.domain.enumeration.BankAccountType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * A BankAccount.
 */
@Entity
@Table(name = "bank_account")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class BankAccount implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @Column(name = "balance", precision = 10, scale = 2, nullable = false)
    private BigDecimal balance;

    @Enumerated(EnumType.STRING)
    @Column(name = "jhi_type")
    private BankAccountType type;

    @OneToMany(mappedBy = "bankAccount")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Operation> operations = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties("")
    private User user;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public BankAccount name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public BankAccount balance(BigDecimal balance) {
        this.balance = balance;
        return this;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BankAccountType getType() {
        return type;
    }

    public BankAccount type(BankAccountType type) {
        this.type = type;
        return this;
    }

    public void setType(BankAccountType type) {
        this.type = type;
    }

    public Set<Operation> getOperations() {
        return operations;
    }

    public BankAccount operations(Set<Operation> operations) {
        this.operations = operations;
        return this;
    }

    public BankAccount addOperations(Operation operation) {
        this.operations.add(operation);
        operation.setBankAccount(this);
        return this;
    }

    public BankAccount removeOperations(Operation operation) {
        this.operations.remove(operation);
        operation.setBankAccount(null);
        return this;
    }

    public void setOperations(Set<Operation> operations) {
        this.operations = operations;
    }

    public User getUser() {
        return user;
    }

    public BankAccount user(User user) {
        this.user = user;
        return this;
    }

    public void setUser(User user) {
        this.user = user;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BankAccount bankAccount = (BankAccount) o;
        if (bankAccount.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), bankAccount.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "BankAccount{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", balance=" + getBalance() +
            ", type='" + getType() + "'" +
            "}";
    }
}
