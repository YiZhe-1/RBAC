package com.huike.query;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author jy
 * @version 1.0
 * @date 2022/2/12 18:06
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class HistoryQuery extends QueryObject{

    private String keyword;
    /**
     * 跟进类型(只有潜在客户和资源池客户),去customer表查
     */
    private Integer type;
}
