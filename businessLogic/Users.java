package businessLogic;


//Base class
public abstract class Users {
  String userId;
  String name;
  String email;
  String phoneNo;
  String password;
  String title;

  public Users(String name, String email, String phoneNo, String password, String title) {
      this.userId = UserIDGenerator.generateUserID();
      this.name = name;
      this.email = email;
      this.phoneNo = phoneNo;
      this.password = password;
      this.title = title;
  }

  public String getUserId() {
      return userId;
  }

  public String getName() {
      return name;
  }

  public String getEmail() {
      return email;
  }

  public String getPhoneNo() {
      return phoneNo;
  }

  public String getPassword() {
      return password;
  }

  public String getTitle() {
      return title;
  }

  public void setUserId(String userId) {
      this.userId = userId;
  }

  public void setName(String name) {
      this.name = name;
  }

  public void setEmail(String email) {
      this.email = email;
  }

  public void setPhoneNo(String phoneNo) {
      this.phoneNo = phoneNo;
  }

  public void setPassword(String password) {
      this.password = password;
  }

  public void setTitle(String title) {
      this.title = title;
  }

}