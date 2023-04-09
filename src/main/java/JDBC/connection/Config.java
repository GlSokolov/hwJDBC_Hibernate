package JDBC.connection;

import JDBC.pojo.City;
import JDBC.pojo.Employee;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class Config {

    private static SessionFactory sessionFactory;

    private Config() {}

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(City.class);
                configuration.addAnnotatedClass(Employee.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}




/*               __Подключение к БД через JDBC__

    public static void main(String[] args) throws SQLException {

        try (java.sql.Connection connection = getConnetion();
             PreparedStatement statement = connection.prepareStatement(
                     "SELECT  * FROM employee WHERE id = (?)") ) {

            statement.setInt(1, 1);
            ResultSet result = statement.executeQuery();

            while (result.next()){
                String firstName = result.getString("first_name");
                String lastName = result.getString("last_name");
                String gender = result.getString("gender");
                int age = result.getInt(5);

                System.out.println(firstName);
                System.out.println(lastName);
                System.out.println(gender);
                System.out.println(age);
            }

        }

    }

    public static java.sql.Connection getConnetion() throws SQLException {

        final String url = "jdbc:postgresql://localhost:5432/skypro";
        final String user = "postgres";
        final String password = "postgresSkyPro";

        return DriverManager.getConnection(url, user, password);
    }
=====================================================

                __Подключение к БД через EntityManagerF__

public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.close();
        entityManagerFactory.close();
}
*/

