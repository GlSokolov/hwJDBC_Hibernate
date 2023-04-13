package JDBC.pojo;


import lombok.*;

import javax.persistence.*;

@Entity @Table(name = "employee")
@NoArgsConstructor
@Getter @Setter
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String first_name;
    @Column
    private String last_name;
    @Column
    private String gender;
    @Column
    private int age;
    @Column
    private int city_id;

    @Override
    public String toString() {
        return "Employee{" + "id = " + id +
                "first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", city_id=" + city_id +
                '}';
    }
}
