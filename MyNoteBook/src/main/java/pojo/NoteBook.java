package pojo;

public class NoteBook {

    private int bookid;
    private String bookname;
    private int userid;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
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

    public NoteBook() {
    }

    @Override
    public String toString() {
        return "NoteBook{" +
                "bookid=" + bookid +
                ", bookname='" + bookname + '\'' +
                ", userid=" + userid +
                '}';
    }
}
