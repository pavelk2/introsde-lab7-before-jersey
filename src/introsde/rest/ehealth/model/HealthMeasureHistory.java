package introsde.rest.ehealth.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the "HealthMeasureHistory" database table.
 * 
 */
@Entity
@Table(name="\"HealthMeasureHistory\"")
@NamedQuery(name="HealthMeasureHistory.findAll", query="SELECT h FROM HealthMeasureHistory h")
public class HealthMeasureHistory implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id // defines this attributed as the one that identifies the entity
    @GeneratedValue(generator="sqlite_healthmeasurehistory")
    @TableGenerator(name="sqlite_healthmeasurehistory", table="sqlite_sequence",
        pkColumnName="name", valueColumnName="seq",
        pkColumnValue="HealthMeasureHistory")
	@Column(name="\"idMeasureDef\"")
	private Object idMeasureDef;

	@Column(name="\"idMeasureDefinition\"")
	private int idMeasureDefinition;

	@Column(name="\"idMeasureHistory\"")
	private int idMeasureHistory;

	@Column(name="\"idPerson\"")
	private int idPerson;

	@Temporal(TemporalType.DATE)
	@Column(name="\"timestamp\"")
	private Date timestamp;

	@Column(name="\"value\"")
	private String value;

	public HealthMeasureHistory() {
	}

	public Object getIdMeasureDef() {
		return this.idMeasureDef;
	}

	public void setIdMeasureDef(Object idMeasureDef) {
		this.idMeasureDef = idMeasureDef;
	}

	public int getIdMeasureDefinition() {
		return this.idMeasureDefinition;
	}

	public void setIdMeasureDefinition(int idMeasureDefinition) {
		this.idMeasureDefinition = idMeasureDefinition;
	}

	public int getIdMeasureHistory() {
		return this.idMeasureHistory;
	}

	public void setIdMeasureHistory(int idMeasureHistory) {
		this.idMeasureHistory = idMeasureHistory;
	}

	public int getIdPerson() {
		return this.idPerson;
	}

	public void setIdPerson(int idPerson) {
		this.idPerson = idPerson;
	}

	public Date getTimestamp() {
		return this.timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}