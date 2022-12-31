package web_servlet;

import com.alibaba.fastjson.JSON;
import pojo.NoteBook;
import pojo.User;
import pojo.catalog;
import pojo.showingBooksInfo;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/user/*")
public class UserServlet extends BaseServlet {
    private UserService userService = new UserServiceImpl();

    public void regist(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //1.接受用户数据
        BufferedReader reader = req.getReader();
        ArrayList<String> a = new ArrayList<>();
        String s = reader.readLine();
        s = s.substring(1, s.length() - 1);
        String info = s.split(",")[0]+","+s.split(",")[1];
        String checkName = s.split(",")[2];
        checkName = checkName.substring(1,checkName.length()-1);

        User user = JSON.parseObject(info, User.class);
        //调用service添加
        userService.regist(user,checkName);
        //返回结果标识
        resp.getWriter().write("success");
    }

    public int totalCount(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer ttc = userService.totalCount();
        String s = ttc.toString();
        resp.getWriter().write(s);
        return ttc;
    }


    public void login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        BufferedReader reader = req.getReader();
        String s = reader.readLine();
        User user = JSON.parseObject(s, User.class);
        List<Integer> ids = userService.login(user);
        if(ids.size() == 1){
            //可以登录
            resp.getWriter().write("success#");
            resp.getWriter().write(ids.get(0).toString());
        }else if(ids.size() == 0){
            resp.getWriter().write("fail");
        }

    }

    public void searchById(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        String s = req.getParameter("id");
//        System.out.println(s);
        resp.setCharacterEncoding("UTF-8");
        BufferedReader reader = req.getReader();
        String id = reader.readLine();
        List<NoteBook> noteBooks = userService.searchById(Integer.valueOf(id));
        String s1 = JSON.toJSONString(noteBooks);
        resp.getWriter().write(s1);


    }
    public void addBooks(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        req.setCharacterEncoding("UTF-8");

        BufferedReader reader = req.getReader();
        String s = reader.readLine();
        s = s.substring(1,s.length()-1);
        String userid = s.split("\"")[2];
        String bookName = s.split("\"")[5];
        userid = userid.substring(1,userid.length()-1);
//        String name = new String(req.getParameter("name").getBytes("iso-8859-1"), "utf-8");
//        String userid = new String(req.getParameter("id").getBytes("iso-8859-1"), "utf-8");
        userService.addBooks(bookName,Integer.valueOf(userid));
        resp.getWriter().write("success");

    }

    public void deleteBooks(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        req.setCharacterEncoding("UTF-8");

        BufferedReader reader = req.getReader();
        String s = reader.readLine();
        s = s.substring(1,s.length()-1);
        String bookId = s.split("\"")[2];
        bookId = bookId.substring(1,bookId.length()-1);
        String bookName = s.split("\"")[5];
        System.out.println(bookId);
        System.out.println(bookName);
        userService.deleteBooks(bookId,bookName);
        resp.getWriter().write("success");

    }

    public void editText(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String bookid = req.getParameter("bookid");
//        String username = req.getParameter("username");
//        String userid = req.getParameter("id");
        List<catalog> catalogs = userService.searchCatalog(Integer.valueOf(bookid));
        String s = JSON.toJSONString(catalogs);
        resp.getWriter().write(s);


    }
    public void editing(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        BufferedReader reader = req.getReader();
        String s = reader.readLine();
        System.out.println(s);
        String content = userService.searchContentByCId(Integer.valueOf(s));
        resp.getWriter().write(content);


    }

    public void editingInDetail(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        BufferedReader reader = req.getReader();
        String s = reader.readLine();
        System.out.println(s);
        String content = userService.searchContentInShowing(Integer.valueOf(s));
        resp.getWriter().write(content);


    }

    public void saveContent(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        BufferedReader reader = req.getReader();

        String s = "";
        String s1 = "";
        while((s1=reader.readLine())!=null){
            if(s1.isEmpty()){
                break;
            }
            s = s + s1 + "\n";

        }
//        String s = reader.readLine()+"\n"+reader.readLine();
        if(s.contains("#")){
            String c_id = s.split("#")[0];
            String title = s.split("#")[1];
            String content = s.split("#")[2];
            userService.save(Integer.valueOf(c_id),title,content);
            System.out.println(content);
            resp.getWriter().write("success");
        }
//        String content = userService.searchContentByCId(Integer.valueOf(s));
//        resp.getWriter().write(content);


    }

    public void addCatalog(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        BufferedReader reader = req.getReader();
        String s = reader.readLine();
        userService.addCatalog(Integer.valueOf(s));



    }

    public void deleteCatalog(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        BufferedReader reader = req.getReader();
        String s = reader.readLine();
        System.out.println(s);
        userService.deleteCatalog(Integer.valueOf(s));
        resp.getWriter().write("success");



    }

    public void showBooks(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        List<showingBooksInfo> showingBooksInfos = userService.showBooks();
        String s = JSON.toJSONString(showingBooksInfos);
        resp.getWriter().write(s);
    }

    public void showDetail(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String s1 = req.getParameter("bookid");
//        BufferedReader reader = req.getReader();
//        String s1 = reader.readLine();
        System.out.println(s1);
        List<catalog> catalogs = userService.showDetail(Integer.valueOf(s1));
        String s = JSON.toJSONString(catalogs);
        resp.getWriter().write(s);
    }

    public void showBooksByCondition(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        BufferedReader reader = req.getReader();
        String s1 = reader.readLine();
        System.out.println(s1);
        List<showingBooksInfo> showingBooksInfos;
        if(s1 != "" && s1 != null){
            showingBooksInfos = userService.showBooksByCondition("%"+s1+"%");
        }else{
            showingBooksInfos = userService.showBooksByCondition(s1);
        }
        String s = JSON.toJSONString(showingBooksInfos);
        resp.getWriter().write(s);
//        List<showingBooksInfo> showingBooksInfos = userService.showBooks();
//        String s = JSON.toJSONString(showingBooksInfos);
//        resp.getWriter().write(s);
    }

    public void upload(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        BufferedReader reader = req.getReader();
        String s = reader.readLine();
        System.out.println(s);
        s = s.substring(1,s.length()-1);

        String description = s.split(":")[1].split(",")[0];
        description = description.substring(1,description.length()-1);
        System.out.println(description);

        String desc_short = s.split(":")[4].split(",")[0];
        desc_short = desc_short.substring(1,desc_short.length()-1);
        System.out.println(desc_short);

        String classify = s.split(":")[5].split(",")[0];
        classify = classify.substring(1,classify.length()-1);
        System.out.println(classify);

        String bookid = s.split(":")[6].split(",")[0];
        System.out.println(bookid);

        String userid = s.split(":")[7].split(",")[0];
        System.out.println(userid);

        String bookname = s.split(":")[8].split(",")[0];
        bookname = bookname.substring(1,bookname.length()-1);
        System.out.println(bookname);

        String username = s.split(":")[9].split(",")[0];
        username = username.substring(1,username.length()-1);
        System.out.println(username);

        String upload_time = s.split(":")[10].split(",")[0];
        upload_time = upload_time.substring(1,upload_time.length()-1);
        System.out.println(upload_time);

        String browse = s.split(":")[11];
        System.out.println(browse);

        userService.upload(Integer.valueOf(bookid),bookname,Integer.valueOf(userid),username,upload_time,description,Integer.valueOf(browse),classify,desc_short);

        resp.getWriter().write("success");
    }

    public void uploadCatalog(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String bookid = req.getParameter("bookid");
        List<catalog> catalogs = userService.searchCatalog(Integer.valueOf(bookid));
//        String s = JSON.toJSONString(catalogs);
//        resp.getWriter().write(s);
        for(catalog c:catalogs){
            userService.uploadCatalog(c);
        }
        resp.getWriter().write("success");


    }
}
