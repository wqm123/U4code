package cn.kgc.service;

import cn.kgc.entity.Users;
import cn.kgc.utils.UsersCondition;
import com.github.pagehelper.PageInfo;

public interface UsersService {
    PageInfo<Users> getUsersByCondition(UsersCondition usersCondition);

    int addUsers(Users users);

    /**
     * 验证名字
     * @param name
     * @return
     */
    int confirmName(String name);

    /**
     * 登录验证
     * @param name
     * @param password
     * @return
     */
   Users loginUser(String name, String password);
}
