package eurofunk.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 */
@Entity
@Table(name = "users")
public class UserEntity {

    /**
     *
     */
    @Id
    @Column
    public String id;

    /**
     *
     */
    @Column
    public String firstName;

    /**
     *
     */
    @Column
    public String lastName;
}