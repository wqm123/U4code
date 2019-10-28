package cn.kgc.service.impl;

import cn.kgc.entity.ExtHouse;
import cn.kgc.entity.House;
import cn.kgc.mapper.HouseMapper;
import cn.kgc.service.HouseService;
import cn.kgc.utils.HouseCondition;
import cn.kgc.utils.PageUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseServiceImpl implements HouseService {
    @Autowired
    private HouseMapper houseMapper;

    @Override
    public int addHouse(House house) {
        return houseMapper.insertSelective(house);
    }

    @Override
    public List<ExtHouse> showHouseInfoByUsers(Integer id) {
        return houseMapper.showHouseInfoByUsers(id);
    }

    @Override
    public ExtHouse queryHouseById(String id) {
        return houseMapper.queryHouseById(id);
    }

    @Override
    public int updateHouse(ExtHouse house) {
        return houseMapper.updateByPrimaryKeySelective(house);
    }

    @Override
    public int delHouse(String id, Integer state) {
        House house = new House();
        house.setId(id);
        //设置是否删除状态1代表删除
        house.setIsdel(state);
        return houseMapper.updateByPrimaryKeySelective(house);
    }

    //分页查询未审核的房屋
    @Override
    public PageInfo<ExtHouse> queryHouseByIspass(PageUtil pageUtil,Integer state) {
        //开启分页
        PageHelper.startPage(pageUtil.getPage(),pageUtil.getRows());
        //返回分页信息
      return   new PageInfo<ExtHouse>(houseMapper.queryHouseByIspass(state));

    }
//审核房屋
    @Override
    public int checkHouse(String id, Integer state) {
        House house = new House();
        house.setId(id);
        house.setIspass(state);
        return houseMapper.updateByPrimaryKeySelective(house);
    }
//带条件分页查询房屋信息
    @Override
    public PageInfo<ExtHouse> queryHouseByCondition(HouseCondition condition) {
        PageHelper.startPage(condition.getPage(),condition.getRows());
        PageInfo<ExtHouse> pageInfo = new PageInfo<>(houseMapper.queryHouseByCondition(condition));

         return pageInfo;
    }
}
