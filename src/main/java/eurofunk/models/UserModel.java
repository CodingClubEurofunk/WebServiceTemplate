package eurofunk.models;

/**
 *
 */
public class UserModel {

    /**
     *
     */
    private String id;

    /**
     *
     */
    private String firstName;

    /**
     *
     */
    private String lastName;

    /**
     *
     */
    public void setId(final String id) {
        this.id = id;
    }

    /**
     *
     */
    public String getId() {
        return this.id;
    }

    /**
     *
     */
    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    /**
     *
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     *
     */
    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    /**
     *
     */
    public String getLastName() {
        return this.lastName;
    }
}
