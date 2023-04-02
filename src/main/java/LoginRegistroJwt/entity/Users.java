package LoginRegistroJwt.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="users")
public class Users {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false, unique=true)
    private String name;

    @Column(nullable=false, unique=true)
    private String CPF;

    @Column(nullable=false)
    private String office;

    @Column(nullable=false)
    private String phone;

    @Column(nullable=false)
    private String address;

    @Column(nullable=false)
    private String company;

    @Column(nullable=false, unique=true)
    private String email;

    @Column(nullable=false)
    private String password;
}
