package com.mybatis.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.datasource.unpooled.UnpooledDataSourceFactory;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author bai
 * @version V1.0
 * @Package com.mybatis.datasource
 * @date 2022/3/23 22:44
 * @describe druid数据源(阿里巴巴)
 */
public class DruidDataSourceFactory extends UnpooledDataSourceFactory {
    public DruidDataSourceFactory() {
        this.dataSource = new DruidDataSource();
    }

    @Override
    public DataSource getDataSource() {
        //初始化
        try {
            ((DruidDataSource) this.dataSource).init();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return this.dataSource;
    }
}
