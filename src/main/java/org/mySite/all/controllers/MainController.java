package org.mySite.all.controllers;

import org.mySite.all.models.Bill;
import org.mySite.all.models.Transaction;
import org.mySite.all.models.User;
import org.mySite.all.repository.BillRepository;
import org.mySite.all.repository.TransactionRepository;
import org.mySite.all.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class MainController {

    private UserRepository userRepository;
    private BillRepository billRepository;
    private TransactionRepository transactionRepository;


    @Autowired
    public MainController(UserRepository usersRepository, BillRepository billRepository, TransactionRepository transactionRepository) {
        this.userRepository = usersRepository;
        this.billRepository = billRepository;
        this.transactionRepository = transactionRepository;
    }


    @GetMapping("/")
    public String home() {
        return "success";
    }




    @GetMapping("/transaction/make")
    public String transactionMake(Model model) {
        return "transactionMake";
    }
    @PostMapping("/transaction/make")
    public String transaction(@RequestParam String user, @RequestParam float amount, Model model) {
        System.out.println(1);
        Transaction transaction = new Transaction(amount, user);
        transactionRepository.save(transaction);
        return "success";
    }
//    @GetMapping("/success")
//    public String transactionSuccess(Model model) {
//        return "success";
//    }






    @GetMapping("/create/account")
    public String createAccount(Model model) {
        return "createAccount";
    }
    @PostMapping("/create/account")
    public String account(@RequestParam long userId, @RequestParam String userName,  Model model) {
        System.out.println(1);
        User user = new User(userId, userName);
        userRepository.save(user);
        return "redirect:/account/success";
    }
    @GetMapping("/account/success")
    public String accountSuccess(Model model) {
        return "success";
    }



    @GetMapping("/amount/add")
    public String amountAdd(Model model) {
        return "amountAdd";
    }
    @PostMapping("amount/add")
    public String amount(@RequestParam long billId, float amount, Model model){
        Bill bill = new Bill(billId, amount);
        billRepository.save(bill);
        return "redirect:/amount/success";
    }
    @GetMapping("/amount/success")
    public String amountSuccess(Model model) {
        return "success";
    }

}
