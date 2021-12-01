package service;

import com.jxd.bean.User;
import com.jxd.service.UserService;
import com.jxd.service.impl.UserServiceImpl;
import org.junit.Test;

import java.util.Date;

/**
 * @author jxd
 * @date 2021/11/22 12:06
 */
public class TestUserServiceImpl {
    private UserService usi = new UserServiceImpl();

    @Test
    public void TestLogin(){
        User user = usi.login(new User("1","admin","admin","3434@qq.com","2020-05-02"));
        System.out.println(user.toString());
    }
}
