package mapper;

import org.apache.ibatis.annotations.*;
import pojo.NoteBook;
import pojo.User;
import pojo.catalog;
import pojo.showingBooksInfo;

import java.util.List;

public interface UserMapper {


    void regist(@Param("user") User user,@Param("checkName") String checkName);

    @Select("select count(id) from user")
    int totalCount();

    @Select("select id from user where username=#{username} and password=#{password}")
    List<Integer> login(User user);

    @Select("select * from book_manager where userid=#{id}")
    List<NoteBook> searchById(int id);

    @Insert("insert into book_manager (bookid,bookname,userid) values (null,#{book_name},#{userid})")
    void addBooks(@Param("book_name") String bookName,@Param("userid") int userid);


    void deleteBooks(@Param("bookid") String bookId,@Param("bookname") String bookName);

    @Select("select * from catalog_manager where bookid=#{bookid}")
    List<catalog> searchCatalog(int bookid);

    @Select("select content from catalog_manager where c_id=#{c_id}")
    String searchContentByCId(int c_id);

    @Update("update catalog_manager set title=#{title},content=#{content} where c_id=#{c_id}")
    void save(@Param("c_id") int c_id, @Param("title") String title, @Param("content") String content);

    @Insert("insert into catalog_manager(bookid, c_id, title, content) values(#{bookid},null,'新章节',null)")
    void addCatalog(int bookid);

    @Update("delete from catalog_manager where c_id=#{c_id}")
    void deleteCatalog(int c_id);

    @Select("select * from to_show")
    List<showingBooksInfo> showBooks();

    @Select("select * from to_show_catalog where bookid=#{bookid}")
    List<catalog> showDetail(int bookid);

    List<showingBooksInfo> showBooksByCondition(String s);

    @Insert("insert into to_show (bookid, bookname, userid, username, upload_time, description, browse, classify, desc_short) values (#{bookid},#{bookname},#{userid},#{username},#{upload_time},#{description},#{browse},#{classify},#{desc_short})")
    void upload(@Param("bookid") int bookid,@Param("bookname") String bookname,@Param("userid") int userid,@Param("username") String username,@Param("upload_time") String upload_time,@Param("description") String description,@Param("browse") int browse,@Param("classify") String classify,@Param("desc_short") String desc_short);

    @Insert("insert into to_show_catalog (bookid, c_id, title, content) values (#{bookid},null,#{title},#{content})")
    void uploadCatalog(catalog c);

    @Select("select content from to_show_catalog where c_id=#{c_id}")
    String searchContentInShowing(int c_id);
}
