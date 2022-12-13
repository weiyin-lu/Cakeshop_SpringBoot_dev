package cn.weiyin.group07.controller;

import cn.weiyin.group07.pojo.Orders;
import cn.weiyin.group07.result.Result;
import cn.weiyin.group07.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@CrossOrigin(origins = "*")
public class OrderController {
    @Autowired
    OrdersService ordersService;
//    查询该用户所有订单
    @GetMapping("/{userId}")
    public Result<List<Orders>> showOrder(@PathVariable int userId){
        List<Orders> orders = ordersService.showOrder(userId);
        return Result.success(orders,"查询完成");
    }
//    把该用户购物车中的所有信息创建成订单
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
//    修改订单发货状态
    @GetMapping("/status/{orderId}/{status}")
    public Result<Object> changeStatus(@PathVariable int orderId,@PathVariable int status) {
        int i = ordersService.changeStatus(orderId, status);
        if(i == 1) {
            return Result.success("修改成功");
        }
        else {
            return Result.failed("修改失败");
        }
    }
//    修改订单支付状态
    @GetMapping("/paytype/{orderId}/{paytype}")
    public Result<Object> changePaytype(@PathVariable int orderId,@PathVariable int paytype) {
        int i = ordersService.changePaytype(orderId, paytype);
        if(i == 1) {
            return Result.success("修改成功");
        }
        else {
            return Result.failed("修改失败");
        }
    }


}
