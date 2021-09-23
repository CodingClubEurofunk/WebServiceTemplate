import eurofunk.Application;
import eurofunk.models.UserModel;
import eurofunk.services.IUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.*;

/**
 *
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = Application.class)
public class ServiceTest {

    @Autowired
    private IUserService userService;

    @Test
    public void testCrudlOperations() {
        String firstName = UUID.randomUUID().toString();
        String lastName = UUID.randomUUID().toString();

        // Add user
        final String id = userService.add(firstName, lastName);
        // Check if user exists and if name matches
        checkData(id, firstName, lastName);

        // Assign new name
        firstName = UUID.randomUUID().toString();
        lastName = UUID.randomUUID().toString();

        // Update user with name
        userService.update(id, firstName, lastName);
        // Check if user exists and if new name matches
        checkData(id, firstName, lastName);

        // Check if only one user has been added
        List<UserModel> models = userService.findAll();
        assert(models.size() == 1);

        // Delete user
        userService.delete(id);
        // Check that no user is saved anymore
        models = userService.findAll();
        assert(models.isEmpty());
    }

    private void checkData(final String id, final String firstName, final String lastName) {
        final UserModel model = userService.findById(id);
        assert(model != null);
        assert(!model.getId().isEmpty());
        assert(model.getFirstName().equals(firstName));
        assert(model.getLastName().equals(lastName));
    }
}
