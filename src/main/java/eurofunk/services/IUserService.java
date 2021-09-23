package eurofunk.services;

import eurofunk.models.UserModel;

import java.util.List;

/**
 *
 */
public interface IUserService {

    /**
     *
     */
    String add(final String firstName, final String lastName);

    /**
     *
     */
    void update(final String id, final String firstName, final String lastName);

    /**
     *
     */
    void delete(final String id);

    /**
     *
     */
    UserModel findById(final String id);

    /**
     *
     */
    List<UserModel> findAll();
}
