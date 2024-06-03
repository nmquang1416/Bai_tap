package module.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class UserController {
    UserRepository userRepository = new MySqlUserRepository();
    Scanner scanner = new Scanner(System.in);

    public void createUser() {
        User user = new User();

        System.out.println("please enter your information");
        System.out.println("enter your user name");
        user.setUserName(scanner.next());

        System.out.println("enter your password");
        user.setPassword(scanner.next());

        System.out.println("enter your full name");
        user.setFullName(scanner.next());

        System.out.println("enter your identity card");
        user.setIdentityCard(scanner.next());

        System.out.println("enter phone");
        user.setPhone(scanner.next());

        System.out.println("enter dob");
        user.setDob(LocalDate.parse(scanner.nextLine()));

        System.out.println("enter status");
        user.setStatus(scanner.nextInt());
        scanner.nextLine();

        userRepository.save(user);
    }

    public void showList(){
        ArrayList<User> users = userRepository.findAll();
        Scanner scanner = new Scanner(System.in);
        System.out.println("show list users.");
        System.out.println("---------------------------------------");
        System.out.printf("%-10s || %-30% ||%-30s\n", "Id", "Full Name", "Username");
        System.out.println("---------------------------------------");
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            System.out.printf("%-10s || %-30s || %-30s\n", user.getId(), user.getFullName(),user.getUserName());
        }
        System.out.println("Enter to continue");
        scanner.nextLine();
    }

    public void update(){
        System.out.println("Please enter user id to update");
        long id = scanner.nextLong();
        scanner.nextLine();
        User user = userRepository.findById(id);
        if (user == null) {
            System.out.println("User not found");
            return;
        }
        System.out.println("Found 1 user");
        System.out.println(user.getId()+"-"+user.getFullName()+"-"+user.getUserName());
        System.out.println("Please enter new information");
        System.out.println("Enter password");
        user.setPassword(scanner.nextLine());
        System.out.println("Enter Fullname");
        user.setFullName(scanner.nextLine());
        System.out.println("Enter identityCard");
        user.setIdentityCard(scanner.nextLine());
        System.out.println("Enter phone");
        user.setPhone(scanner.nextLine());
        System.out.println("Enter phone");
        user.setPhone(scanner.nextLine());
        System.out.println("Enter dob:");
        user.setDob(LocalDate.parse(scanner.nextLine()));
        System.out.println("Enter status");
        user.setStatus(scanner.nextInt());
        scanner.nextLine();
        userRepository.update(user);
    }
}
