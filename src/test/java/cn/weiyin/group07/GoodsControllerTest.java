package cn.weiyin.group07;

import cn.weiyin.group07.pojo.Goods;
import cn.weiyin.group07.service.GoodsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class GoodsControllerTest {

    @Autowired
    GoodsService goodsService;

    @Test
    public void showAll() {
        List<Goods> goods = goodsService.showAll();
        System.out.println(goods);
    }
}
