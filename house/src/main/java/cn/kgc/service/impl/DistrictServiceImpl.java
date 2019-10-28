package cn.kgc.service.impl;

import cn.kgc.entity.District;
import cn.kgc.entity.DistrictExample;
import cn.kgc.mapper.DistrictMapper;
import cn.kgc.service.DistrictService;
import cn.kgc.utils.PageUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class DistrictServiceImpl implements DistrictService {
    @Autowired
    private DistrictMapper ds;
    public List<District> getAllDistrict() {
        return ds.selectByExample(new DistrictExample());
    }

    public PageInfo<District> getDistrictByPage(PageUtil pageUtil) {
        PageHelper.startPage(pageUtil.getPage(),pageUtil.getRows());
        /*查询条件实体类对象*/
        DistrictExample districtExample = new DistrictExample();
        List<District> districts = ds.selectByExample(districtExample);
        PageInfo<District> pageInfo = new PageInfo(districts);

        return pageInfo;
    }

    public int addDistrict(District district) {
        return ds.insertSelective(district);
    }
@Transactional/*(propagation = Propagation.REQUIRED)*/
    public int delDistrict(Integer id) {
        ds.deleteStreetByKey(id);
       ds.deleteByPrimaryKey(id);
       return 1;
    }

    public District findDistrictById(Integer id) {
        return ds.selectByPrimaryKey(id);
    }

    public int delDistricts(Integer[] ids) {
        int is=0;
      for(Integer i:ids){
          if (ds.deleteByPrimaryKey(i)==1){
              is++;
          }
      }
        return is;
    }

    public int updateDistrict(District district) {
        return ds.updateByPrimaryKeySelective(district);
    }

    public int deleteDistricts(Integer[] ids) {
        return ds.deleteMoreDistricts(ids);
    }
}
