package com.zaffer.test;

import com.google.gson.Gson;
import com.zaffer.model.AuthObject;
import com.zaffer.model.identity.v3.Project;

public class JsonTools {

  public static AuthObject createAuthObject() {
    AuthObject authObject = new AuthObject();

    AuthObject.Auth auth = new AuthObject.Auth();
    AuthObject.Identity identity = new AuthObject.Identity();

    AuthObject.Password password = new AuthObject.Password();
    AuthObject.User user = new AuthObject.User();
    user.setId("013502c6e9d949e59c5a0c5eb360bca0");
    user.setPassword("keystone");

    password.setUser(user);

    identity.setMethods(new String[]{"password"});
    identity.setPassword(password);

    AuthObject.Scope scope = new AuthObject.Scope();
    Project project = new Project();
    project.setId("551fc1b9fa964883b3334af284fac195");
    scope.setProject(project);

    auth.setIdentity(identity);
    auth.setScope(scope);

    authObject.setAuth(auth);

    return authObject;
  }

  public static String createAuthString(AuthObject obj) {
    Gson gson = new Gson();
    return gson.toJson(createAuthObject());
  }


  public static void main(String[] args) {

    Gson gson = new Gson();
    System.out.println(gson.toJson(createAuthObject()));
  }
}
