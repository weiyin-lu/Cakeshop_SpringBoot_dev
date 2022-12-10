package cn.weiyin.group07.mapper;

import cn.weiyin.group07.pojo.Orders;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrdersMapper {

    //根据userId检索order表
    List<Orders> selectByUserId(Integer userId);

    //根据user表和shopcar表在orders表插入一条记录，id主键字段返回到order类中
    void insertOrders(Orders order);

}