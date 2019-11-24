package top.os.dst.domain;

import java.io.Serializable;

/**
 * Created by Jacky on 2019-11-24 20:30.
 */
public class SpringTestVO implements Serializable {
    private Integer id;
    private Integer num;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
