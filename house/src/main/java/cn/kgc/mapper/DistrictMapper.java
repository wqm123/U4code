package cn.kgc.mapper;

import cn.kgc.entity.District;
import cn.kgc.entity.DistrictExample;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface DistrictMapper {
    int deleteByPrimaryKey(Integer id);

    int deleteStreetByKey(Integer districtId);

    int insert(District record);

    int insertSelective(District record);

    List<District> selectByExample(DistrictExample example);

    District selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(District record);

    int updateByPrimaryKey(District record);

    int deleteMoreDistricts(Integer[] ids);
}