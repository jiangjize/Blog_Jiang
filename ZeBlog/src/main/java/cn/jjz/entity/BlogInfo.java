package cn.jjz.entity;

/**
 * Created by Administrator on 2017/7/2.
 */
public class BlogInfo {
    private Integer blogId;
    private  String blogAuthor;
    private String blogAddress;
    private Boolean blogDel;
    private String blogPhoto;

    public String getBlogPhoto() {
        return blogPhoto;
    }

    public void setBlogPhoto(String blogPhoto) {
        this.blogPhoto = blogPhoto;
    }

    public Integer getBlogId() {
        return blogId;
    }

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }

    public String getBlogAuthor() {
        return blogAuthor;
    }

    public void setBlogAuthor(String blogAuthor) {
        this.blogAuthor = blogAuthor;
    }

    public String getBlogAddress() {
        return blogAddress;
    }

    public void setBlogAddress(String blogAddress) {
        this.blogAddress = blogAddress;
    }

    public Boolean getBlogDel() {
        return blogDel;
    }

    public void setBlogDel(Boolean blogDel) {
        this.blogDel = blogDel;
    }
}
