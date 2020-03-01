package h2.studio.demo.transactions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) { this.transactionRepository = transactionRepository;}

    public List<Transaction> getAllTransactions() { return this.transactionRepository.findAll();}

    public Optional<Transaction> getOneTransaction(int id) { return transactionRepository.findById(id); }

    public Transaction addNewTransaction(Transaction newTransaction){
        Transaction currentTransaction = transactionRepository.save(newTransaction);

        return currentTransaction;
    }

    public Transaction updateTransaction (Transaction updatedTransaction){ return transactionRepository.save(updatedTransaction);}

    public String deleteTransaction(int id){
        transactionRepository.deleteById(id);
        return "ID " + id + " was removed."; }

}
