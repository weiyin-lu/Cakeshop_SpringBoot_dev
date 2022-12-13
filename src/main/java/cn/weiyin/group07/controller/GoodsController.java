package cn.weiyin.group07.controller;

import cn.weiyin.group07.pojo.Goods;
import cn.weiyin.group07.result.Result;
import cn.weiyin.group07.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/goods")
@CrossOrigin(origins = "*")
public class GoodsController {

    @Autowired
    GoodsService goodsService;
//    展示所有商品
    @GetMapping("/")
    public Result<List<Goods>> showAllGoods() {
        List<Goods> goods = goodsService.showAll();

        return Result.success(goods,"查询完成");
    }
//    按类型查看商品
    @GetMapping("/type/{id}")
    public Result<List<Goods>> searchByTypeId(@PathVariable int id) {
        List<Goods> goods = goodsService.searchByTypeId(id);

        return Result.success(goods,"查询完成");
    }
//    按商品id查看商品
    @GetMapping("/{id}")
    public Result<Goods> searchById(@PathVariable int id) {
        Goods goods = goodsService.searchById(id);

        return Result.success(goods,"查询完成");
    }
}
