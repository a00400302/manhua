package Controller;


import Exception.ExampleException;
import ServicesInterface.UserService;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import tools.Tool;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * @author fish
 */
@RequestMapping("/User")
@Controller
public class UserController {


    @Autowired
    private UserService userService;

    /**
     * 登录
     */
    @RequestMapping(value = "/login")
    public String login(User user, HttpSession session) throws Exception {
        List<User> userList = null;
        String password = Tool.md5(user.getPassword());
        if (!"".equals(password) && password != null) {
            user.setPassword(password);
        } else {
            throw new ExampleException("没有输入密码");
        }

        userList = userService.login(user);
        if (userList.size() > 0) {
            user = userList.get(0);
            user.setPassword("");
            session.setAttribute("user", user);
        } else {
            throw new ExampleException("密码错误或用户不存在");
        }
        return "login";
    }

    /**
     * 注册
     */
    @RequestMapping("/register")
    public String register(User user) throws Exception {
        int index = 0;

        String password = Tool.md5(user.getPassword());
        if (!"".equals(password) && password != null) {
            user.setPassword(password);
        }else{
            throw  new ExampleException("没有输入密码");
        }

        index = userService.register(user);
        if (index > 0) {
            //成功跳到登录页面
            return "login";
        } else {
            //失败跳到注册页面
            return "register";
        }
    }

    /**
     * 更新
     */
    @RequestMapping("/updateUserInfo")
    public String updateUserInfo(User user, MultipartFile userimg) throws ExampleException {
        int index = 0;

        //上传的头像的本地磁盘存储路径
        String localPath = "D:\\upload\\";
        /**
         获取原图片的路径
         */
        //旧头像的路径
        String oldFilePath = "";
        try {
            User user1 = userService.selectUserByid(user.getId());
            String oldfilename = user1.getUserimg();
            //截取图片保存在数据库的名字
            oldFilePath = oldfilename.substring(oldfilename.lastIndexOf("/"));
        } catch (Exception e) {
            throw  new ExampleException("上传失败");
        }

        if (userimg != null) {

            //String localPath= request.getSession().getServletContext().getRealPath("/static/images");

            String orginalFileName = userimg.getOriginalFilename();
            String newfileName = UUID.randomUUID() + orginalFileName.substring(orginalFileName.lastIndexOf("."));
            File newFile = new File(localPath + newfileName);
            try {
                System.out.println("图片上传");
                userimg.transferTo(newFile);
                // user图片设置


                String sqlPath = "/static/images/";
                user.setUserimg(sqlPath + newfileName);

            } catch (IOException e) {
                throw  new ExampleException("上传失败");
            }
        }

        try {
            //更新
            index = userService.updateUserInfo(user);
            //删除原头像的本地存储


            //本地路径加上图片名字
            File delFile = new File(localPath + oldFilePath);
            if (delFile.exists() && delFile.isFile()) {
                delFile.delete();
            }
        } catch (Exception e) {
            throw  new ExampleException("上传失败");
        }
        if (index > 0) {
            return "";
        } else {
            return "";
        }
    }

    /**
     * 注销
     */
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "login";
    }
}
