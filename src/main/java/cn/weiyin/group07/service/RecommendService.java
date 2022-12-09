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
    public Boolean addRecommend(Recommend inputRecommend) {
        boolean flag = true;
        try  {
            recommendMapper.insertRecommend(inputRecommend);
        }
        catch (Exception e) {
            flag = false;
            e.printStackTrace();
        }
        return flag;
    }
//    删除一条推荐信息，返回添加结果
    public Boolean deleteRecommend(int inputType,int inputGoodsId) {
        boolean flag = true;
        try  {
            recommendMapper.deleteRecommend(inputType,inputGoodsId);
        }
        catch (Exception e) {
            flag = false;
            e.printStackTrace();
        }
        return flag;
    }
//   按照推荐类型查询推荐名单
    public List<Goods> searchRecommendByType(int type) {
        return recommendMapper.selectGoodsIdByType(type);
    }
}
