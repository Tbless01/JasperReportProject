package com.jasperReport.data.repositories;

import com.jasperReport.data.models.StudentResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultRepository extends JpaRepository<StudentResult, Long> {

    @Query("SELECT p FROM StudentResult p WHERE p.firstName = :firstName")
    StudentResult findByFirstName(String firstName);
}
