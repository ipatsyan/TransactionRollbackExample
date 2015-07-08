package service;

import entity.User;
import java.util.List;

/**
 * Created by igor on 16.10.2014.
 */
public interface UserService {
    public void add(User user1, User user2) throws Exception;
    public List<User> getAll();
}
