package com.spring11.service.impl;

import com.spring11.dao.AccountDao;
import com.spring11.entity.Account;
import com.spring11.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * (Account)表服务实现类
 *
 * @author makejava
 * @since 2022-05-06 08:23:34
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Autowired
    private TransactionTemplate transactionTemplate;

    @Autowired
    private DataSourceTransactionManager transactionManager;

    @Override
    public void transfer(Integer from, Integer to, Double money) {
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                accountDao.decreaseMoney(from, money);
//                int num=1/0;
                accountDao.increaseMoney(to, money);
            }
        });
    }

    /**
     * 声明式事务
     */
    @Override
    public void trans(Integer from, Integer to, Double money) {
        DefaultTransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
        TransactionStatus status = transactionManager.getTransaction(transactionDefinition);
        try {
            accountDao.decreaseMoney(from, money);
            int a=1/0;
            accountDao.increaseMoney(to, money);
            transactionManager.commit(status);
        } catch (Exception e) {
            transactionManager.rollback(status);
            throw e;
        }
    }
}
