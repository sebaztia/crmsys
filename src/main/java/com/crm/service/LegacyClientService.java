package com.crm.service;

import com.crm.model.CallList;
import com.crm.model.LegacyClient;
import com.crm.model.Product;
import com.crm.repository.LegacyClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LegacyClientService {

    private LegacyClientRepository legacyClientRepository;

    @Autowired
    public LegacyClientService(LegacyClientRepository legacyClientRepository) {
        this.legacyClientRepository = legacyClientRepository;
    }

    public LegacyClient getLegacyClientByCallListId(Integer callId) {
        return legacyClientRepository.findByCallId(callId);
    }

    public LegacyClient getLegacyClientById(Integer id) {
        return legacyClientRepository.findOne(id);
    }

    public LegacyClient save(LegacyClient legacyClient) {
        return legacyClientRepository.save(legacyClient);
    }

    public Page<LegacyClient> getAllLegacyClient(Pageable pageable) {
        return legacyClientRepository.findAll(pageable);
    }

    public List<LegacyClient> getAllByRefNumber(String refNumber, Integer id) {
        return legacyClientRepository.findAllByRefNumberAndIdIsNot(refNumber, id);
    }
}
