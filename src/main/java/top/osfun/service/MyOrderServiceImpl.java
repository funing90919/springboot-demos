package top.osfun.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import top.osfun.dao.MyOrderDao;
import top.osfun.domain.MyOrderDO;

/**
 * @Description
 * @Auth 01381782 Funing
 * @Date 2019-04-03 10:32
 */
@Service
public class MyOrderServiceImpl implements MyOrderService {

    @Autowired
    private MyOrderDao myOrderDao;

    @Override
    @Transactional
    public void updateMyOrder() {
        MyOrderDO order = myOrderDao.findMyOrderById(1);
        order.setNum(order.getNum() + 1);
        myOrderDao.updateMyOrder(order);
    }
}
