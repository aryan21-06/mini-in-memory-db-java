import java.util.HashMap;
import java.util.Map;

public class UserStore {
    private Map<Integer, User> users = new HashMap<>();
    private int idCount = 1;

    public int getIdCount(){
        int temp = idCount;
        return temp;
    }

    public User addUser(String name, String email, int age) {
        int id = idCount++;
        User user = new User(id, name, email, age);
        users.put(id, user);
        return user;
    }

    public User getById(int id) {
        User user = users.get(id);
        if (user == null) {
            throw new IllegalArgumentException("User not found with id: " + id);
        }
        return user;
    }

    public void deleteById(int id) {
        if (users.get(id) == null) {
            throw new IllegalArgumentException("User not found with id: " + id);
        }
            users.remove(id);
    }
    public Map<Integer,User> getAllUsers(){
        return new HashMap<>(users);
    }

}
