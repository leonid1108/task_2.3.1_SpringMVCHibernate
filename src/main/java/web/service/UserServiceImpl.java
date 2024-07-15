package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    // Сервис поиска пользователя по ID
    @Override
    @Transactional(readOnly = true)
    public User findById(Long id) {
        return userDao.findById(id);
    }

    // Сервис создания пользователя
    @Override
    @Transactional
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    // Сервис удаления пользователя
    @Override
    @Transactional
    public void delete(User user) {
        userDao.delete(user);
    }

    // Сервис редактирования пользователя
    @Override
    @Transactional
    public void editUserById(Long id, String name, String surname, int age, String height) {
        userDao.editUserById(id, name, surname, age, height);
    }
}
