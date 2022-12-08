package cn.weiyin.group07.controller;

import cn.weiyin.group07.pojo.Goods;
import cn.weiyin.group07.result.Result;
import cn.weiyin.group07.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    GoodsService goodsService;

    @GetMapping("/")
    public Result<List<Goods>> showAll() {
        List<Goods> goods = goodsService.showAll();

        return Result.success(goods,"查询完成");

    }
}
