package com.javaclass.anatolianweb.repos;

import com.javaclass.anatolianweb.model.Destination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DestinationRepository extends JpaRepository<Destination, Integer> {
}
