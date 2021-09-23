package eurofunk.controllers;

import eurofunk.models.IdModel;
import eurofunk.models.UserModel;
import eurofunk.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 */
@CrossOrigin(origins = ("*"), allowedHeaders = ("*"))
@Controller
@RequestMapping(path = ("/user"))
public class UserController {

    @Autowired
    private IUserService userService;

    /**
     *
     */
    @PutMapping("/add")
    public ResponseEntity<IdModel> add(@RequestParam final String firstName, @RequestParam final String lastName) {
        try {
            final String id = userService.add(firstName, lastName);
            final IdModel model = new IdModel(id);
            return new ResponseEntity(model, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     *
     */
    @PostMapping("/update")
    public ResponseEntity<HttpStatus> update(
            @RequestParam final String id,
            @RequestParam final String firstName,
            @RequestParam final String lastName
    ) {
        try {
            userService.update(id, firstName, lastName);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     *
     */
    @DeleteMapping("/delete")
    public ResponseEntity<HttpStatus> delete(@RequestParam final String id) {
        try {
            userService.delete(id);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     *
     */
    @GetMapping("/findById")
    public ResponseEntity<UserModel> findById(@RequestParam final String id) {
        try {
            final UserModel model = userService.findById(id);
            return new ResponseEntity(model, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     *
     */
    @GetMapping("/findAll")
    public ResponseEntity<List<UserModel>> findAll() {
        try {
            final List<UserModel> models = userService.findAll();
            return new ResponseEntity(models, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}
