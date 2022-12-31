package pojo;

public class catalog {

    private int bookid;
    private int c_id;
    private String title;
    private String content;

    public catalog() {
    }

    public int getBookid() {
        return bookid;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "catalog{" +
                "bookid=" + bookid +
                ", c_id=" + c_id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
