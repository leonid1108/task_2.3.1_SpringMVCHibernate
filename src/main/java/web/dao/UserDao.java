package web.dao;

import org.springframework.stereotype.Repository;
import web.entity.User;

import java.util.List;

@Repository
public interface UserDao {
    // Отображение всех пользователей
    List<User> getAllUsers();

    // Поиск пользователя по ID
    User findById(Long id);

    // Создание пользователя
    void saveUser(User user);

    // Удаление пользователя
    void delete(User user);

    // Редактирование пользователя
    void editUserById(Long id, String name, String surname, int age, String height);
}
