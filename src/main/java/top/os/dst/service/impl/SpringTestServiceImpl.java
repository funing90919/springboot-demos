package top.os.dst.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.os.dst.dao.SpringTestDao;
import top.os.dst.domain.SpringTestVO;
import top.os.dst.service.SpringTestService;
import top.os.fun.dao.DeptDao;

import java.util.List;
import java.util.UUID;

/**
 * Created by Jacky on 2019-11-24 20:29.
 */
@Service
public class SpringTestServiceImpl implements SpringTestService {

    @Autowired
    private SpringTestDao springTestDao;

    @Autowired
    private DeptDao deptDao;

    @Override
    public PageInfo<SpringTestVO> queryOrderList(Integer startPage, Integer pageSize) {
        Page<SpringTestVO> page = PageHelper.startPage(startPage, pageSize);
        List<SpringTestVO> list = springTestDao.queryspringTestVOList();
        PageInfo<SpringTestVO> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public Boolean insert() {
        int i = UUID.randomUUID().hashCode();
        int insert = springTestDao.insert(i);
        if (insert != 1) {
            return false;
        }
        return true;
    }

    @Override
    @Transactional
    public String insertTwoTable() {
        int i = UUID.randomUUID().hashCode();
        int a = springTestDao.insert(i);
        String name = "Test" + UUID.randomUUID().hashCode();
        int b = deptDao.insert(name);
        int res = a / (b - 1);
        return String.valueOf(res);
    }
}
