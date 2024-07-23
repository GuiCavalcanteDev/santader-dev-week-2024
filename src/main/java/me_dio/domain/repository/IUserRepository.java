package me_dio.domain.repository;

import me_dio.domain.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<UserModel, Long> {

    boolean existsByAccountNumber(String accountNumber);
}
