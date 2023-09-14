package com.huike.query;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author jy
 * @version 1.0
 * @date 2022/2/8 18:48
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CustomerQuery extends QueryObject{

    private String keyword;
    private Long status;
    private Integer groupType=0;
    private Long sellerId;
    private String dateBegin;
    private String dateEnd;
}
