package cn.weiyin.group07.mapper;

import cn.weiyin.group07.pojo.Orderitem;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.core.annotation.Order;

@Mapper
public interface OrderitemMapper {
//    向orderitem表插入数据
    void insertOrderitem(Orderitem orderitem);

//    查询order_id匹配的orderitem数据
    List<Orderitem> selectOrderitemAll(Integer OrderId);

}