package service.impl;

import mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pojo.NoteBook;
import pojo.User;
import pojo.catalog;
import pojo.showingBooksInfo;
import service.UserService;
import util.SqlSessionFactoryUtil;

import java.util.List;

public class UserServiceImpl implements UserService {
    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory();

    @Override
    public void regist(User user,String checkName) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.regist(user,checkName);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public int totalCount() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int ttc = mapper.totalCount();
        sqlSession.close();
        return ttc;
    }

    @Override
    public List<Integer> login(User user) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<Integer> ids = mapper.login(user);
        sqlSession.close();
        return ids;
    }

    @Override
    public List<NoteBook> searchById(int id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<NoteBook> noteBooks = mapper.searchById(id);
        sqlSession.close();
        return noteBooks;
    }

    @Override
    public void addBooks(String bookName, int userid) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.addBooks(bookName, userid);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void deleteBooks(String bookId, String bookName) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.deleteBooks(bookId,bookName);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public List<catalog> searchCatalog(int bookid) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<catalog> catalogs = mapper.searchCatalog(bookid);
        sqlSession.close();
        return catalogs;
    }

    @Override
    public String searchContentByCId(int c_id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        String s = mapper.searchContentByCId(c_id);
        sqlSession.close();
        return s;

    }

    @Override
    public void save(int c_id, String title, String content) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.save(c_id, title, content);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void addCatalog(int bookid) {

        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.addCatalog(bookid);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void deleteCatalog(int c_id) {

        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.deleteCatalog(c_id);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public List<showingBooksInfo> showBooks() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<showingBooksInfo> showingBooksInfos = mapper.showBooks();
        sqlSession.close();
        return showingBooksInfos;
    }

    @Override
    public List<catalog> showDetail(int bookid) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<catalog> catalogs = mapper.showDetail(bookid);
        sqlSession.close();
        return catalogs;
    }

    @Override
    public List<showingBooksInfo> showBooksByCondition(String s) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<showingBooksInfo> showingBooksInfos = mapper.showBooksByCondition(s);
        sqlSession.close();
        return showingBooksInfos;
    }

    @Override
    public void upload(int bookid, String bookname, int userid, String username, String upload_time, String description, int browse, String classify, String desc_short) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.upload(bookid, bookname, userid, username, upload_time, description, browse, classify, desc_short);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void uploadCatalog(catalog c) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.uploadCatalog(c);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public String searchContentInShowing(int c_id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        String s = mapper.searchContentInShowing(c_id);
        sqlSession.close();
        return s;
    }
}
