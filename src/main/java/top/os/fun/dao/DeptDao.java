package top.os.fun.dao;

import org.apache.ibatis.annotations.Param;
import top.os.fun.domain.DeptVO;

import java.util.List;

/**
 * Created by Jacky on 2019-11-24 20:17.
 */
//@Mapper
public interface DeptDao {
    List<DeptVO> queryDeptList();

    int insert(@Param("dname") String dname);
}
