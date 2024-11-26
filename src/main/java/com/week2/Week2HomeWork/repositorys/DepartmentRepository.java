package com.week2.Week2HomeWork.repositorys;

import com.week2.Week2HomeWork.entitys.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity , Long> {
}
