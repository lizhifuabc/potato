package com.commom.core.base;

/**
 * 返回码
 *
 * @author lizhifu
 * @date 2021/9/14
 */
public enum ReturnCode {
    SYSTEM_ERROR(503, "服务器错误"),
    PARAM_ERROR(400, "参数错误"),
    SUCCESS(200, "成功"),
    UNAUTHORIZED(401, "未授权"),
    NOT_FOUND(404,"URL不存在");

    /** 枚举值 */
    private final Integer code;
    /** 枚举描述 */
    private final String msg;
    /**
     * 构造方法
     * @param code
     * @param msg
     */
    ReturnCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    /**
     * 通过code获取msg
     *
     * @param code 枚举值
     * @return
     */
    public static String getMsgByCode(Integer code) {
        if (code == null) {
            return null;
        }
        ReturnCode enumList = getByCode(code);
        if (enumList == null) {
            return null;
        }
        return enumList.getMsg();
    }

    /**
     * 获得枚举
     * values() 方法将枚举转变为数组
     * @return AuthGradeEnum
     */
    public static ReturnCode getByCode(Integer code) {
        for (ReturnCode enumList : values()) {
            if (enumList.getCode().equals(code)) {
                return enumList;
            }
        }
        return null;
    }
    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
