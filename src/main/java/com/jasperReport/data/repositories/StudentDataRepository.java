package com.jasperReport.data.repositories;

import com.jasperReport.data.models.StudentData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentDataRepository extends JpaRepository<StudentData, Long> {
    StudentData findByFirstName(String firstName);
}
