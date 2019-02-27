import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Task17 {
    public static void main(String[] args) {
        Person.createPerson(1, "David", "Beckham", "29.03.1953");
        Person.readPerson();
        Mail.createMail(2,"kjell@home.no", "kjell@work.no");
        Mail.readMail();

        // To clear the database
        for (int i = 0; i < 100; i++) {
            Person.deletePerson(i);
            Mail.deleteMail(i);
            Phone.deletePhone(i);
        }
    }

}