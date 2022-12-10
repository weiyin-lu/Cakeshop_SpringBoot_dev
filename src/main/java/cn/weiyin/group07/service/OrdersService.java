package cn.weiyin.group07.service;

import cn.weiyin.group07.mapper.OrdersMapper;
import cn.weiyin.group07.pojo.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersService {
    @Autowired
    OrdersMapper ordersMapper;
//    查询用户的所有订单
    public List<Orders> showOrder(int inputUserId){
        List<Orders> orders = ordersMapper.selectByUserId(inputUserId);
        return orders;
    }

}
