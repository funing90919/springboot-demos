package top.os.dst.service;

import com.github.pagehelper.PageInfo;
import top.os.dst.domain.SpringTestVO;

/**
 * Created by Jacky on 2019-11-24 20:27.
 */
public interface SpringTestService {
    PageInfo<SpringTestVO> queryOrderList(Integer startPage, Integer pageSize);

    Boolean insert();

    String insertTwoTable();
}
