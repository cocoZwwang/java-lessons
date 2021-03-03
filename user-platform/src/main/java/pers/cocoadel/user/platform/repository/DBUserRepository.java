package pers.cocoadel.user.platform.repository;

import pers.cocoadel.user.platform.bean.SingletonBeanContainer;
import pers.cocoadel.user.platform.domain.User;
import pers.cocoadel.user.platform.jdbc.JdbcHelper;

import java.util.Collection;

public class DBUserRepository implements UserRepository {

    private final JdbcHelper jdbcHelper;

    private final static String INSERT_SQL = "INSERT INTO users(name,password,email,phoneNumber) VALUES (?,?,?,?)";

    private final static String UPDATE_SQL = "UPDATE users set name = ?,password = ?,email = ?,phoneNumber = ? where id = ?";

    private final static String SELECT_SQL = "select * from users";

    private final static String DELETE_SQL = "delete from users";

    public DBUserRepository() {
        this.jdbcHelper = SingletonBeanContainer.getInstance().get(JdbcHelper.class);
    }

    @Override
    public boolean save(User user) {
        return jdbcHelper.executeUpdate(INSERT_SQL,
                user.getName(), user.getPassword(), user.getEmail(), user.getPhoneNumber()) > 0;
    }

    @Override
    public boolean deleteById(Long userId) {
        String sql = DELETE_SQL + " where id = ?";
        return jdbcHelper.executeUpdate(sql, userId) > 0;
    }

    @Override
    public boolean update(User user) {
        return jdbcHelper.executeUpdate(UPDATE_SQL,
                user.getName(), user.getPassword(), user.getEmail(), user.getPhoneNumber(), user.getId()) > 0;
    }

    @Override
    public User getById(Long userId) {
        String sql = SELECT_SQL + " where id = ?";
        return jdbcHelper.queryOne(sql, User.class, userId);
    }

    @Override
    public User getByNameAndPassword(String userName, String password) {
        String sql = SELECT_SQL + " where name = ? and password = ?";
        return jdbcHelper.queryOne(sql, User.class, userName, password);
    }

    @Override
    public Collection<User> getAll() {
        return jdbcHelper.queryAll(SELECT_SQL, User.class);
    }
}
