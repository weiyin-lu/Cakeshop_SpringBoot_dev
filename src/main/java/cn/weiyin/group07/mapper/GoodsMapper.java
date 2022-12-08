package cn.weiyin.group07.mapper;

import cn.weiyin.group07.pojo.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface GoodsMapper {
//    检索表中所有数据
    @Select("select * from goods")
    List<Goods> selectAll();

//    按typeid检索goods表
    List<Goods> selectBytypeId(Integer id);
}
