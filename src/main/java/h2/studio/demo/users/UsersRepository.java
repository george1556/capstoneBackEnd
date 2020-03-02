package h2.studio.demo.users;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Integer> {
    Optional<User> getUserByUserNameEquals(String userName);
    Optional<User>getUserByUserName(String userName);
    Optional<User>findUserByUserName(String username);
}
