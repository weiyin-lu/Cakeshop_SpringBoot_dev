package cn.weiyin.group07.service;

import cn.weiyin.group07.mapper.TypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeService {
    @Autowired
    TypeMapper typeMapper;
//    查看分类名
    public String searchTypeNameById(int id) {
        return typeMapper.selectTypeNameById(id);
    }
}
