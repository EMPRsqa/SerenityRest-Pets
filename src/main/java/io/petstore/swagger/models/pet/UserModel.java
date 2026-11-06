package io.petstore.swagger.models.pet;

public class UserModel {
    private int id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;
    private int userStatus;

    // Constructores, Getters y Setters
    public UserModel(int id, String username, String firstName, String lastName, String email, String password, String phone, int userStatus) {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.userStatus = userStatus;
    }

    public String getUsername() { return username; }
    public int getId() { return id; }
    // Puedes añadir los demás getters y setters necesarios
}