package com.ukyu.excel.domin;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author ukyu
 * @time 2021/1/30 10:32
 */
@Data
public class ExcelData {
    @ExcelProperty("注册证号代号")
    private String code;

    @ExcelProperty("注册证名称")
    private String name;

    @ExcelProperty("第二项目号")
    private String secProjectNumber;

    @ExcelProperty("商品名称")
    private String prodName;

    @ExcelProperty("规格")
    private String specification;

    @ExcelProperty("型号")
    private String model;

}
