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

    @GetMapping("/goods/{userId}")
    public Result<List<Goods>> showShopCarGoods(@PathVariable int userId) {

        return null;
    }

    @GetMapping("/{userId}")
    public Result<List<ShopCar>> showShopCar(@PathVariable int userId) {

        return null;
    }

    @GetMapping("/{userId}/{goodsId}")
    public Result<Object> addShopCar(@PathVariable int userId,@PathVariable int goodsId) {
        Boolean aBoolean = shopCarService.addShopCar(userId, goodsId);
        if(aBoolean) {
            return Result.success("插入完成");
        }
        else {
            return Result.failed("插入失败");
        }
    }
}
