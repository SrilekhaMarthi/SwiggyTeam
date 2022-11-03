package com.project.Entity;
import java.util.Date;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class Auditable {

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate  
    public Date creditedOn;
 
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    public Date updatedOn;

	public Date getCreditedOn() {
		return creditedOn;
	}
	public void setCreditedOn(Date creditedOn) {
		this.creditedOn = creditedOn;
	}
	public Date getUpdatedOn() {
		return updatedOn;
	}
	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}  
}