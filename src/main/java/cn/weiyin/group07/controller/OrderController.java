package cn.weiyin.group07.controller;

import cn.weiyin.group07.pojo.Orders;
import cn.weiyin.group07.result.Result;
import cn.weiyin.group07.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    OrdersService ordersService;

    @GetMapping("/{userId}")
    public Result<List<Orders>> showOrder(@PathVariable int userId){
        List<Orders> orders = ordersService.showOrder(userId);
        return Result.success(orders,"查询完成");
    }

    @GetMapping("/create/{userId}")
    public Result<Object> createOrder(@PathVariable int userId) {
        Boolean order = ordersService.createOrder(userId);
        if(order) {
            return Result.success("创建成功");
        }
        else {
            return Result.failed("创建失败");
        }
    }
}
