package com.bento.springwebapi.controller;

import com.bento.springwebapi.model.Usuario;
import com.bento.springwebapi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller exposing CRUD operations for {@link Usuario} resources
 * under the {@code /users} base path.
 *
 * <p>Validation and business rules are delegated to
 * {@link UsuarioRepository}; any invalid input results in a
 * {@code com.bento.springwebapi.handler.BusinessException}, which is
 * translated into a standardized error response by
 * {@code com.bento.springwebapi.handler.GlobalExceptionHandler}.</p>
 *
 * @author Gustavo Bento
 */
@RestController
@RequestMapping("/users")
public class UsuarioController {

    /** Data-access layer used to fulfill all user operations. */
    @Autowired
    private UsuarioRepository repository;

    /**
     * Lists all registered users.
     *
     * @return the list of all users
     */
    @GetMapping
    public List<Usuario> getUsers() {
        return repository.findAll();
    }

    /**
     * Finds a single user by login.
     *
     * @param login the login of the user to find
     * @return the matching user
     */
    @GetMapping("/login/{login}")
    public Usuario getOne(@PathVariable("login") String login) {
        return repository.findByLogin(login);
    }

    /**
     * Finds a single user by id.
     *
     * @param id the id of the user to find
     * @return the matching user
     */
    @GetMapping("/{id}")
    public Usuario getOneById(@PathVariable("id") Integer id) {
        return repository.findById(id);
    }

    /**
     * Deletes a user by id.
     *
     * @param id the id of the user to delete
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        repository.deleteById(id);
    }

    /**
     * Deletes a user by login.
     *
     * @param login the login of the user to delete
     */
    @DeleteMapping("/login/{login}")
    public void deleteByLogin(@PathVariable("login") String login) {
        repository.deleteByLogin(login);
    }

    /**
     * Creates a new user.
     *
     * @param usuario the user to create, provided in the request body
     */
    @PostMapping()
    public void postUser(@RequestBody Usuario usuario) {
        repository.save(usuario);
    }

    /**
     * Updates an existing user.
     *
     * @param usuario the user to update, provided in the request body
     */
    @PutMapping()
    public void putUser(@RequestBody Usuario usuario) {
        repository.save(usuario);
    }
}
