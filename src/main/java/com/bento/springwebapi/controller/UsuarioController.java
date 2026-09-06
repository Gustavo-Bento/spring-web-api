package com.bento.springwebapi.controller;

import com.bento.springwebapi.model.Usuario;
import com.bento.springwebapi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioController {
    @Autowired
    private UsuarioRepository repository;

    @GetMapping("/usuarios")
    public List<Usuario> getUsers() {
        return repository.findAll();
    }

    @GetMapping("/usuarios/{login}")
    public Usuario getOne(@PathVariable("login") String login) {
        return repository.findByLogin(login);
    }

    @GetMapping("/usuarios/id/{id}")
    public Usuario getOneById(@PathVariable("id") Integer id) {
        return repository.findById(id);
    }

    @DeleteMapping("/usuarios/{id}")
    public void delete(@PathVariable("id") Integer id) {
        repository.deleteById(id);
    }

    @DeleteMapping("/usuarios/login/{login}")
    public void deleteByLogin(@PathVariable("login") String login) {
        repository.deleteByLogin(login);
    }

    @PostMapping("/usuarios")
    public void postUser(@RequestBody Usuario usuario) {
        repository.save(usuario);
    }
}
