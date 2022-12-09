package cn.weiyin.group07.service;

import cn.weiyin.group07.mapper.TypeMapper;
import cn.weiyin.group07.pojo.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeService {
    @Autowired
    TypeMapper typeMapper;
//    查看分类名
    public String searchTypeNameById(int id) {
        return typeMapper.selectTypeNameById(id);
    }
//    查看所有分类名
    public List<Type> showAllType() {
        return typeMapper.selectAll();
    }
}
