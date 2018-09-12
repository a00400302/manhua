package ServicesInterface;

import model.User;

import java.util.List;

public interface UserService {

    public List<User> login(User user)throws Exception;

    public int register(User user) throws  Exception;

    public int updateUserInfo(User user) throws Exception;

    public int deleteUser(Integer id) throws Exception;

    public User selectUserByid(Integer id) throws Exception;
}
