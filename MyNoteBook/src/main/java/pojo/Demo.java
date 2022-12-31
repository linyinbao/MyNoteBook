package pojo;

public class Demo {
    public static void main(String[] args) {
        String s = "{\"description\":\"介绍啊啦啦啦啦啦啦阿八八八啊吧啊吧阿巴\",\"delivery\":false,\"type\":[],\"desc_short\":\"这是简介！\",\"classify\":\"计算机\",\"bookid\":1,\"userid\":0,\"bookname\":\"线性代数\",\"username\":\"123\",\"upload_time\":\"2022/11/30\",\"browse\":0}";
        s = s.substring(1,s.length()-1);
        System.out.println(s);

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

    }
}
