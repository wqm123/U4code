package cn.kgc.mapper;

import cn.kgc.entity.ExtHouse;
import cn.kgc.entity.House;
import cn.kgc.entity.HouseExample;
import cn.kgc.utils.HouseCondition;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface HouseMapper {
    int deleteByPrimaryKey(String id);

    int insert(House record);

    int insertSelective(House record);

    List<House> selectByExample(HouseExample example);

    House selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(House record);

    int updateByPrimaryKey(House record);

    /**
     * 通过用户id查询出发布的房子信息
     * @param uid
     * @return
     */
    List<ExtHouse> showHouseInfoByUsers(Integer uid);

    /**
     * 通过id查询house信息回显
     * @param id house的id
     * @return house
     */
    ExtHouse queryHouseById(String id);

    /**
     * 查询房屋是否审核通过
     * @param state
     * @return
     */
    List<ExtHouse> queryHouseByIspass(Integer state);

    /**
     * 带条件查询房屋信息
     * @param condition
     * @return
     */
    List<ExtHouse> queryHouseByCondition(HouseCondition condition);

}