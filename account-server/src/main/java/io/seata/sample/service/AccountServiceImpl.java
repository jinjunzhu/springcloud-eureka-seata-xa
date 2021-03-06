package io.seata.sample.service;

import io.seata.sample.dao.AccountDao;
import io.seata.sample.feign.OrderApi;
import java.math.BigDecimal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author IT云清
 */
@Service("accountServiceImpl")
public class AccountServiceImpl implements AccountService{

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountServiceImpl.class);
    @Autowired
    private AccountDao accountDao;
    @Autowired
    private OrderApi orderApi;

    /**
     * 扣减账户余额
     * @param userId 用户id
     * @param payAmount 金额
     */
    @Override
    public void decrease(Long userId, BigDecimal payAmount) {
        LOGGER.info("------->扣减账户开始account中");
        //模拟超时异常，全局事务回滚
        /*try {
            Thread.sleep(30*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        accountDao.decrease(userId,payAmount);
        LOGGER.info("------->扣减账户结束account中");
    }
}
