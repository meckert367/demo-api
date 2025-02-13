package itzbund.demo_api;

import itzbund.demo_api.entities.User;
import itzbund.demo_api.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class UserRepositoryTest {
  
  @Autowired
  private UserRepository userRepository;
  
  @Test
  public void testSaveUser() {
    User user = new User("John Doe");
    User savedUser = userRepository.save(user);
    assertNotNull(savedUser);
    assertEquals("John Doe", savedUser.getName());
  }
  
  @Test
  public void testFindAllUsers() {
    User user1 = new User("John Doe");
    User user2 = new User("Jane Doe");
    userRepository.save(user1);
    userRepository.save(user2);
    assertEquals(2, userRepository.findAll().size());
  }
  
  @Test
  public void testFindUserById() {
    User user = new User("John Doe");
    User savedUser = userRepository.save(user);
    User foundUser = userRepository.findById(savedUser.getId()).orElse(null);
    assertNotNull(foundUser);
    assertEquals("John Doe", foundUser.getName());
  }
}
