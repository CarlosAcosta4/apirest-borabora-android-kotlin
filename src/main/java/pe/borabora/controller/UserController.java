package pe.borabora.controller;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import pe.borabora.dto.CreateUser;
import pe.borabora.entity.RoleEntity;
import pe.borabora.entity.UserEntity;
import pe.borabora.model.ERole;
import pe.borabora.repository.UserRepository;


@RestController
public class UserController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/hello")
    public String hello(){
        return "Hello World Not Secured";
    }

    @GetMapping("/helloSecured")
    public String helloSecured(){
        return "Hello World Secured";
    }

    @PostMapping("/createUser")
    public ResponseEntity<?> createUser(@Valid @RequestBody CreateUser createUser){

        Set<RoleEntity> roles = createUser.getRoles().stream()
                .map(role -> RoleEntity.builder()
                        .name(ERole.valueOf(role))
                        .build())
                .collect(Collectors.toSet());

        UserEntity userEntity = UserEntity.builder()
        		.name(createUser.getName())
        		.lastname(createUser.getLastname())
        		.cellphone(createUser.getCellphone())
        		.email(createUser.getEmail())
                .username(createUser.getUsername())
                .password(passwordEncoder.encode(createUser.getPassword()))            
                .roles(roles)
                .build();

        userRepository.save(userEntity);

        return ResponseEntity.ok(userEntity);
    }
}
