package JDBC.pojo;


import lombok.*;

import javax.persistence.*;

@Entity @Table(name = "city")
@NoArgsConstructor
@Getter  @Setter
@ToString
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int city_id;

    private String city_name;



}
