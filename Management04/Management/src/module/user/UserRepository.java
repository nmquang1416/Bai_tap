package module.user;

import java.util.ArrayList;

public interface UserRepository {
    ArrayList<User> findAll();
    User findById(long id);
    User save(User user);
    User update(User user);
    void deleteById(long id);
}
