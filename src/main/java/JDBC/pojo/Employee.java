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
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column
    private String gender;
    @Column
    private int age;
    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;



    @Override
    public String toString() {
        return "Employee{" + "id = " + id +
                "first_name='" + firstName + '\'' +
                ", last_name='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", city_id=" + city +
                '}';
    }
}
