package com.wellsfargo.counselor.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "AUDITLOG")
public class AuditLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long logId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "advisor_id", nullable = false)
    private FinancialAdvisor advisor;

    @Column(nullable = false)
    private String actionType;

    @Column(nullable = false)
    private String entityType;

    @Column(nullable = false)
    private Long entityId;

    @Column(nullable = false)
    private LocalDateTime timestamp;

    @Column(columnDefinition = "TEXT")
    private String details;

    protected AuditLog() {}

    public AuditLog(FinancialAdvisor advisor, String actionType,
                    String entityType, Long entityId,
                    LocalDateTime timestamp, String details) {
        this.advisor    = advisor;
        this.actionType = actionType;
        this.entityType = entityType;
        this.entityId   = entityId;
        this.timestamp  = timestamp;
        this.details    = details;
    }

    public Long getLogId()                           { return logId; }

    public FinancialAdvisor getAdvisor()             { return advisor; }
    public void setAdvisor(FinancialAdvisor v)       { this.advisor = v; }

    public String getActionType()                    { return actionType; }
    public void setActionType(String v)              { this.actionType = v; }

    public String getEntityType()                    { return entityType; }
    public void setEntityType(String v)              { this.entityType = v; }

    public Long getEntityId()                        { return entityId; }
    public void setEntityId(Long v)                  { this.entityId = v; }

    public LocalDateTime getTimestamp()              { return timestamp; }
    public void setTimestamp(LocalDateTime v)        { this.timestamp = v; }

    public String getDetails()                       { return details; }
    public void setDetails(String v)                 { this.details = v; }
}