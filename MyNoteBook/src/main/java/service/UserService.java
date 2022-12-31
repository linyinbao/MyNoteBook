package service;

import org.apache.ibatis.annotations.Param;
import pojo.NoteBook;
import pojo.User;
import pojo.catalog;
import pojo.showingBooksInfo;

import java.util.List;

public interface UserService {
    void regist(User user,String checkName);

    int totalCount();

    List<Integer> login(User user);

    List<NoteBook> searchById(int id);

    void addBooks(String bookName,int userid);

    void deleteBooks(String bookId,String bookName);

    List<catalog> searchCatalog(int bookid);

    String searchContentByCId(int c_id);

    void save(int c_id,String title,String content);

    void addCatalog(int bookid);

    void deleteCatalog(int c_id);

    List<showingBooksInfo> showBooks();

    List<catalog> showDetail(int bookid);

    List<showingBooksInfo> showBooksByCondition(String s);

    void upload(int bookid,String bookname,int userid,String username,String upload_time, String description,int browse,String classify,String desc_short);

    void uploadCatalog(catalog c);

    String searchContentInShowing(int c_id);

}
