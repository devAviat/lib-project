package com.lib.api.app;

import com.lib.api.app.v1.dto.user.CreateUserDTO;
import com.lib.api.app.v1.service.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Profile("local")
@Component
@RequiredArgsConstructor
@Slf4j
public class Dummy {
/*
    private final CreateUser createUser;

    @PostConstruct
    public void init() {
        createUser.createDummyUser();
    }


    @Component
    @RequiredArgsConstructor
    static class CreateUser {

        @PersistenceContext
        private EntityManager em;
        private final UserService userService;


        @Transactional
        public void createDummyUser() {

            List<String> list = new ArrayList<>();
            list.add("USER_ID1");
            list.add("USER_ID2");
            list.add("USER_ID3");
            list.add("USER_ID4");
            list.add("USER_ID5");

            HashMap<Integer, String> collect = list
                    .stream()
                    .collect(HashMap<Integer, String>::new,
                            (map, streamValue) -> map.put(map.size(), streamValue),
                            (map, map2) -> {
                            });

            collect.forEach((index, name) ->
            {
                CreateUserDTO createUserDTO = new CreateUserDTO();
                createUserDTO.setName(name);

                try {
                    userService.userCreate(createUserDTO);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

        }
    }*/
}
