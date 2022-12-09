package cn.weiyin.group07.mapper;

import cn.weiyin.group07.pojo.Type;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TypeMapper {
//    按照id检索name字段
    String selectTypeNameById(Integer id);
//    查看整个type表
    List<Type> selectAll();

}