package cn.weiyin.group07.controller;

import cn.weiyin.group07.pojo.Goods;
import cn.weiyin.group07.pojo.Recommend;
import cn.weiyin.group07.result.Result;
import cn.weiyin.group07.service.RecommendService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recommends")
@CrossOrigin(origins = "*")
public class RecommendController {
    @Autowired
    RecommendService recommendService;
//    添加一条推荐信息
    @PutMapping("/")
    public Result<Object> addRecommend(@RequestBody Recommend recommend) {
        Integer aBoolean = recommendService.addRecommend(recommend);
        if(aBoolean == 1) {
            return Result.success("添加成功");
        }
        else {
            return Result.failed("添加失败");
        }
    }
//    删除一条推荐信息
    @DeleteMapping("/{type}/{goodsId}")
    public Result<Object> deleteRecommend(@PathVariable int type,@PathVariable int goodsId) {
        Integer aBoolean = recommendService.deleteRecommend(type, goodsId);
        if(aBoolean == 1) {
            return Result.success("删除成功");
        }
        else  {
            return Result.failed("删除失败");
        }
    }
//    按照推荐类型查询推荐名单
    @GetMapping("/{type}")
    public Result<List<Goods>> searchByRecommend(@PathVariable int type) {
        List<Goods> goods = recommendService.searchRecommendByType(type);
        return Result.success(goods,"查询完成");
    }
}
