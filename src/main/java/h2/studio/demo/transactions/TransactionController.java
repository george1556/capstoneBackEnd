package h2.studio.demo.transactions;

import h2.studio.demo.products.Product;
import h2.studio.demo.products.ProductService;
import h2.studio.demo.users.User;
import h2.studio.demo.users.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/transactions")


public class TransactionController {

    @Autowired
    private final TransactionService transactionService;

    @Autowired
    private final ProductService productService;

    @Autowired
    private final UsersService usersService;

    public TransactionController(TransactionService transactionService, ProductService productService, UsersService usersService){
        this.transactionService = transactionService;
        this.productService = productService;
        this.usersService = usersService;
    }

    @GetMapping
    public List<Transaction> getAllTransactions(){ return this.transactionService.getAllTransactions();}

    @GetMapping("/{id}")
    public Transaction getOneTransaction(@PathVariable int id){
        Transaction transaction = transactionService.getOneTransaction(id).orElseThrow(IllegalAccessError::new);

        return transaction;
    }




        @PostMapping("/{productId}")
    public Transaction addNewTransaction(@RequestBody Transaction newTransaction, @PathVariable int productId){
        Product product = productService.getOneProduct(productId).orElseThrow(IllegalArgumentException::new);
        newTransaction.setProduct(product);

        return transactionService.addNewTransaction(newTransaction);
    }





    @PatchMapping
    public Transaction updateTransaction(@RequestBody Transaction updatedTransaction){
        Transaction transaction = transactionService.getOneTransaction(updatedTransaction.getId()).orElseThrow(IllegalArgumentException::new);

        return transactionService.updateTransaction(updatedTransaction);
    }

    @DeleteMapping
    public String deleteTransaction(@PathVariable int id) {
        return transactionService.deleteTransaction(id);
    }

}
