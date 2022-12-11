package cn.weiyin.group07.mapper;

import cn.weiyin.group07.pojo.Goods;
import cn.weiyin.group07.pojo.Recommend;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RecommendMapper {
//    插入一条记录
    Integer insertRecommend(Recommend recommend);
//    按照type检索goods表的所有数据
    List<Goods> selectGoodsIdByType(Integer type);
//    删除一条记录
    Integer deleteRecommend(@Param("type") Integer type,@Param("goodsId") Integer goodsId);

}