package JDBC.pojo;


import lombok.*;

@Getter
@Setter
public class Employee {

    private Integer id;
    private String first_name;
    private String last_name;
    private String gender;
    private int age;
    private int city_id;

    public Employee(String first_name, String last_name, String gender, int age, int city_id) {

        this.first_name = first_name;
        this.last_name = last_name;
        this.gender = gender;
        this.age = age;
        this.city_id = city_id;

    }

    @Override
    public String toString() {
        return "Employee{" +
                "first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", city_id=" + city_id +
                '}';
    }
}
