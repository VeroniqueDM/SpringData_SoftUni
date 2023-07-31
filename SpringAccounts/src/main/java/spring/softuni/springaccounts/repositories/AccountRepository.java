package spring.softuni.springaccounts.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.softuni.springaccounts.models.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
}
