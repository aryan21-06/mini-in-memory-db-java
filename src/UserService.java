import java.util.Map;

public class UserService{
    
    private final UserStore userStore;
    
    public UserService(UserStore userStore){
        this.userStore = userStore;
    }

    public User createNewUser(String name , String email , int age){
        if(name==null || !email.contains("@") || age <= 0){
            throw new IllegalArgumentException("Invalid entries detected. Please redo.");
        }
        return userStore.addUser(name,email,age);
    }

    public User getUserById(int id){
        return userStore.getById(id);
    }

    public void deleteUserById(int id){
        userStore.deleteById(id);
    }

    public Map<Integer,User> getAllUsers(){
        return userStore.getAllUsers();
    }

}
