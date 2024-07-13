package web.service;

import org.springframework.stereotype.Service;
import web.entity.User;

import java.util.List;

@Service
public interface UserService {
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
