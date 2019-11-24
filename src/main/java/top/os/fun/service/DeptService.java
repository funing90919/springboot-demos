package top.os.fun.service;

import com.github.pagehelper.PageInfo;
import top.os.fun.domain.DeptVO;

/**
 * Created by Jacky on 2019-11-24 20:14.
 */
public interface DeptService {

    PageInfo<DeptVO> queryDeptList(Integer startPage, Integer pageSize);

    Boolean insert();
}
