package com.bento.springwebapi.repository;

import com.bento.springwebapi.handler.*;
import com.bento.springwebapi.model.Usuario;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Data-access layer for {@link Usuario}.
 *
 * <p><strong>Note:</strong> this is currently an in-memory mock
 * implementation for development purposes — no data is actually persisted
 * between requests. Every method validates its required input and throws
 * {@link CampoObrigatorioException} when a mandatory field is missing.</p>
 *
 * @author Gustavo Bento
 */
@Repository
public class UsuarioRepository {

    /**
     * Persists a new user or updates an existing one.
     *
     * <p>A user with a {@code null} {@link Usuario#getId() id} is treated as
     * a new record (save); otherwise it is treated as an update.</p>
     *
     * @param usuario the user to save or update; must have a non-null login
     * @throws CampoObrigatorioException if {@code usuario.getLogin()} is {@code null}
     */
    public void save(Usuario usuario) {
        if(usuario.getLogin()==null) throw new CampoObrigatorioException("login");
        if(usuario.getId() == null) {
            System.out.println("SAVE - Recebendo o usuário na camada de repositório");
        }else {
            System.out.println("UPDATE - Recebendo o usuário na camada de repositório");
        }
        System.out.println(usuario);
    }

    /**
     * Deletes a user by id.
     *
     * @param id the id of the user to delete; must not be {@code null}
     * @throws CampoObrigatorioException if {@code id} is {@code null}
     */
    public void deleteById(Integer id) {
        if(id == null) throw new CampoObrigatorioException("id");
        System.out.println(String.format("DELETE/id - Recebendo o id: %d para exclusão", id));
        System.out.println(id);
    }

    /**
     * Deletes a user by login.
     *
     * @param login the login of the user to delete; must not be {@code null}
     * @throws CampoObrigatorioException if {@code login} is {@code null}
     */
    public void deleteByLogin(String login) {
        if(login == null) throw new CampoObrigatorioException("login");
        System.out.println(String.format("DELETE/login - Recebendo o login: %s para exclusão", login));
        System.out.println(login);
    }

    /**
     * Returns all registered users.
     *
     * <p>In the current mock implementation, this always returns the same
     * fixed set of sample users.</p>
     *
     * @return a list containing all users; never {@code null}
     */
    public List<Usuario> findAll() {
        System.out.println("FIND ALL - Recebendo requisição para listar todos os usuários");
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("joao01", "123"));
        usuarios.add(new Usuario("maria#1", "150"));
        usuarios.add(new Usuario("jose_dias", "ggg"));
        usuarios.add(new Usuario("caio#2", "150"));
        return usuarios;
    }

    /**
     * Finds a user by id.
     *
     * @param id the id of the user to find; must not be {@code null}
     * @return the matching user
     * @throws CampoObrigatorioException if {@code id} is {@code null}
     */
    public Usuario findById(Integer id) {
        if(id == null) throw new CampoObrigatorioException("id");
        System.out.println(String.format("FIND/id - Recebendo o id: %d para localizar um usuário", id));
        Usuario usuario = new Usuario("joao01", "123");
        System.out.println(usuario);
        return usuario;
    }

    /**
     * Finds a user by login.
     *
     * @param login the login of the user to find; must not be {@code null}
     * @return the matching user
     * @throws CampoObrigatorioException if {@code login} is {@code null}
     */
    public Usuario findByLogin(String login) {
        if(login == null) throw new CampoObrigatorioException("login");
        System.out.println(String.format("FIND/login - Recebendo o login: %s para localizar um usuário", login));
        Usuario usuario = new Usuario(login, "123");
        System.out.println(usuario);
        return usuario;
    }
}
