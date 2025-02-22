package com.javaclass.anatolianweb.repos;

import com.javaclass.anatolianweb.model.Checkpoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckpointRepository extends JpaRepository<Checkpoint, Integer> {
}
