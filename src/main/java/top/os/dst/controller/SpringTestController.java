package top.os.dst.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.os.dst.domain.SpringTestVO;
import top.os.dst.service.SpringTestService;

/**
 * Created by Jacky on 2019-11-24 20:20.
 */
@RestController
@RequestMapping("/test")
public class SpringTestController {

    @Autowired
    private SpringTestService springTestService;

    @GetMapping("/list/{startPage}/{pageSize}")
    public PageInfo<SpringTestVO> query(@PathVariable Integer startPage, @PathVariable Integer pageSize) {
        return springTestService.queryOrderList(startPage, pageSize);
    }

    @GetMapping("/insert")
    public Boolean insert() {
        return springTestService.insert();
    }

    @GetMapping("/two")
    public String insertTwoTable() {
        return springTestService.insertTwoTable();
    }
}
