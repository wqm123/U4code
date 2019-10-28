package cn.kgc.mapper;

import cn.kgc.entity.Type;
import cn.kgc.entity.TypeExample;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface TypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Type record);

    int insertSelective(Type record);

    List<Type> selectByExample(TypeExample example);

    Type selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Type record);

    int updateByPrimaryKey(Type record);

    int deleteMoreTypes(Integer[] ids);
}