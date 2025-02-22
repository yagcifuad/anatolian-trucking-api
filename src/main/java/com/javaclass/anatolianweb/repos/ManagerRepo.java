package com.javaclass.anatolianweb.repos;

import com.javaclass.anatolianweb.model.Driver;
import com.javaclass.anatolianweb.model.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepo extends JpaRepository<Manager, Integer> {
}