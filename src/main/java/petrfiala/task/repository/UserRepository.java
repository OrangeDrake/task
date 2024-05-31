package petrfiala.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import petrfiala.task.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}