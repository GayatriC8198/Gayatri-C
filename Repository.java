package com.example.login;
import com.springbootapp.auth.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
    public interface Repository extends JpaRepository {
        User findByUsername(String username);
    }
}
