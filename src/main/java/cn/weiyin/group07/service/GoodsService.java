package cn.weiyin.group07.service;

import cn.weiyin.group07.mapper.GoodsMapper;
import cn.weiyin.group07.pojo.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsService {
    @Autowired
    GoodsMapper goodsMapper;
//    展示所有商品
    public List<Goods> showAll() {
        return goodsMapper.selectAll();
    }
//    按类型查看商品
    public List<Goods> searchById(int id) {
        return goodsMapper.selectById(id);
    }
//    按商品id查看商品
    public List<Goods> searchByTypeId(int id) {
        return goodsMapper.selectBytypeId(id);
    }
}
