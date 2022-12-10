package cn.weiyin.group07.service;

import cn.weiyin.group07.mapper.OrderitemMapper;
import cn.weiyin.group07.mapper.OrdersMapper;
import cn.weiyin.group07.mapper.ShopCarMapper;
import cn.weiyin.group07.pojo.Goods;
import cn.weiyin.group07.pojo.Orderitem;
import cn.weiyin.group07.pojo.Orders;
import cn.weiyin.group07.pojo.ShopCar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class OrdersService {
    @Autowired
    OrdersMapper ordersMapper;
    @Autowired
    OrderitemMapper orderitemMapper;
    @Autowired
    ShopCarMapper shopCarMapper;

//    查询用户的所有订单
    public List<Orders> showOrder(int inputUserId){
        List<Orders> orders = ordersMapper.selectByUserId(inputUserId);
        return orders;
    }

//    从购物车创建新订单
    public Boolean createOrder(int inputUserId) {
        boolean flag = true;
        try{
//            构造order类，接收插入方法传回的订单id
            Orders inputOrderInfo = new Orders();
            inputOrderInfo.setUserId(inputUserId);

//            创建并插入订单总表信息
            ordersMapper.insertOrders(inputOrderInfo);

//            从购物车获得用户当前创建订单的商品信息
            List<ShopCar> shopCars = shopCarMapper.selectByUserId(inputUserId);

//            遍历器
            Iterator<ShopCar> iterator = shopCars.iterator();

//            将购物车信息循环写入orderitem
            while(iterator.hasNext()) {
//                购物车中的个体对象
                ShopCar car = iterator.next();
//                构造orderitem对象
                Orderitem orderitem = new Orderitem();
                orderitem.setOrderId(inputOrderInfo.getId());
                orderitem.setPrice(car.getPrice());
                orderitem.setAmount(car.getAmount());
                orderitem.setGoodsId(car.getGoodsId());
//                执行插入命令
                orderitemMapper.insertOrderitem(orderitem);
            }

//            以上全部执行完毕，清空购物车
            shopCarMapper.deleteShopCarUserAll(inputUserId);
        }
        catch (Exception e) {
            flag = false;
            e.printStackTrace();
        }
        return flag;

    }

}
