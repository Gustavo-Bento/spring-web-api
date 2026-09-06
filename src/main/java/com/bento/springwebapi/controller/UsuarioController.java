package com.bento.springwebapi.controller;

import com.bento.springwebapi.model.Usuario;
import com.bento.springwebapi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsuarioController {
    @Autowired
    private UsuarioRepository repository;

    @GetMapping
    public List<Usuario> getUsers() {
        return repository.findAll();
    }

    @GetMapping("/login/{login}")
    public Usuario getOne(@PathVariable("login") String login) {
        return repository.findByLogin(login);
    }

    @GetMapping("/{id}")
    public Usuario getOneById(@PathVariable("id") Integer id) {
        return repository.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        repository.deleteById(id);
    }

    @DeleteMapping("/login/{login}")
    public void deleteByLogin(@PathVariable("login") String login) {
        repository.deleteByLogin(login);
    }

    @PostMapping()
    public void postUser(@RequestBody Usuario usuario) {
        repository.save(usuario);
    }

    @PutMapping()
    public void putUser(@RequestBody Usuario usuario) {
        repository.save(usuario);
    }
}