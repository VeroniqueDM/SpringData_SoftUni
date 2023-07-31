package spring.softuni.springaccounts;


import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import spring.softuni.springaccounts.models.Account;
import spring.softuni.springaccounts.models.User;
import spring.softuni.springaccounts.services.AccountService;
import spring.softuni.springaccounts.services.UserService;

import java.math.BigDecimal;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private final AccountService accountService;

    private final UserService userService;


    public ConsoleRunner(AccountService accountService, UserService userService) {
        this.accountService = accountService;
        this.userService = userService;
    }


    @Override
    public void run(String... args) throws Exception {

        User someuser = new User("someuser", 20);
        userService.register(someuser);
        Account account = new Account();

        accountService.depositMoney(BigDecimal.valueOf(220),1L);

        accountService.withdrawMoney(BigDecimal.valueOf(200), 1L);
    }
}
