package LoginRegistroJwt.controller;

import LoginRegistroJwt.entity.Users;
import LoginRegistroJwt.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserRepository repository;
    private final PasswordEncoder encoder;

    public UserController(UserRepository repository, PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }


    @GetMapping("/listAll")
    public ResponseEntity<List<Users>> listarTodos() {
        return ResponseEntity.ok(repository.findAll());
    }

    @PostMapping("/saveUser")
    public ResponseEntity<Users> save(@RequestBody Users users) {
        users.setPassword(encoder.encode(users.getPassword()));
        return ResponseEntity.ok(repository.save(users));
    }

    @GetMapping("/login")
    public ResponseEntity<Boolean> validarSenha(@RequestParam String login,
                                                @RequestParam String password) {

        Optional<Users> optUser = repository.findByName(login);
        if (optUser.isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
        }

        Users users = optUser.get();
        boolean valid = encoder.matches(password, users.getPassword());

        HttpStatus status = (valid) ? HttpStatus.OK : HttpStatus.UNAUTHORIZED;
        return ResponseEntity.status(status).body(valid);

    }

}
