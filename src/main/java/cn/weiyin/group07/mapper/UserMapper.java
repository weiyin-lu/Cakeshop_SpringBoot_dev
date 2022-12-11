package cn.weiyin.group07.mapper;

import cn.weiyin.group07.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
//    向user表添加信息，只包含username、email、password，其他项强制为空字符串和false
    Integer insertUser(User user);
//    检索符合条件的仅一条数据
    User selectUserByEmailAndPassword(@Param("email") String email,@Param("pwd") String pwd);

}
