package cn.kgc.service.impl;

import cn.kgc.entity.Street;
import cn.kgc.entity.StreetExample;
import cn.kgc.mapper.StreetMapper;
import cn.kgc.service.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StreetServiceImpl implements StreetService {
    @Autowired
    private StreetMapper streetMapper;
    @Override
    public List<Street> queryStreetById(Integer id) {
        StreetExample streetExample = new StreetExample();
        StreetExample.Criteria criteria = streetExample.createCriteria();
        criteria.andDistrictIdEqualTo(id);

     return    streetMapper.selectByExample(streetExample);

    }
}
