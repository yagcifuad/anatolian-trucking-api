package com.javaclass.anatolianweb.repos;

import com.javaclass.anatolianweb.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {

}
