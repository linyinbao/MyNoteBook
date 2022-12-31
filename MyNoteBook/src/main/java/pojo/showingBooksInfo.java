package pojo;

public class showingBooksInfo {

    private int bookid;

    private String bookname;
    private int userid;
    private String username;
    private String upload_time;
    private String description;
    private int browse;
    private String classify;
    private String desc_short;

    public showingBooksInfo() {
    }



    public int getBookid() {
        return bookid;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUpload_time() {
        return upload_time;
    }

    public void setUpload_time(String upload_time) {
        this.upload_time = upload_time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getBrowse() {
        return browse;
    }

    public void setBrowse(int browse) {
        this.browse = browse;
    }

    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify;
    }

    public String getDesc_short() {
        return desc_short;
    }

    public void setDesc_short(String desc_short) {
        this.desc_short = desc_short;
    }

    @Override
    public String toString() {
        return "showingBooksInfo{" +
                "bookid=" + bookid +
                ", bookname='" + bookname + '\'' +
                ", userid=" + userid +
                ", username='" + username + '\'' +
                ", upload_time='" + upload_time + '\'' +
                ", description='" + description + '\'' +
                ", browse=" + browse +
                ", classify='" + classify + '\'' +
                ", desc_short='" + desc_short + '\'' +
                '}';
    }
}
