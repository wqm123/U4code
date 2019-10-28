package cn.kgc.service;

import cn.kgc.entity.District;
import cn.kgc.utils.PageUtil;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface DistrictService {
    //一功能一方法
    List<District> getAllDistrict();

    PageInfo<District> getDistrictByPage(PageUtil pageUtil);

    /**
     * 添加区域信息
     * @param district
     * @return
     */
    int addDistrict(District district);

    /**
     * 通过id删除
     * @param id
     * @return
     */
    int delDistrict(Integer id);

    /**
     * 通过id查找数据
     * @param id
     * @return
     */
    District findDistrictById(Integer id);

    /**
     * 多项删除
     * @param ids
     * @return
     */
    int delDistricts(Integer[] ids);
    /**
     * 修改
     * @param district
     * @return
     */
    int updateDistrict(District district);

    /**
     * 多项删除
     * @param ids
     * @return
     */
    int deleteDistricts(Integer[] ids);

}
