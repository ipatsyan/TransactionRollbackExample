package service;

import dao.UserDao;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by igor on 16.10.2014.
 */
@Service(value = "UserServiceImpl")
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    @Transactional(rollbackFor=Exception.class)
    public void add(User user1, User user2) throws Exception {
        //try to insert 2 rows within the same transaction
        userDao.add(user1);

        //generate SQLException
        if (1 == 1) throw new SQLException("SQLException");

        userDao.add(user2);
    }

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }
}
