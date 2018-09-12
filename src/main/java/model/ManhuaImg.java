package model;

import java.io.Serializable;
import java.util.Date;

public class ManhuaImg implements Serializable {
    private Integer id;

    private Integer cid;

    private Date count;

    private String imgurl;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Date getCount() {
        return count;
    }

    public void setCount(Date count) {
        this.count = count;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }
}