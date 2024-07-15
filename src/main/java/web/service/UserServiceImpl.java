package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.UserDao;
import web.entity.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    // --------Dependency Injection--------
    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }
    // ------------------------------------

    // Сервис отображение всех пользователей
    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    // Сервис поиска пользователя по ID
    @Override
    public User findById(Long id) {
        return userDao.findById(id);
    }

    // Сервис создания пользователя
    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    // Сервис удаления пользователя
    @Override
    public void delete(User user) {
        userDao.delete(user);
    }

    // Сервис редактирования пользователя
    @Override
    public void editUserById(Long id, String name, String surname, int age, String height) {
        userDao.editUserById(id, name, surname, age, height);
    }
}
