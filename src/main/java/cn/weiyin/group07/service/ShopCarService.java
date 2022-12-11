package cn.weiyin.group07.service;

import cn.weiyin.group07.mapper.ShopCarMapper;
import cn.weiyin.group07.pojo.Goods;
import cn.weiyin.group07.pojo.ShopCar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopCarService {
    @Autowired
    ShopCarMapper shopCarMapper;
//    查询当前用户的购物车内物品信息
    public List<Goods> showShopCarGoodsInfo(int inputUserId) {
        List<Goods> goods = shopCarMapper.selectGoodsByUserId(inputUserId);
        return goods;
    }
//    查询当前用户购物车基本信息
    public List<ShopCar> showShopCarInfo(int inputUserId) {
        List<ShopCar> shopCars = shopCarMapper.selectByUserId(inputUserId);
        return shopCars;
    }
//    添加购物车信息
    public int addShopCar(int inputUserId,int inputGoodsId) {
        return shopCarMapper.insertShopCar(inputUserId,inputGoodsId);
    }
//    修改购物车内容的数量
    public int changeAmount(int inputShopCarId,int amount) {
        return shopCarMapper.updateShopCar(inputShopCarId,amount);
    }
//    删除一条购物车记录
    public int removeShopCar(int inputShopCarId) {
        return shopCarMapper.deleteShopCar(inputShopCarId);
    }
//    清空当前用户购物车
    public int clearShopCar(int inputUserId) {
        return shopCarMapper.deleteShopCarUserAll(inputUserId);
    }
//    清空数量为0的购物车数据
    public int removeZero() {
        return shopCarMapper.deleteShopCarByAmount();
    }
}
