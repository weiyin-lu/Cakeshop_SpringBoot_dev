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
    Integer insertShopCar(Integer userId, Integer goodsId);
//    根据id更新amount字段
    Integer updateShopCar(Integer shopCarId,Integer amount);
//    根据id删除记录
    Integer deleteShopCar(Integer shopCarId);
//    根据userId删除记录
    Integer deleteShopCarUserAll(Integer userId);
//    删除amount字段小于等于0的记录
    Integer deleteShopCarByAmount();

}

