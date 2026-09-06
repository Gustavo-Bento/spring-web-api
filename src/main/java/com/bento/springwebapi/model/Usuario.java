package com.bento.springwebapi.model;

/**
 * Represents an application user.
 *
 * <p>Plain domain model used across the controller, repository and
 * exception-handling layers. Currently persisted in-memory by
 * {@link com.bento.springwebapi.repository.UsuarioRepository}.</p>
 *
 * @author Gustavo Bento
 */
public class Usuario {

    /** Unique identifier of the user. {@code null} for a user not yet persisted. */
    private Integer id;

    /** User's login/username. Required field. */
    private String login;

    /** User's password. Required field. */
    private String password;

    /**
     * Creates an empty user instance.
     *
     * <p>Required by frameworks (e.g. JSON deserialization) that rely on a
     * no-argument constructor.</p>
     */
    public Usuario() {}

    /**
     * Creates a user with the given login and password.
     *
     * @param login    the user's login/username
     * @param password the user's password
     */
    public Usuario(String login, String password) {
        this.login = login;
        this.password = password;
    }

    /**
     * Returns a human-readable representation of this user, useful for
     * logging and debugging.
     *
     * @return a string containing the id, login and password fields
     */
    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    /**
     * Returns the user's id.
     *
     * @return the id, or {@code null} if not yet persisted
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the user's id.
     *
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Returns the user's login.
     *
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * Sets the user's login.
     *
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Returns the user's password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the user's password.
     *
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
