package com.zaffer.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

class User {
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  private String username;
  private String password;
  private String description;
}

@SpringBootApplication
@RestController
public class ApplicationMain {

  @RequestMapping("hello")
  public String restTest() {
    return "Hello Spring RESTful!";
  }

  @RequestMapping(value="getUser", method=RequestMethod.GET)
  @ResponseBody
  public User restGet() {//@RequestBody User user) {
    User user = new User();
    user.setUsername("mingzhang2");
    user.setPassword("xylx1.t!@#");
    user.setDescription("test user");
    return user;
  }

  @RequestMapping(value="addUser", method = RequestMethod.POST)
  @ResponseBody
  public User restPost() {
    User user = new User();
    user.setUsername("user_get");
    user.setPassword("xylx1.t!@#");
    user.setDescription("");
    return user;
  }

  public static void main(String[] args) {
    SpringApplication.run(ApplicationMain.class);
  }

}
