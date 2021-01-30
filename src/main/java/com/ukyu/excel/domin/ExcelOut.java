package com.ukyu.excel.domin;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @author ukyu
 * @time 2021/1/30 17:04
 */
@Data
public class ExcelOut {
    @ExcelProperty("不在型号规格表中的原因")
    private String reason;
}
