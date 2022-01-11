package com.lib.api.app.v1.repository;


import com.lib.api.app.v1.entity.User;

public interface UserRepositoryCustom {
    //User findByUserId(String userId);

    User findByIdx(Long userIdx);
}
