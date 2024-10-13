package com.myBank.transactionService.dao;

import com.myBank.transactionService.entities.Transaction;
import com.myBank.transactionService.exceptions.TransactionNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class TransactionDaoImpl implements TransactionDao {

    @Autowired
    private EntityManager em;

    @Override
    public Transaction createTransaction(Transaction transaction) {
        this.em.persist(transaction);
        return transaction;
    }

    @Override
    public Transaction findTransactionById(int id) throws TransactionNotFound {
        Transaction transaction = this.em.find(Transaction.class ,id );
        if (transaction==null){
            throw new TransactionNotFound("transaction not fonud with id : " + id);
        }
        return transaction;
    }

    @Override
    public List<Transaction> findTransactionsByCustomerId(int customerId) throws TransactionNotFound {
        TypedQuery<Transaction> query = this.em.createQuery("From Transaction where customerId=:customerId",
                Transaction.class);
        query.setParameter("customerId",customerId);
        List<Transaction> transactions = query.getResultList();
        if (transactions.isEmpty()){
            throw new TransactionNotFound("transactions not found with customer id : " + customerId);
        }
        return transactions;
    }

    @Override
    public List<Transaction> findTransactionsByEmmiterAccount(String fromAccount) throws TransactionNotFound {
        TypedQuery<Transaction> query = this.em.createQuery("From Transaction where fromAccount=:fromAccount",
                Transaction.class);
        query.setParameter("fromAccount",fromAccount);
        List<Transaction> transactions = query.getResultList();
        if (transactions.isEmpty()){
            throw new TransactionNotFound("transactions not found with account : " + fromAccount);
        }
        return transactions;
    }
}
