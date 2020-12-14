package com.tsyj.binlog.watcher;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.tsyj.annotation.MysqlWatcher;
import com.tsyj.listener.IMysqlDataListener;
import com.tsyj.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@MysqlWatcher(hostName = "test-db", database = "tsyj", table = "user")
public class TestTable1Watcher implements IMysqlDataListener<User> {

    private Logger logger = LoggerFactory.getLogger(TestTable1Watcher.class);

    @Override
    public void onUpdate(User from, User to) {
        logger.info("ID 为 {} 的条目数据变更", from.getId());
        logger.info("\t变化前:" + JSON.toJSONString(from, SerializerFeature.WriteDateUseDateFormat));
        logger.info("\t变化后:" + JSON.toJSONString(to, SerializerFeature.WriteDateUseDateFormat));
    }

    @Override
    public void onInsert(User data) {
        logger.info("插入ID为 {} 的数据", data.getId());
    }

    @Override
    public void onDelete(User data) {
        logger.info("ID 为 {} 的数据被删除", data.getId());
    }
}
