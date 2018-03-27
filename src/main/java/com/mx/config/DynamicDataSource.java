package com.mx.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DynamicDataSource extends AbstractRoutingDataSource {

    private final static Logger log = LoggerFactory.getLogger(DynamicDataSource.class);
    private static final ThreadLocal<String> dataSourceKey = new InheritableThreadLocal<String>();

    public static void setDataSourceKey(String dataSource) {
        log.info("当前操作使用的数据源：{}", dataSource);
        dataSourceKey.set(dataSource);
    }

    @Override
    protected Object determineCurrentLookupKey() {
        return dataSourceKey.get();
    }

    /**
     * 清除数据源
     */
    public static void clearDataSource() {
        dataSourceKey.remove();
    }
}
