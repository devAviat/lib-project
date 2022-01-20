package com.lib.api.app;

import com.lib.api.app.v1.dto.book.CreateBookDTO;
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

@Profile("local")
@Component
@RequiredArgsConstructor
@Slf4j
public class Dummy {

    private final CreateUser createUser;
    private final CreateBook createBook;

    @PostConstruct
    public void init() throws Exception {
        createUser.createDummyUser();
        createBook.createDummyBook();
    }


    @Component
    @RequiredArgsConstructor
    static class CreateBook {

        @PersistenceContext
        private EntityManager em;
        private final BookService bookService;


        @Transactional
        public void createDummyBook() throws Exception {

            CreateBookDTO dto1 = new CreateBookDTO();
            dto1.setAuthor("이순신");
            dto1.setName("JPA master");
            dto1.setPrice(2000L);

            CreateBookDTO dto2 = new CreateBookDTO();
            dto2.setAuthor("장보고");
            dto2.setName("JPA junior");
            dto2.setPrice(4000L);

            CreateBookDTO dto3 = new CreateBookDTO();
            dto3.setAuthor("류성룡");
            dto3.setName("JAVA Stater");
            dto3.setPrice(10000L);

            CreateBookDTO dto4 = new CreateBookDTO();
            dto4.setAuthor("장보고");
            dto4.setName("React Master");
            dto4.setPrice(7000L);


            bookService.setCreateBook(dto1);
            bookService.setCreateBook(dto2);
            bookService.setCreateBook(dto3);
            bookService.setCreateBook(dto4);
        }

    }

    @Component
    @RequiredArgsConstructor
    static class CreateUser {

        @PersistenceContext
        private EntityManager em;
        private final UserService userService;


        @Transactional
        public void createDummyUser() throws Exception {

            CreateUserDTO createUserDTO1 = new CreateUserDTO();
            createUserDTO1.setId("LIB_1");
            createUserDTO1.setName("홍길동");
            createUserDTO1.setNumber("010-1111-2222");
            createUserDTO1.setState("READY");

            CreateUserDTO createUserDTO2 = new CreateUserDTO();
            createUserDTO2.setId("LIB_2");
            createUserDTO2.setName("대조영");
            createUserDTO2.setNumber("010-3333-4");
            createUserDTO2.setState("READY");

            userService.setCreateUser(createUserDTO1);
            userService.setCreateUser(createUserDTO2);
        }

    }
}






/*

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

    }
}
*/
