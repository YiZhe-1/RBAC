package com.huike.util;

import lombok.Data;

/**
 * @author jy
 * @version 1.0
 * @date 2022/2/10 20:24
 */
@Data
public class ReturnObject {
    private boolean success;
    private String msg;

    public ReturnObject() {
    }

    public ReturnObject(boolean success,String msg) {
        this.success = success;
        this.msg = msg;
    }

}
