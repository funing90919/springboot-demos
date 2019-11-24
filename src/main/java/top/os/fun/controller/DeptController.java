package top.os.fun.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.os.fun.domain.DeptVO;
import top.os.fun.service.DeptService;

/**
 * Created by Jacky on 2019-11-24 20:20.
 */
@RestController
@RequestMapping("/dept")
public class DeptController {

    @Autowired
    private DeptService deptService;

    @GetMapping("/list/{startPage}/{pageSize}")
    public PageInfo<DeptVO> query(@PathVariable Integer startPage, @PathVariable Integer pageSize) {
        return deptService.queryDeptList(startPage, pageSize);
    }

    @GetMapping("/insert")
    public Boolean insert() {
        return deptService.insert();
    }
}
