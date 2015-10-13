package entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
@Id @GeneratedValue private Long id;
private String firstname;
private String lastname;
private String mail;
}
