package com.bento.springwebapi.repository;

import com.bento.springwebapi.model.Usuario;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UsuarioRepository {

    public void save(Usuario usuario) {
        if(usuario.getId() == null) {
            System.out.println("SAVE - Recebendo o usuário na camada de repositório");
        }else {
            System.out.println("UPDATE - Recebendo o usuário na camada de repositório");
        }
        System.out.println(usuario);
    }

    public void deleteById(Integer id) {
        System.out.println(String.format("DELETE/id - Recebendo o id: %d para exclusão", id));
        System.out.println(id);
    }

    public void deleteByLogin(String login) {
        System.out.println(String.format("DELETE/login - Recebendo o login: %s para exclusão", login));
        System.out.println(login);
    }

    public List<Usuario> findAll() {
        System.out.println("FIND ALL - Recebendo requisição para listar todos os usuários");
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("joao01", "123"));
        usuarios.add(new Usuario("maria#1", "150"));
        usuarios.add(new Usuario("jose_dias", "ggg"));
        usuarios.add(new Usuario("caio#2", "150"));
        return usuarios;
    }

    public Usuario findById(Integer id) {
        System.out.println(String.format("FIND/id - Recebendo o id: %d para localizar um usuário", id));
        Usuario usuario = new Usuario("joao01", "123");
        System.out.println(usuario);
        return usuario;
    }

    public Usuario findByLogin(String login) {
        System.out.println(String.format("FIND/login - Recebendo o login: %s para localizar um usuário", login));
        Usuario usuario = new Usuario(login, "123");
        System.out.println(usuario);
        return usuario;
    }
}
