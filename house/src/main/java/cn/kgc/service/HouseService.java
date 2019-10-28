package cn.kgc.service;

import cn.kgc.entity.ExtHouse;
import cn.kgc.entity.House;
import cn.kgc.utils.HouseCondition;
import cn.kgc.utils.PageUtil;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface HouseService {
    /**
     * 添加出租房
     * @param house house实体
     * @return
     */
    int addHouse(House house);

    /**
     * 通过用户id显示出租房信息
     * @param id
     * @return
     */
    List<ExtHouse> showHouseInfoByUsers(Integer id);

    /**
     * 回显house的信息
     * @param id
     * @return
     */
    ExtHouse queryHouseById(String id);

    /**
     * 修改房屋信息
     * @param house
     * @return 影响行数
     */
    int updateHouse(ExtHouse house);

    /**
     * 删除出租房信息
     * @param id house的id
     * @param state 是否删除的状态
     * @return 影响行数
     */
    int delHouse(String id,Integer state);

    /**
     * 是否通过审核的房子
     * @return
     */
    PageInfo<ExtHouse> queryHouseByIspass(PageUtil pageUtil,Integer state);

    /**
     * 审核房屋
     * @param id
     * @param state
     * @return 影响行数
     */
   int checkHouse(String id,Integer state);

    /**
     * 带条件分页查询房屋信息
     * @param condition
     * @return
     */
    PageInfo<ExtHouse> queryHouseByCondition(HouseCondition condition);
}
