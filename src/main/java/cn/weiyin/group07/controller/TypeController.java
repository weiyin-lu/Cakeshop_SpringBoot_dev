package cn.weiyin.group07.controller;

import cn.weiyin.group07.pojo.Type;
import cn.weiyin.group07.result.Result;
import cn.weiyin.group07.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/type")
public class TypeController {

    @Autowired
    TypeService typeService;

    @GetMapping("/{id}")
    public Result<String> searchTypeName(@PathVariable int id) {
        String s = typeService.searchTypeNameById(id);

        return Result.success(s,"查询完成");
    }

    @GetMapping("/")
    public Result<List<Type>> searchAllTypeName() {
        List<Type> types = typeService.showAllType();
        return Result.success(types,"查询完成");
    }
}