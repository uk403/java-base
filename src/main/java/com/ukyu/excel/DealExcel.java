package com.ukyu.excel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.ukyu.excel.domin.ExcelData;
import com.ukyu.excel.domin.ExcelOut;
import com.ukyu.excel.read.DemoDataListener;

import java.util.List;

/**
 * excel
 * @author ukyu
 * @time 2021/1/30 10:04
 */
public class DealExcel<T> {
    public static void main(String[] args) {
        String fileName = "C:\\Users\\ukyu\\Desktop\\sjx.xlsx";
        EasyExcel.read(fileName, ExcelData.class, new DemoDataListener<ExcelData>()).sheet().doRead();

    }

    private DealExcel(){

    }

    private static DealExcel dealExcel;

    public static DealExcel getInstance(){
        if(dealExcel == null)
        {
            dealExcel = new DealExcel();
        }
        return dealExcel;
    }

    public void writeExcel(String fileName, List<T> data){
        // 这里 需要指定写用哪个class去写
        ExcelWriter excelWriter = null;
        try {
            excelWriter = EasyExcel.write(fileName, ExcelOut.class).build();
            WriteSheet writeSheet = EasyExcel.writerSheet("sjxout").build();
            excelWriter.write(data, writeSheet);
        } finally {
            // 千万别忘记finish 会帮忙关闭流
            if (excelWriter != null) {
                excelWriter.finish();
            }
        }
    }
}
