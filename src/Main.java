
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        int id;
        UserStore userStore = new UserStore();
        UserService userService = new UserService(userStore);
        do{
            System.out.println("Welcome to UserManagement System");
            System.out.println("1.Add a new user");
            System.out.println("2.Get User by ID");
            System.out.println("3.Remove User by ID");
            System.out.println("4.Get All users");
            System.out.println("5.Exit");
            System.out.println("Enter a valid choice (1-5)");
            int select = scanner.nextInt();
            scanner.nextLine();
            if(select > 5 || select <= 0){
                System.out.println("Please Enter a valid argument");
                choice = 0; continue;
            } else {
                choice = select;
            }
            System.out.println("\n");
            switch(choice){
                case 1:
                System.out.println("Enter name of user: ");
                String name = scanner.nextLine();
                System.out.println("Enter email id: ");
                String email = scanner.nextLine();
                System.out.println("Enter age of the user: ");
                int age = scanner.nextInt();
                scanner.nextLine();
                try {
                    User user = userService.createNewUser(name, email, age);
                    System.out.println("User created: " + user);
                }catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
}

                break;

                case 2:
                    System.out.println("Enter id of user : ");
                    id =scanner.nextInt();
                    scanner.nextLine();
                    try {
                        User user = userService.getUserById(id);
                        System.out.println(user);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 3:
                    System.out.println("Enter id of user to be deleted : ");
                    id = scanner.nextInt();
                    scanner.nextLine();

                    try {
                      userService.deleteUserById(id);
                      System.out.println("User deleted Successfully!");  
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 4:
                    Map<Integer,User> usersPrint = userService.getAllUsers();
                    usersPrint.forEach((key,value)->System.out.println(value));

                    break;

                case 5:
                    break;

                default:
                    System.out.println("Invalid choice");
            }
        }while(choice!=5);
        System.out.println("Thank you for using our Service!!!!");
    }
}
