package me_dio.domain.service;

import me_dio.domain.model.UserModel;

public interface IUserService {

    UserModel findById(Long id);
    UserModel create(UserModel userToCreate);
}
