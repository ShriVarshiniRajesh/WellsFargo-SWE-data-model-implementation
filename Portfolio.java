package com.wellsfargo.counselor.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "PORTFOLIO")
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long portfolioId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", nullable = false, unique = true)
    private Client client;

    @Column(nullable = false)
    private String portfolioName;

    @Column(nullable = false, precision = 18, scale = 2)
    private BigDecimal totalValue;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Security> securities;

    protected Portfolio() {}

    public Portfolio(Client client, String portfolioName,
                     BigDecimal totalValue, LocalDateTime createdAt,
                     LocalDateTime updatedAt) {
        this.client        = client;
        this.portfolioName = portfolioName;
        this.totalValue    = totalValue;
        this.createdAt     = createdAt;
        this.updatedAt     = updatedAt;
    }

    public Long getPortfolioId()                  { return portfolioId; }

    public Client getClient()                     { return client; }
    public void setClient(Client v)               { this.client = v; }

    public String getPortfolioName()              { return portfolioName; }
    public void setPortfolioName(String v)        { this.portfolioName = v; }

    public BigDecimal getTotalValue()             { return totalValue; }
    public void setTotalValue(BigDecimal v)       { this.totalValue = v; }

    public LocalDateTime getCreatedAt()           { return createdAt; }
    public void setCreatedAt(LocalDateTime v)     { this.createdAt = v; }

    public LocalDateTime getUpdatedAt()           { return updatedAt; }
    public void setUpdatedAt(LocalDateTime v)     { this.updatedAt = v; }

    public List<Security> getSecurities()         { return securities; }
    public void setSecurities(List<Security> v)   { this.securities = v; }
}