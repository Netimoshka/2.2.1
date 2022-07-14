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

      userService.add(new User("Vasia", "Ivanov", "vasin@mail.ru", new Car("BMW", 2)));
      userService.add(new User("Petya", "Vasechkin", "petin@mail.ru", new Car("Audi", 3)));
      userService.add(new User("Bender", "Rogdriges", "benders@mail.ru", new Car("Volvo", 777)));
      userService.add(new User("Kyle", "Broflofvski", "kyle@mail.ru", new Car("Moskvich", 407)));

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car = "+ user.getCar());
         System.out.println();
      }
      System.out.println(userService.getUserByCar("BMW", 2));
      System.out.println(userService.getUserByCar("Audi", 3));
      System.out.println(userService.getUserByCar("Volvo", 777));
      System.out.println(userService.getUserByCar("Moskvich", 407));

      context.close();




      context.close();
   }
}
