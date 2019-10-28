package cn.kgc.service;

import cn.kgc.entity.Street;

import java.util.List;

public interface StreetService {
    /**
     * 通过区域id查询街道
     * @param id
     * @return
     */
    List<Street> queryStreetById(Integer id);
}
