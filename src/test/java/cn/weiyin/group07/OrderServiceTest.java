package cn.weiyin.group07;

import cn.weiyin.group07.mapper.OrdersMapper;
import cn.weiyin.group07.pojo.Orders;
import cn.weiyin.group07.service.OrdersService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OrderServiceTest {
    @Autowired
    OrdersService ordersService;

    @Autowired
    OrdersMapper ordersMapper;

    @Test
    public void createOrderTest() {
        Orders orders = new Orders();
        orders.setUserId(2);
        ordersMapper.insertOrders(orders);
        System.out.println(orders);
    }
    @Test
    public void createOrderTest2() {
        ordersService.createOrder(1);
    }
}
