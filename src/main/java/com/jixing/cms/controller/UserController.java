package com.jixing.cms.controller;

import com.jixing.cms.mapper.UserMapper;
import com.jixing.cms.model.User;
import com.jixing.cms.vo.request.LoginRequest;
import com.jixing.cms.vo.response.BasePageResponse;
import com.jixing.cms.vo.response.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("login")
    @ResponseBody
    public BaseResponse login(@RequestBody LoginRequest request){
        log.info("login request= " + request);
        String userName = request.getUsername();
        String password = request.getPassword();
        User user = userMapper.selectByUserName(userName);
        BaseResponse response = null;
        if(StringUtils.equals(password, user.getPassword())){
            user.setPassword(null);
            response = BaseResponse.success(user);
        }else{
            response = BaseResponse.fail("密码错误");
        }
        log.info("login response= " + response);
        return response;
    }

    @RequestMapping("update")
    @ResponseBody
    public BaseResponse update(@RequestBody User user){
        log.info("update request= " + user);
        userMapper.updateByPrimaryKeySelective(user);
        BaseResponse response = BaseResponse.success("success");
        log.info("update response= " + response);
        return response;
    }

    @RequestMapping("add")
    @ResponseBody
    public BaseResponse add(@RequestBody User user){
        log.info("add user= " + user);
        userMapper.insertSelective(user);
        BaseResponse response = BaseResponse.success("success");
        log.info("add response= " + response);
        return response;
    }

    @RequestMapping("delete")
    @ResponseBody
    public BaseResponse delete(@RequestParam("id") Integer id){
        log.info("delete user= " + id);
        userMapper.deleteByPrimaryKey(id);
        BaseResponse response = BaseResponse.success("success");
        log.info("delete response= " + response);
        return response;
    }

    @RequestMapping("all")
    @ResponseBody
    public BasePageResponse all(@RequestParam(value = "pageNum",required = false, defaultValue = "1") Integer pageNum,
                                @RequestParam(value = "pageSize",required = false, defaultValue = "20") Integer pageSize){
        int count = userMapper.count();
        if(count == 0){
            return BasePageResponse.fail("没有用户");
        }
        Integer pageSum = (count + pageSize -1)/pageSize;
        Integer pageIndex = (pageNum-1) * pageSize;
        List<User> list = userMapper.list(pageIndex, pageSize);

        BasePageResponse response = BasePageResponse.success(list, count, pageSum);
        return response;
    }
}
