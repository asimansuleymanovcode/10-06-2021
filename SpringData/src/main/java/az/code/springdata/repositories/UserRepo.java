package az.code.springdata.repositories;

import az.code.springdata.models.MyUser;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<MyUser, Long> {
    MyUser findUserByUsername(String username);
}
