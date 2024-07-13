package web.dao;

import org.springframework.stereotype.Repository;
import web.entity.User;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    // Вывод всех пользователей
    @Override
    @Transactional
    public List<User> getAllUsers() {
        return entityManager.createQuery("SELECT u FROM User u", User.class)
                .getResultList();
    }

    // Поиск пользователя по ID
    @Override
    @Transactional
    public User findById(Long id) {
        return entityManager.find(User.class, id);
    }

    // Создание пользователя
    @Override
    @Transactional
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    // Удаление пользователя
    @Override
    @Transactional
    public void delete(User user) {
        User managedUser = entityManager.find(User.class, user.getId());
        if (managedUser != null) {
            entityManager.remove(managedUser);
            entityManager.flush();
        }
    }

    // Редактирование пользователя
    @Override
    @Transactional
    public void editUserById(Long id, String name, String surname, int age, String height) {
        User user = entityManager.find(User.class, id);
        if (user != null) {
            user.setName(name);
            user.setSurname(surname);
            user.setAge(age);
            user.setHeight(height);
            entityManager.merge(user);
        }
    }
}
