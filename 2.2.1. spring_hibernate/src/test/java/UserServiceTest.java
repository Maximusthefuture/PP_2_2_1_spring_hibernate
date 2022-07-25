import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import hiber.service.UserServiceImp;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class UserServiceTest {
    AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(AppConfig.class);

    UserService userService = context.getBean(UserService.class);

    private Car car1 = new Car("BMW", 200);
    private String firstName = "Vasya";
    private String lastName = "Petya";
    private User user1 = new User(firstName, lastName, "petya@");

    @Test
    public void checkUsersCar() {
        try {
            user1.setCar(car1);
            userService.add(car1);
            userService.add(user1);

            User user = userService.listByCar("BMW", 200).get(0);
            if (!firstName.equals(user.getFirstName())
                    || !lastName.equals(user.getLastName())) {
                Assert.fail("Некорректный user");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            Assert.fail("Во время тестирования произошла ошибка");
        }
    }
}
