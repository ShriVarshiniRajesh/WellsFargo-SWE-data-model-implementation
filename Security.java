package com.wellsfargo.counselor.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "SECURITY")
public class Security {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long securityId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "portfolio_id", nullable = false)
    private Portfolio portfolio;

    @Column(nullable = false)
    private String securityName;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private LocalDate purchaseDate;

    @Column(nullable = false, precision = 18, scale = 4)
    private BigDecimal purchasePrice;

    @Column(nullable = false, precision = 18, scale = 8)
    private BigDecimal quantity;

    @Column(nullable = false, precision = 18, scale = 4)
    private BigDecimal currentPrice;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

    protected Security() {}

    public Security(Portfolio portfolio, String securityName, String category,
                    LocalDate purchaseDate, BigDecimal purchasePrice,
                    BigDecimal quantity, BigDecimal currentPrice,
                    LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.portfolio     = portfolio;
        this.securityName  = securityName;
        this.category      = category;
        this.purchaseDate  = purchaseDate;
        this.purchasePrice = purchasePrice;
        this.quantity      = quantity;
        this.currentPrice  = currentPrice;
        this.createdAt     = createdAt;
        this.updatedAt     = updatedAt;
    }

    public Long getSecurityId()                   { return securityId; }

    public Portfolio getPortfolio()               { return portfolio; }
    public void setPortfolio(Portfolio v)         { this.portfolio = v; }

    public String getSecurityName()               { return securityName; }
    public void setSecurityName(String v)         { this.securityName = v; }

    public String getCategory()                   { return category; }
    public void setCategory(String v)             { this.category = v; }

    public LocalDate getPurchaseDate()            { return purchaseDate; }
    public void setPurchaseDate(LocalDate v)      { this.purchaseDate = v; }

    public BigDecimal getPurchasePrice()          { return purchasePrice; }
    public void setPurchasePrice(BigDecimal v)    { this.purchasePrice = v; }

    public BigDecimal getQuantity()               { return quantity; }
    public void setQuantity(BigDecimal v)         { this.quantity = v; }

    public BigDecimal getCurrentPrice()           { return currentPrice; }
    public void setCurrentPrice(BigDecimal v)     { this.currentPrice = v; }

    public LocalDateTime getCreatedAt()           { return createdAt; }
    public void setCreatedAt(LocalDateTime v)     { this.createdAt = v; }

    public LocalDateTime getUpdatedAt()           { return updatedAt; }
    public void setUpdatedAt(LocalDateTime v)     { this.updatedAt = v; }
}