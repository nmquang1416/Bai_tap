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

    }
}
