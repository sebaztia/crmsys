package com.crm.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "legacy_client")
public @Data
class LegacyClient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "email")
    private String email;

    @Column(name = "ref_number")
    private String refNumber;

    @Column(name = "record_date")
   // @DateTimeFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private Date recordDate;

    @Column(name = "call_sheet")
    private String callSheet;

    @Column(name = "call_id")
    private Integer callId;

    @Column(name = "contact_number")
    private String contactNumber;

    @Column(name = "staff_name")
    private String staffName;


    @Column(name = "created_at", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @PrePersist
    public void onPrePersist() {
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }

    @PreUpdate
    public void onPreUpdate() {
        this.updatedAt = new Date();
    }
}
