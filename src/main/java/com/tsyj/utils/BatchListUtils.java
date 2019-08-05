package com.tsyj.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tsyj.page.Page;

import java.util.List;
import java.util.function.Consumer;

/**
 * 批量查询工具
 *
 *   demo
     StuCourseService stuCourseService = null;
     // 声明批量查询实例
     Batcher<StuCourse> batcher = (a, b) -> stuCourseService.batchList(a, (StuCourseCond) b);
     // 声明批量处理实例
     Consumer<List<StuCourse>> consumer = t -> {
        for (StuCourse stuCourse : t) {
            System.out.println(stuCourse.getId());
        }
     };
     // 设置查询条件
     StuCourseCond cond = new StuCourseCond();
     // 批量查询并处理
     BatchListUtils.batchProcess(batcher, consumer, cond);
 *
 */
public class BatchListUtils {

    // 每次批量查询最大数
    private final static int MAX_ROW = Page.getMaxRow() - 1;

    public static <R> void batchProcess(Batcher<R> batcher, Consumer<List<R>> consumer, Object cond) {
        int lastId = 0;
        int count;
        if (cond instanceof Page) {
            ((Page) cond).setRow(MAX_ROW);
        }
        List<R> list;
        do {
            list = batcher.list(lastId, cond);
            if (list == null || list.isEmpty()) {
                break;
            }
            count = list.size();
            R lastElement = CollectionUtils.getLastElement(list);
            lastId = getId(lastElement);
            consumer.accept(list);
        } while (count >= MAX_ROW);
    }

    private static int getId(Object lastElement) {
        JSONObject jsonObject = (JSONObject) JSON.toJSON(lastElement);
        return jsonObject.getIntValue("id");
    }

}
