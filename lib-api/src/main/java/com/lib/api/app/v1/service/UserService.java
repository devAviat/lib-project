package com.lib.api.app.v1.service;

import com.lib.api.app.v1.dto.user.CreateUserDTO;
import com.lib.api.app.v1.dto.user.ModifyUserDTO;
import com.lib.api.app.v1.entity.User;
import com.lib.api.app.v1.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;

    /**
     * 사용자 생성.
     *
     * @param param
     * @return
     * @throws Exception
     */
    @Transactional
    public User setCreateUser(CreateUserDTO param) throws Exception {
        User build = User
                .builder()
                .param(param)
                .build();

        return userRepository
                .save(build);
    }


    /**
     * 사용자 조회.
     *
     * @param userIdx
     * @return
     */
    public User getOneUser(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    /**
     * 사용자 목록 조회.
     *
     * @return
     */
    public List<User> getListUser() {
        return userRepository.findAll();
    }

    /**
     * 사용자 정보 수정.
     *
     * @param param
     * @return
     */
    @Transactional
    public User setModifyUser(ModifyUserDTO param) {
        User user = getOneUser(param.getIdx());
        user.setUserName(param.getName());
        user.setUserBarcode(param.getBarcode());
        user.setUserPhoneNumber(param.getNumber());
        user.setUserState(param.getState());

        return user;
    }


}
