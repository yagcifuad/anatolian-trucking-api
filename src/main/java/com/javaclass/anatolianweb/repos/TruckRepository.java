package com.javaclass.anatolianweb.repos;

import com.javaclass.anatolianweb.model.Truck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TruckRepository extends JpaRepository<Truck, Integer> {
}
