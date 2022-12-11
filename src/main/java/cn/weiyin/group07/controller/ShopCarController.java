package cn.weiyin.group07.controller;

import cn.weiyin.group07.pojo.Goods;
import cn.weiyin.group07.pojo.ShopCar;
import cn.weiyin.group07.result.Result;
import cn.weiyin.group07.service.GoodsService;
import cn.weiyin.group07.service.ShopCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shopcars")
public class ShopCarController {
    @Autowired
    ShopCarService shopCarService;
//    查看购物车商品
    @GetMapping("/goods/{userId}")
    public Result<List<Goods>> showShopCarGoods(@PathVariable int userId) {
        List<Goods> goods = shopCarService.showShopCarGoodsInfo(userId);
        return Result.success(goods,"查询完成");
    }
//    查看购物车
    @GetMapping("/{userId}")
    public Result<List<ShopCar>> showShopCar(@PathVariable int userId) {
        List<ShopCar> shopCars = shopCarService.showShopCarInfo(userId);
        return Result.success(shopCars,"查询完成");
    }
//    增加购物车条目
    @PutMapping("/{userId}/{goodsId}")
    public Result<Object> addShopCar(@PathVariable int userId,@PathVariable int goodsId) {
        int aBoolean = shopCarService.addShopCar(userId, goodsId);
        if(aBoolean == 1) {
            return Result.success("插入完成");
        }
        else {
            return Result.failed("插入失败");
        }
    }

//    修改数量
    @GetMapping("/{shopCarId}/{amount}")
    public Result<Object> changeAmount(@PathVariable int shopCarId,@PathVariable int amount) {
//        执行商品数量的修改
        int aBoolean = shopCarService.changeAmount(shopCarId, amount);
//        检查一次已经归零的购物车信息，将其删除
        shopCarService.removeZero();
        if(aBoolean == 1) {
            return Result.success("增加完成");
        }
        else {
            return Result.failed("增加失败");
        }
    }

//    删除购物车记录
    @DeleteMapping("/{shopCarId}")
    public Result<Object> removeCarGoods(@PathVariable int shopCarId) {
        int aBoolean = shopCarService.removeShopCar(shopCarId);
        if(aBoolean == 1) {
            return Result.success("删除成功");
        }
        else {
            return Result.failed("删除失败");
        }
    }

//    清空购物车
    @DeleteMapping("/clear/{userId}")
    public Result<Object> clearCar(@PathVariable int userId) {
        int aBoolean = shopCarService.clearShopCar(userId);
        if(aBoolean != 0) {
            return Result.success("清空成功");
        }
        else {
            return Result.failed("购物车已经为空");
        }
    }
}
