package top.fanaozhe.springboot_log.service;

import org.springframework.stereotype.Service;

/**
 * @author faz
 * @create 2020-12-21-15:21
 */
@Service
public class UserService {
    public String getUserById(Integer id) {
//        int a = 2/0;
        System.out.println("get .......");
        return "user";
    }

    public void deleteUserById(Integer id) {
        System.out.println("delete ......");
    }
}
