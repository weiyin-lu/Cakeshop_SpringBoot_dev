package cn.weiyin.group07.service;

import cn.weiyin.group07.mapper.RecommendMapper;
import cn.weiyin.group07.pojo.Goods;
import cn.weiyin.group07.pojo.Recommend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommendService {
    @Autowired
    RecommendMapper recommendMapper;
//    添加推荐信息，返回添加结果
    public int addRecommend(Recommend inputRecommend) {
        return recommendMapper.insertRecommend(inputRecommend);
    }
//    删除一条推荐信息，返回添加结果
    public int deleteRecommend(int inputType,int inputGoodsId) {
        return recommendMapper.deleteRecommend(inputType,inputGoodsId);
    }
//   按照推荐类型查询推荐名单
    public List<Goods> searchRecommendByType(int type) {
        return recommendMapper.selectGoodsIdByType(type);
    }
}
