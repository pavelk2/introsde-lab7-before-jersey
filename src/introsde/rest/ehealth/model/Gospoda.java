package introsde.rest.ehealth.model;

import introsde.rest.ehealth.dao.LifeCoachDao;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="gospoda")
@Table(name="Person") // to whole table must be persisted 
@NamedQuery(name="Person.findAll", query="SELECT p FROM Person p")
public class Gospoda{

    private List<Person> someList;
  
    @XmlElement(name="person")
    public List<Person> getSomeList() {
        return someList;
    }

    public void setSomeList(List<Person> someList) {
        this.someList = someList;
    } 

    public Gospoda(List<Person> someListValue) {
    	this();
        this.someList = someListValue;  
    }

    /**
     * 
     */
    public Gospoda() {
        // TODO Auto-generated constructor stub
    }
}