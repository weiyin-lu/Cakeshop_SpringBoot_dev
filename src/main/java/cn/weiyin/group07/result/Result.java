package cn.weiyin.group07.result;

import lombok.Data;

@Data
public class Result<T> {
    private Boolean flag;
    private T result;
    private String msg = "default";

    /**
     * 响应成功结果集，对象及其反馈消息
     * @param obj 任意响应对象
     * @param msg 响应消息
     * @return 结果集
     * @param <T> 当前controller类需要返回的类型
     */
    public static <T> Result<T> success(T obj,String msg) {
        Result<T> tResult = new Result<>();
        tResult.result = obj;
        tResult.msg = msg;
        tResult.flag = true;
        return tResult;
    }

    /**
     * 只响应消息，用于无需结果集的响应
     * @param msg 响应消息
     * @return 结果集
     * @param <T> 当前controller类需要返回的类型
     */
    public static <T> Result<T> success(String msg) {
        return Result.success(null,msg);
    }

    /**
     * 响应失败结果集
     * @param msg 响应消息
     * @return 结果集
     * @param <T> 当前controller类需要返回的类型
     */
    public static <T> Result<T> failed(String msg) {
        Result<T> tResult = new Result<>();
        tResult.result = null;
        tResult.msg = msg;
        tResult.flag = false;
        return tResult;
    }
}
