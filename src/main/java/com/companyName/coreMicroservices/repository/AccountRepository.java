package com.companyName.coreMicroservices.repository;

import com.companyName.coreMicroservices.repository.entity.Account;
import com.companyName.coreMicroservices.repository.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, String> {
    @Query(value="SELECT * FROM accounts WHERE FK_USER=:FkUser", nativeQuery = true)
    List<Account> getAllAccountPerUser(@Param("FkUser")String FkUser);

    List<Account> findByFkUser(@Param("FkUser")String FkUser);

    List<Account> findAll();

    //deprecata perchè non permette eliminazione se ci sono elementi collegati, vedi deleteAccountDetailByCf in DelegateImpl
    @Query(value="DELETE FROM accounts WHERE FK_USER=:FkUser", nativeQuery = true)
    List<Payment> deleteaccountByfkUser(@Param("FkUser")String FkUser);

}
