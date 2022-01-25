package com.lib.api.app.v1.controller;

import com.lib.api.app.v1.dto.user.CreateUserDTO;
import com.lib.api.app.v1.dto.user.ModifyUserDTO;
import com.lib.api.app.v1.entity.User;
import com.lib.api.app.v1.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author MG.KIM
 * @version v1
 * @createDate 2022-01-11
 */

@Slf4j
@RequestMapping("/v1")
@Api(tags = {"사용자 관리"})
@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

    @ApiOperation(value = "사용자 생성")
    @PostMapping(value = "/user")
    public Long create(CreateUserDTO param) throws Exception{
        User user = userService.setCreateUser(param);
        return user.getId();
    }

    @ApiOperation(value = "사용자 수정")
    @PutMapping(value = "/user")
    public User modify(ModifyUserDTO param){
        return userService.setModifyUser(param);
    }

    @ApiOperation(value = "사용자 조회")
    @GetMapping(value = "/user/{userIdx}")
    public User read(@PathVariable Long userIdx){
        return userService.getOneUser(userIdx);
    }

    @ApiOperation(value = "사용자 목록")
    @GetMapping(value = "/user/list")
    public List<User> list(){
        return userService.getListUser();
    }

}
