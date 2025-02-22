package com.javaclass.anatolianweb.repos;

import com.javaclass.anatolianweb.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepo extends JpaRepository<Driver, Integer> {
}