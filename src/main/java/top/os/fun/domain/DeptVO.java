package top.os.fun.domain;

import java.io.Serializable;

/**
 * Created by Jacky on 2019-11-24 20:12.
 */
public class DeptVO implements Serializable {
    private Long deptno;
    private String dname;
    private String dbSource;
    private Integer dbversion;

    public Long getDeptno() {
        return deptno;
    }

    public void setDeptno(Long deptno) {
        this.deptno = deptno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getDbSource() {
        return dbSource;
    }

    public void setDbSource(String dbSource) {
        this.dbSource = dbSource;
    }

    public Integer getDbversion() {
        return dbversion;
    }

    public void setDbversion(Integer dbversion) {
        this.dbversion = dbversion;
    }
}
