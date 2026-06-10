package com.wellsfargo.counselor.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "FINANCIALADVISOR")
public class FinancialAdvisor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long advisorId;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false, unique = true)
    private String licenseNumber;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @Column(nullable = false)
    private Boolean isActive;

    @OneToMany(mappedBy = "advisor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Client> clients;

    @OneToMany(mappedBy = "advisor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<AuditLog> auditLogs;

    protected FinancialAdvisor() {}

    public FinancialAdvisor(String firstName, String lastName, String email,
                             String phone, String licenseNumber,
                             LocalDateTime createdAt, LocalDateTime updatedAt,
                             Boolean isActive) {
        this.firstName    = firstName;
        this.lastName     = lastName;
        this.email        = email;
        this.phone        = phone;
        this.licenseNumber = licenseNumber;
        this.createdAt    = createdAt;
        this.updatedAt    = updatedAt;
        this.isActive     = isActive;
    }

    public Long getAdvisorId()              { return advisorId; }

    public String getFirstName()            { return firstName; }
    public void setFirstName(String v)      { this.firstName = v; }

    public String getLastName()             { return lastName; }
    public void setLastName(String v)       { this.lastName = v; }

    public String getEmail()                { return email; }
    public void setEmail(String v)          { this.email = v; }

    public String getPhone()                { return phone; }
    public void setPhone(String v)          { this.phone = v; }

    public String getLicenseNumber()        { return licenseNumber; }
    public void setLicenseNumber(String v)  { this.licenseNumber = v; }

    public LocalDateTime getCreatedAt()          { return createdAt; }
    public void setCreatedAt(LocalDateTime v)     { this.createdAt = v; }

    public LocalDateTime getUpdatedAt()          { return updatedAt; }
    public void setUpdatedAt(LocalDateTime v)     { this.updatedAt = v; }

    public Boolean getIsActive()            { return isActive; }
    public void setIsActive(Boolean v)      { this.isActive = v; }

    public List<Client> getClients()        { return clients; }
    public void setClients(List<Client> v)  { this.clients = v; }

    public List<AuditLog> getAuditLogs()         { return auditLogs; }
    public void setAuditLogs(List<AuditLog> v)   { this.auditLogs = v; }
}