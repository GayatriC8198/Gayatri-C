package com.example.login;
import javax.persistence.*;
import java.util.Set;
public class Model {
    @Entity
    @Table(name = "user")
    public class User {
        private Long id;
        private String username;
        private String password;
        private String passwordConfirm;
        private Set roles;
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        public Long getId() {
            return id;
        }
        public void setId(Long id) {
            this.id = id;
        }
        public String getUsername() {
            return username;
        }
        public void setUsername(String username) {
            this.username = username;
        }
        public String getPassword() {
            return password;
        }
        public void setPassword(String password) {
            this.password = password;
        }
        @Transient
        public String getPasswordConfirm() {
            return passwordConfirm;
        }
        public void setPasswordConfirm(String passwordConfirm) {
            this.passwordConfirm = passwordConfirm;
        }
        @ManyToMany
        @JoinTable(name = "user_role",
                joinColumns = @JoinColumn(name = "user_id"),
                inverseJoinColumns = @JoinColumn(name = "role_id"))
        public Set getRoles() {
            return roles;
        }
        public void setRoles(Set roles) {
            this.roles = roles;
        }
}
