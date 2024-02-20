package web.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Min(value = 0, message = " В поле могут быть только положительные числа")
    private long id;

    @Column(name = "first_name")
    @NotEmpty(message = " Имя не может быть пустым " )

    @Pattern(regexp = "^[a-zA-Zа-яА-Я]*$", message = "имя должно содержать только буквы")
    private String firstName;

    @Column(name = "last_name")
    @NotEmpty(message = "фамилия не может быть пустой")
    @Pattern(regexp = "^[a-zA-Zа-яА-Я]*$", message = "фамилия должна содержать только буквы")
    private String lastName;

    @Column(name = "email", unique = true)
    @Email(message = " не корректный ввод Email ")
    private String email;

    public User(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public User() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


//    // Реализация валидации значений
//    public boolean validate() {
//        if (firstName.matches(".*\\d+.*") || lastName.matches(".*\\d+.*")) {
//            System.out.println("Имя и фамилия не должны содержать цифры");
//            return false;
//        }
//        if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty()) {
//            System.out.println("Поля не должны быть пустыми");
//            return false;
//        }
//        if (id <= 0) {
//            System.out.println("ID должен быть больше 0");
//            return false;
//        }
//        return true;
//    }
}



