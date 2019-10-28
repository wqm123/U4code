package cn.kgc.mapper;

import cn.kgc.entity.Users;
import cn.kgc.entity.UsersExample;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface UsersMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Users record);

    int insertSelective(Users record);

    List<Users> selectByExample(UsersExample example);

    Users selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);
}