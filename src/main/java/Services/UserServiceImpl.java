package Services;


import ServicesInterface.UserService;
import dao.UserMapper;
import model.User;
import model.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    /*
    *登录
     */
    public List<User> login(User user) throws Exception {
        System.out.println("=====UserServiceImpl.login()=====");

        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernameEqualTo(user.getUsername());
        criteria.andPasswordEqualTo(user.getPassword());

        List<User> userList=new ArrayList<User>();

        userList=userMapper.selectByExample(userExample);

        return userList;

    }


    @Override
    public int register(User user) throws Exception {
        System.out.println("=====UserServiceImpl.register()=====");

        int index=0;
        index=userMapper.insert(user);//可能抛出插入失败异常，用户名重名
        return index;
    }

    @Override
    public int updateUserInfo(User user) throws Exception {
        System.out.println("=====UserServiceImpl.updateInfo()=====");
        int index=0;
        index= userMapper.updateByPrimaryKeySelective(user);
        return index;
    }

    @Override
    public int deleteUser(Integer id) throws Exception {
        System.out.println("=====UserServiceImpl.deleteUser()=====");
        int index=0;
        index =userMapper.deleteByPrimaryKey(id);
        return  index;
    }

    @Override
    public User selectUserByid(Integer id) throws Exception {
        System.out.println("=====UserServiceImpl.selectUserByid()=====");
        User user=null;
        user=userMapper.selectByPrimaryKey(id);
        return  user;
    }
}
