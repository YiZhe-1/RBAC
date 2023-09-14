package com.huike.query;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jy
 * @version 1.0
 * @date 2022/2/7 19:19
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QueryObject {
    /**
     * 当前页
     */
    private int currentPage = 1;

    /**
     * 每页显示的条数
     */
    private int pageSize = 12;
}
