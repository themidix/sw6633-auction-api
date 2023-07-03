package edu.ksu.sw6633auctionapi.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Long userId;
    @Column(name = "email", nullable = false, length = 45, unique = true)
    private String email;
    @Column(name = "password", nullable = false, length = 45)
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private Set<Role> roles = new HashSet<>();
    @OneToOne(mappedBy = "user")
    private RegisteredUser registeredUser;


    public User(String email, String password,RegisteredUser registeredUser) {
        this.email = email;
        this.password = password;
        this.registeredUser = registeredUser;
    }

    public User() {

    }
    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public void assignRoleToUser(Role role) {
        this.roles.add(role);
        role.getUsers().add(this);
    }

    public void removeRoleFromUser(Role role) {
        this.roles.remove(role);
        role.getUsers().remove(this);
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userIId) {
        this.userId = userIId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public RegisteredUser getRegisteredUser() {
        return registeredUser;
    }

    public void setRegisteredUser(RegisteredUser registeredUser) {
        this.registeredUser = registeredUser;
    }
}
