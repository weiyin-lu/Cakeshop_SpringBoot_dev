package cn.weiyin.group07.mapper;

import cn.weiyin.group07.pojo.Orders;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrdersMapper {

    //根据userId检索order表
    List<Orders> selectByUserId(Integer userId);

}