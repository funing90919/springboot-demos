package top.osfun.dao;

import org.apache.ibatis.annotations.Mapper;

import top.osfun.domain.MyOrderDO;

/**
 * @Description
 * @Auth 01381782 Funing
 * @Date 2019-04-03 10:33
 */
@Mapper
public interface MyOrderDao {

   MyOrderDO findMyOrderById(Integer id);

   int updateMyOrder(MyOrderDO order);

}
