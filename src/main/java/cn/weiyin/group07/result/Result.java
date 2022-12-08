package cn.weiyin.group07.result;

import lombok.Data;

@Data
public class Result<T> {
    private Boolean flag;
    private T result;
    private String msg = "default";

    public static <T> Result<T> success(T obj,String msg) {
        Result<T> tResult = new Result<>();
        tResult.result = obj;
        tResult.msg = msg;
        tResult.flag = true;
        return tResult;
    }

    public static <T> Result<T> success(String msg) {
        return Result.success(null,msg);
    }

    public static <T> Result<T> failed(String msg) {
        Result<T> tResult = new Result<>();
        tResult.result = null;
        tResult.msg = msg;
        tResult.flag = false;
        return tResult;
    }
}
