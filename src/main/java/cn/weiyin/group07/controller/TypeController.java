package cn.weiyin.group07.controller;

import cn.weiyin.group07.pojo.Type;
import cn.weiyin.group07.result.Result;
import cn.weiyin.group07.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/types")
@CrossOrigin(origins = "*")
public class TypeController {

    @Autowired
    TypeService typeService;

    @GetMapping("/{id}")
    public Result<String> searchTypeName(@PathVariable int id) {
        String s = typeService.searchTypeNameById(id);

        return Result.success(s,"查询完成");
    }
//    查询整个type的id和名字对照表
    @GetMapping("/")
    public Result<List<Type>> searchAllTypeName() {
        List<Type> types = typeService.showAllType();
        return Result.success(types,"查询完成");
    }
}
