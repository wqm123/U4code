package cn.kgc.service;

import cn.kgc.entity.Type;
import cn.kgc.utils.PageUtil;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface TypeService {
    //一功能一方法
    List<Type> getAllType();

    PageInfo<Type> getTypeByPage(PageUtil pageUtil);

    /**
     * 添加区域信息
     * @param Type
     * @return
     */
    int addType(Type Type);

    /**
     * 通过id删除
     * @param id
     * @return
     */
    int delType(Integer id);

    /**
     * 通过id查找数据
     * @param id
     * @return
     */
    Type findTypeById(Integer id);

    /**
     * 多项删除
     * @param ids
     * @return
     */
    int delTypes(Integer[] ids);
    /**
     * 修改
     * @param Type
     * @return
     */
    int updateType(Type Type);

    /**
     * 多项删除
     * @param ids
     * @return
     */
    int deleteTypes(Integer[] ids);

}
