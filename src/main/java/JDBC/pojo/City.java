package JDBC.pojo;


import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity @Table(name = "city")
@NoArgsConstructor
@Getter  @Setter
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id")
    private int cityId;
    @Column(name = "city_name")
    private String cityName;

    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
    private List<Employee> employees;


    @Override
    public String toString() {
        return cityName;
    }
}
