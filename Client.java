package com.wellsfargo.counselor.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "CLIENT")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clientId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "advisor_id", nullable = false)
    private FinancialAdvisor advisor;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private LocalDate dateOfBirth;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @Column(nullable = false)
    private Boolean isActive;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Portfolio> portfolios;

    protected Client() {}

    public Client(FinancialAdvisor advisor, String firstName, String lastName,
                  String email, String phone, LocalDate dateOfBirth,
                  String address, LocalDateTime createdAt,
                  LocalDateTime updatedAt, Boolean isActive) {
        this.advisor     = advisor;
        this.firstName   = firstName;
        this.lastName    = lastName;
        this.email       = email;
        this.phone       = phone;
        this.dateOfBirth = dateOfBirth;
        this.address     = address;
        this.createdAt   = createdAt;
        this.updatedAt   = updatedAt;
        this.isActive    = isActive;
    }

    public Long getClientId()                    { return clientId; }

    public FinancialAdvisor getAdvisor()         { return advisor; }
    public void setAdvisor(FinancialAdvisor v)   { this.advisor = v; }

    public String getFirstName()                 { return firstName; }
    public void setFirstName(String v)           { this.firstName = v; }

    public String getLastName()                  { return lastName; }
    public void setLastName(String v)            { this.lastName = v; }

    public String getEmail()                     { return email; }
    public void setEmail(String v)               { this.email = v; }

    public String getPhone()                     { return phone; }
    public void setPhone(String v)               { this.phone = v; }

    public LocalDate getDateOfBirth()            { return dateOfBirth; }
    public void setDateOfBirth(LocalDate v)      { this.dateOfBirth = v; }

    public String getAddress()                   { return address; }
    public void setAddress(String v)             { this.address = v; }

    public LocalDateTime getCreatedAt()          { return createdAt; }
    public void setCreatedAt(LocalDateTime v)    { this.createdAt = v; }

    public LocalDateTime getUpdatedAt()          { return updatedAt; }
    public void setUpdatedAt(LocalDateTime v)    { this.updatedAt = v; }

    public Boolean getIsActive()                 { return isActive; }
    public void setIsActive(Boolean v)           { this.isActive = v; }

    public List<Portfolio> getPortfolios()            { return portfolios; }
    public void setPortfolios(List<Portfolio> v)      { this.portfolios = v; }
}