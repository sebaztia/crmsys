package com.crm.repository;

import com.crm.model.LegacyClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LegacyClientRepository extends JpaRepository<LegacyClient, Integer> {

    LegacyClient findByCallId(Integer callId);
    List<LegacyClient> findAllByRefNumberAndIdIsNot(String refNumber, Integer id);
}
