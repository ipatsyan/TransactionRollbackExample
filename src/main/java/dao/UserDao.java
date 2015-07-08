package dao;

import entity.User;

import java.sql.SQLException;
import java.util.List;
/**
 * Created by igor on 16.10.2014.
 */
public interface UserDao {

    public List<User> getAll();

    public void add(User user) throws SQLException;
}
