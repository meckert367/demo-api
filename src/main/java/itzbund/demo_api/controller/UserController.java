package itzbund.demo_api.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import itzbund.demo_api.entities.User;
import itzbund.demo_api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@Tag(name = "users", description = "User API")
public class UserController {
  
  private final UserRepository userRepository;
  
  @Autowired
  public UserController(UserRepository userRepository) {
    this.userRepository = userRepository;
  }
  
  @Operation(summary = "Get all users")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Users retrieved successfully"),
  })
  @GetMapping("/users")
  public List<User> getUsers() {
    return userRepository.findAll();
  }
  
  @Operation(summary = "Create a new user")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "201", description = "User created successfully"),
  })
  @PostMapping("/users")
  public ResponseEntity<User> createUser(@RequestBody User user) {
    User savedUser = userRepository.save(user);
    return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
  }
}