package com.zaffer.model;

import com.zaffer.model.identity.v3.Project;

public class AuthObject {

  public static final String METHOD_PASSWORD = "password";

  private Auth auth;

  public static class Auth {
    private Identity identity;
    private Scope scope;

    public Identity getIdentity() {
      return identity;
    }

    public void setIdentity(Identity identity) {
      this.identity = identity;
    }

    public Scope getScope() {
      return scope;
    }

    public void setScope(Scope scope) {
      this.scope = scope;
    }
  }

  public static class User {
    private String id;
    private String password;

    public String getId() {
      return id;
    }

    public void setId(String id) {
      this.id = id;
    }

    public String getPassword() {
      return password;
    }

    public void setPassword(String password) {
      this.password = password;
    }
  }

  public static class Password {
    private User user;

    public User getUser() {
      return user;
    }

    public void setUser(User user) {
      this.user = user;
    }
  }

  public static class Identity {
    private Password password;
    private String[] methods;

    public Password getPassword() {
      return password;
    }

    public void setPassword(Password password) {
      this.password = password;
    }

    public String[] getMethods() {
      return methods;
    }

    public void setMethods(String[] methods) {
      this.methods = methods;
    }
  }

  public static class Scope {
    private Project project;

    public Project getProject() {
      return project;
    }

    public void setProject(Project project) {
      this.project = project;
    }
  }

  public Auth getAuth() {
    return auth;
  }

  public void setAuth(Auth auth) {
    this.auth = auth;
  }

}
