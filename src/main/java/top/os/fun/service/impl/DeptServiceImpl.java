package top.os.fun.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.os.fun.dao.DeptDao;
import top.os.fun.domain.DeptVO;
import top.os.fun.service.DeptService;

import java.util.UUID;

/**
 * Created by Jacky on 2019-11-24 20:16.
 */
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptDao deptDao;

    @Override
    public PageInfo<DeptVO> queryDeptList(Integer startPage, Integer pageSize) {
        Page<DeptVO> page = PageHelper.startPage(startPage, pageSize);
        deptDao.queryDeptList();
        PageInfo<DeptVO> pageInfo = new PageInfo<>(page);
        return pageInfo;
    }

    @Override
    public Boolean insert() {
        String name = "Test" + UUID.randomUUID().hashCode();
        int insert = deptDao.insert(name);
        if (insert != 1) {
            return false;
        }
        return true;
    }

}
