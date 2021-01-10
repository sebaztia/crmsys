package com.crm.repository;

import com.crm.model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepository extends JpaRepository<Staff, Integer> {

    Staff findByStaffName(String staffName);
}
