package com.ukyu.excel.read;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;
import com.ukyu.excel.DealExcel;
import com.ukyu.excel.domin.ExcelData;
import com.ukyu.excel.domin.ExcelOut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 模板的读取类
 *
 * @author Jiaju Zhuang
 */
// 有个很重要的点 DemoDataListener 不能被spring管理，要每次读取excel都要new,然后里面用到spring可以构造方法传进去
public class DemoDataListener<T> extends AnalysisEventListener<T> {
    private static final Logger LOGGER = LoggerFactory.getLogger(DemoDataListener.class);

    private static final AtomicInteger at = new AtomicInteger();

    private PrintStream ps;
    /**
     * 每隔5条存储数据库，实际使用中可以3000条，然后清理list ，方便内存回收
     */
    private static final int BATCH_COUNT = 5;
    List<T> list = new ArrayList<>();
    List<ExcelOut> outList = new ArrayList<>(6000);
    /**
     * 假设这个是一个DAO，当然有业务逻辑这个也可以是一个service。当然如果不用存储这个对象没用。
     */
    private DemoDAO<T> demoDAO;

    public DemoDataListener(){
        // 这里是demo，所以随便new一个。实际使用如果到了spring,请使用下面的有参构造函数
        demoDAO = new DemoDAO();
        try {
            ps = new PrintStream("C:\\Users\\ukyu\\Desktop\\outsjx.txt");
        }
        catch (FileNotFoundException e)
        {
            e.getCause();
        }
    }

    /**
     * 如果使用了spring,请使用这个构造方法。每次创建Listener的时候需要把spring管理的类传进来
     *
     * @param demoDAO
     */
    public DemoDataListener(DemoDAO demoDAO) throws FileNotFoundException {
        this.demoDAO = demoDAO;
    }

    /**
     * 这个每一条数据解析都会来调用
     *
     * @param data
     *            one row value. Is is same as {@link AnalysisContext#readRowHolder()}
     * @param context
     */
    @Override
    public void invoke(T data, AnalysisContext context) {
//        LOGGER.info("{} ;解析到一条数据: {}", at.getAndAdd(1), JSON.toJSONString(data));

//        ps.println(at.getAndAdd(1) + " 解析到一条数据:" + JSON.toJSONString(data));
        ExcelData excelData = (ExcelData)data;
        if (excelData.getProdName() == null) {
//            ps.print("商品名称缺失");
            ExcelOut excelOut = new ExcelOut();
            excelOut.setReason("商品名称缺失");
            outList.add(excelOut);
        }
//        ps.println("-----");
        outList.add(null);
        // 达到BATCH_COUNT了，需要去存储一次数据库，防止数据几万条数据在内存，容易OOM
//        if (outList.size() >= BATCH_COUNT) {
            DealExcel.getInstance().writeExcel("C:\\Users\\ukyu\\Desktop\\sjxout.xlsx",
                    outList);
            // 存储完成清理 list
//            outList.clear();
//        }
    }

    /**
     * 所有数据解析完成了 都会来调用
     *
     * @param context
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        // 这里也要保存数据，确保最后遗留的数据也存储到数据库
        saveData();
        LOGGER.info("所有数据解析完成！");
    }

    /**
     * 加上存储数据库
     */
    private void saveData() {
//        LOGGER.info("{}条数据，开始存储数据库！", list.size());
//        demoDAO.save(list);
//        LOGGER.info("存储数据库成功！");
    }
}
