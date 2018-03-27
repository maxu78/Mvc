package com.mx.service;

import com.mx.aop.DataSource;
import com.mx.dao.BaseDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class IndexService {

    @Autowired
    private BaseDAO baseDAO;

    @DataSource()
    public Object index() throws Exception {
        return baseDAO.findForList("userMapper.queryAllUser", null);
    }

    @DataSource(key = "dataSourceTwo")
    public Object index1() throws Exception {
        return baseDAO.findForList("userMapper.queryAllBusi", null);
    }

}
