package cn.kgc.mapper;

import cn.kgc.entity.Street;
import cn.kgc.entity.StreetExample;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface StreetMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Street record);

    int insertSelective(Street record);

    List<Street> selectByExample(StreetExample example);

    Street selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Street record);

    int updateByPrimaryKey(Street record);
}