package cn.weiyin.group07.mapper;

import cn.weiyin.group07.pojo.Goods;
import cn.weiyin.group07.pojo.ShopCar;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ShopCarMapper {
//    查询userId匹配且goodsID匹配的所有goods表字段
    List<Goods> selectGoodsByUserId(Integer userId);
//    查询userId匹配的shopcar表字段
    List<ShopCar> selectByUserId(Integer userId);
//    插入字段,amount为1，价格数据从goods表获得
    void insertShopCar(Integer userId, Integer goodsId);
//    根据userId和goodsId更新amount字段
    void updateShopCar(Integer userId,Integer goodsId,Integer amount);
//    根据userId和goodsId删除记录
    void deleteShopCar(Integer userId,Integer goodsId);
//    根据userId删除记录
    void deleteShopCarUserAll(Integer userId);
//    删除amount字段为0的记录
    void deleteShopCarByAmount();

}

