package cn.kgc.service.impl;

import cn.kgc.entity.Type;
import cn.kgc.entity.TypeExample;
import cn.kgc.mapper.TypeMapper;
import cn.kgc.service.TypeService;
import cn.kgc.utils.PageUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    private TypeMapper ds;
    public List<Type> getAllType() {
        return ds.selectByExample(new TypeExample());
    }

    public PageInfo<Type> getTypeByPage(PageUtil pageUtil) {
        PageHelper.startPage(pageUtil.getPage(),pageUtil.getRows());
        /*查询条件实体类对象*/
        TypeExample TypeExample = new TypeExample();
        List<Type> Types = ds.selectByExample(TypeExample);
        PageInfo<Type> pageInfo = new PageInfo(Types);

        return pageInfo;
    }

    public int addType(Type Type) {
        return ds.insertSelective(Type);
    }
@Transactional/*(propagation = Propagation.REQUIRED)*/
    public int delType(Integer id) {
       ds.deleteByPrimaryKey(id);
       return 1;
    }

    public Type findTypeById(Integer id) {
        return ds.selectByPrimaryKey(id);
    }

    public int delTypes(Integer[] ids) {
        int is=0;
      for(Integer i:ids){
          if (ds.deleteByPrimaryKey(i)==1){
              is++;
          }
      }
        return is;
    }

    public int updateType(Type Type) {
        return ds.updateByPrimaryKeySelective(Type);
    }

    public int deleteTypes(Integer[] ids) {
        return ds.deleteMoreTypes(ids);
    }
}
