package eurofunk.services;

import eurofunk.entities.UserEntity;
import eurofunk.models.UserModel;
import eurofunk.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 *
 */
@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository repositoryService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public String add(final String firstName, final String lastName) {
        logger.info("Adding new user. First Name '$firstName' | Last Name: '$lastName'");
        final UserEntity entity = new UserEntity();
        entity.id = UUID.randomUUID().toString();
        entity.firstName = firstName;
        entity.lastName = lastName;
        return repositoryService.save(entity).id;
    }

    @Override
    public void update(final String id, final String firstName, final String lastName) {
        logger.info("Updating user by ID '$id'. First Name '$firstName' | Last Name: '$lastName'");
        final Optional<UserEntity> entityOptional = repositoryService.findById(id);
        if (entityOptional.isPresent()) {
            final UserEntity entity = entityOptional.get();
            entity.firstName = firstName;
            entity.lastName = lastName;
            repositoryService.save(entity);
        }
    }

    @Override
    public void delete(final String id) {
        logger.info("Deleting user by ID '$id'");
        repositoryService.deleteById(id);
    }

    @Override
    public UserModel findById(final String id) {
        logger.info("Get user by ID '$id'");
        repositoryService.findAll();
        Optional<UserEntity> entityOptional = repositoryService.findById(id);
        if (entityOptional.isPresent()) {
            final UserEntity entity = entityOptional.get();
            return createModel(entity);
        } else {
            return null;
        }
    }

    @Override
    public List<UserModel> findAll() {
        logger.info("Get all users");
        final Iterable<UserEntity> iterable = repositoryService.findAll();
        return StreamSupport.stream(iterable.spliterator(), false)
                .map(this::createModel)
                .collect(Collectors.toList());
    }

    private UserModel createModel(final UserEntity entity) {
        final UserModel model = new UserModel();
        model.setId(entity.id);
        model.setFirstName(entity.firstName);
        model.setLastName(entity.lastName);
        return model;
    }
}
