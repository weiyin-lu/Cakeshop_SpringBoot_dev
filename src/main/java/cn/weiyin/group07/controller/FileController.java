package cn.weiyin.group07.controller;

import cn.weiyin.group07.result.Result;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//文件上传用模块
@RestController
@RequestMapping("/file")
@CrossOrigin(origins = "*")
public class FileController {
//    文件上传
    @PostMapping("/")
    public Result<Object> fileUpLoad(@RequestBody MultipartFile file) {
        String originalFilename = file.getOriginalFilename();
        try {
            FileOutputStream stream = new FileOutputStream("src/main/resources/static/picture" + originalFilename);
            stream.write(file.getBytes());
            stream.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException("上传失败，找不到文件");
        } catch (IOException e) {
            throw new RuntimeException("上传失败，写入错误");
        }
        return Result.success("上传成功");
    }

}
