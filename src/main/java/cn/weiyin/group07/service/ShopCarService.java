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
    public Boolean addShopCar(int inputUserId,int inputGoodsId) {
        boolean flag=true;
        try {
            shopCarMapper.insertShopCar(inputUserId,inputGoodsId);
        }
        catch (Exception e) {
            flag = false;
            e.printStackTrace();
        }
        return flag;
    }
//    修改购物车内容的数量
    public Boolean changeAmount(int inputShopCarId,int amount) {
        boolean flag=true;
        try {
            shopCarMapper.updateShopCar(inputShopCarId,amount);
        }
        catch (Exception e) {
            flag = false;
            e.printStackTrace();
        }
        return flag;
    }
//    删除一条购物车记录
    public Boolean removeShopCar(int inputShopCarId) {
        boolean flag=true;
        try {
            shopCarMapper.deleteShopCar(inputShopCarId);
        }
        catch (Exception e) {
            flag = false;
            e.printStackTrace();
        }
        return flag;
    }
//    清空当前用户购物车
    public Boolean clearShopCar(int inputUserId) {
        boolean flag=true;
        try {
            shopCarMapper.deleteShopCarUserAll(inputUserId);
        }
        catch (Exception e) {
            flag = false;
            e.printStackTrace();
        }
        return flag;
    }
//    清空数量为0的购物车数据
    public Boolean RemoveZero() {
        boolean flag=true;
        try {
            shopCarMapper.deleteShopCarByAmount();
        }
        catch (Exception e) {
            flag = false;
            e.printStackTrace();
        }
        return flag;
    }
}
