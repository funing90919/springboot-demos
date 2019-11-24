package top.os.dst.dao;

import org.apache.ibatis.annotations.Param;
import top.os.dst.domain.SpringTestVO;

import java.util.List;

/**
 * Created by Jacky on 2019-11-24 20:17.
 */
//@Mapper
public interface SpringTestDao {
    List<SpringTestVO> queryspringTestVOList();

    int insert(@Param("num") int num);
}
