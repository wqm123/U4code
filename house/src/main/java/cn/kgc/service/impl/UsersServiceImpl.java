package cn.kgc.service.impl;

import cn.kgc.entity.Users;
import cn.kgc.entity.UsersExample;
import cn.kgc.mapper.UsersMapper;
import cn.kgc.service.UsersService;
import cn.kgc.utils.MD5Utils;
import cn.kgc.utils.UsersCondition;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {
@Autowired
private UsersMapper usersMapper;
    public PageInfo<Users> getUsersByCondition(UsersCondition usersCondition) {
        //开启分页，传当前页，页大小
        PageHelper.startPage(usersCondition.getPage(),usersCondition.getRows());
       //条件
        UsersExample usersExample = new UsersExample();
        UsersExample.Criteria criteria = usersExample.createCriteria();
        if (usersCondition.getName()!=null&&!usersCondition.getName().trim().isEmpty()){
            criteria.andNameLike("%"+usersCondition.getName().trim()+"%");
        }
        if (usersCondition.getTelephone()!=null&&!usersCondition.getTelephone().trim().isEmpty()){
            criteria.andTelephoneLike("%"+usersCondition.getTelephone().trim()+"%");
        }
        /*查询*/
        List<Users> usersList = usersMapper.selectByExample(usersExample);
        PageInfo usersPageInfo = new PageInfo(usersList);
        return usersPageInfo;
    }

    @Override
    public int addUsers(Users users) {
        /*设置管理权限为0*/
        users.setIsadmin(0);
        /*通过md5工具在数据库中隐藏密码*/
        users.setPassword(MD5Utils.md5Encrypt(users.getPassword()));
        int i = usersMapper.insertSelective(users);

        return i;
    }

    @Override
    public int confirmName(String name) {
        UsersExample usersExample = new UsersExample();
        UsersExample.Criteria criteria = usersExample.createCriteria();
        criteria.andNameEqualTo(name);
        List<Users> usersList = usersMapper.selectByExample(usersExample);
        return usersList.size();
    }

    @Override
    public Users loginUser(String name, String password) {
        UsersExample usersExample = new UsersExample();
        UsersExample.Criteria criteria = usersExample.createCriteria();
        criteria.andNameEqualTo(name);
        /*密码需要转换成md5密码格式*/
        criteria.andPasswordEqualTo(MD5Utils.md5Encrypt(password));
        /*条件查询*/
        List<Users> usersList = usersMapper.selectByExample(usersExample);
        if (usersList.size()==0){
            return null;
        }
        //返回users对象
        return usersList.get(0);
    }
}
