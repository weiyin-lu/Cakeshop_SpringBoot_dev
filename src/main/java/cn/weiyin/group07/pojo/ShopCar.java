package cn.weiyin.group07.pojo;

import lombok.Data;
//购物车
@Data
public class ShopCar {
    private Integer id;
    private Integer userId;
    private Integer goodsId;
    private Double price;
    private Integer amount;
}
