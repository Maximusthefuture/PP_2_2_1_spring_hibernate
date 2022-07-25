package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      for (int i = 0; i < 10; i++) {
         Car car1 = new Car("BMW", i);
         User user1 = new User("User" + i, "Lastname" + i, "user" + i + "@mail.ru");
         user1.setCar(car1);
         userService.add(car1);
         userService.add(user1);
      }

//      List<User> users = userService.listUsers();
      List<User> users = userService.listByCar("BMW", 2);
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("CAR = " + user.getCar());
         System.out.println();
      }

      context.close();
   }
}
