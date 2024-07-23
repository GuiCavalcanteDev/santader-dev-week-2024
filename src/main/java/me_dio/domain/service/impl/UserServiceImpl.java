package me_dio.domain.service.impl;

import me_dio.domain.model.UserModel;
import me_dio.domain.repository.IUserRepository;
import me_dio.domain.service.IUserService;

import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements IUserService {


    private final IUserRepository repository;

    public UserServiceImpl(IUserRepository repository){
        this.repository = repository;
    }

    @Override
    public UserModel findById(Long id) {
        return repository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public UserModel create(UserModel userToCreate) {
        if( repository.existsByAccountNumber(userToCreate.getAccount().getNumber())){
            throw new IllegalArgumentException("This Account number already exists.");
        }
        return repository.save(userToCreate);
    }
}
