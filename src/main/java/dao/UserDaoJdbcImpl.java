package dao;

import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by igor on 16.10.2014.
 */
@Repository
public class UserDaoJdbcImpl implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public static final String SELECT_ALL_SQL = "SELECT id, name FROM users";
    public static final String INSERT_SQL = "INSERT INTO users (id, name) values (?, ?)";

    @Override
    public List<User> getAll() {
        List<User> list = new ArrayList<>();
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(SELECT_ALL_SQL);
        for(Map row : rows){
            User user = new User();
            user.setId(Integer.parseInt(String.valueOf(row.get("id"))));
            user.setName( String.valueOf(row.get("name")) );
            list.add(user);
        }
        return list;
    }

    @Override
    public void add(User user) throws SQLException {
        jdbcTemplate.update(INSERT_SQL, user.getId(), user.getName());
    }
}
