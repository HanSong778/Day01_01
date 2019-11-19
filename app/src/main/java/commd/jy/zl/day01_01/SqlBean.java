package commd.jy.zl.day01_01;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class SqlBean {
    @Id
    private Long id;
    private String img;
    private String title;
    private String desc;
    @Generated(hash = 1093620735)
    public SqlBean(Long id, String img, String title, String desc) {
        this.id = id;
        this.img = img;
        this.title = title;
        this.desc = desc;
    }
    @Generated(hash = 2066760633)
    public SqlBean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getImg() {
        return this.img;
    }
    public void setImg(String img) {
        this.img = img;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDesc() {
        return this.desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
}
