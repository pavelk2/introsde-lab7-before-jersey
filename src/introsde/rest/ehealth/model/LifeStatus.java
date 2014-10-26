package introsde.rest.ehealth.model;

import introsde.rest.ehealth.dao.LifeCoachDao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;
@Entity  // indicates that this class is an entity to persist in DB
@Table(name="LifeStatus") // to whole table must be persisted 
@NamedQuery(name="LifeStatus.findAll", query="SELECT ls FROM LifeStatus ls")
public class LifeStatus implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id // defines this attributed as the one that identifies the entity
    @GeneratedValue(generator="sqlite_lifestatus")
    @TableGenerator(name="sqlite_lifestatus", table="sqlite_sequence",
        pkColumnName="name", valueColumnName="seq",
        pkColumnValue="Lifestatus")
    @Column(name="idMeasure") // maps the following attribute to a column
    private int idMeasure;
    
    @Column(name="idMeasureDef")
    private int idMeasureDef;
    
    @ManyToOne
    @JoinColumn(name = "idMeasureDef", referencedColumnName = "idMeasureDef", insertable = true, updatable = true)
    private MeasureDefinition measureDefinition;
    @ManyToOne
    @JoinColumn(name="idPerson",referencedColumnName="idPerson")
    private Person person;
    
    @Column(name="value")
    private String value;
    // add below all the getters and setters of all the private attributes
    
    // getters
    public int getIdMeasure(){
    	return idMeasure;
    }
    
    @XmlTransient
    public Person getPerson() {
        return person;
    }
    public int getIdMeasureDef(){
    	return idMeasureDef;
    }
    public String getValue(){
    	return value;
    }
    // setters
    public void setIdMeasure(int idMeasure){
    	this.idMeasure = idMeasure;
    }
    
    public void setPerson(Person person){
    	this.person = person;
    }
    public void setIdMeasureDef(int idMeasureDef){
    	this.idMeasureDef = idMeasureDef;
    }
    public void setValue(String value){
    	this.value = value;
    }
    
    public static Person getPersonById(int personId) {
        EntityManager em = LifeCoachDao.instance.createEntityManager();
        Person p = em.find(Person.class, personId);
        LifeCoachDao.instance.closeConnections(em);
        return p;
    }

    public static List <LifeStatus> getAll() {
        EntityManager em = LifeCoachDao.instance.createEntityManager();
        List<LifeStatus> list = em.createNamedQuery("LifeStatus.findAll", LifeStatus.class)
            .getResultList();
        LifeCoachDao.instance.closeConnections(em);
        return list;
    }

    public static LifeStatus saveLifeStatus(LifeStatus ls) {
        EntityManager em = LifeCoachDao.instance.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(ls);
        tx.commit();
        LifeCoachDao.instance.closeConnections(em);
        return ls;
    } 

    public static LifeStatus updateLifeStatus(LifeStatus ls) {
        EntityManager em = LifeCoachDao.instance.createEntityManager(); 
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        ls=em.merge(ls);
        tx.commit();
        LifeCoachDao.instance.closeConnections(em);
        return ls;
    }

    public static void removeLifeStatus(LifeStatus ls) {
        EntityManager em = LifeCoachDao.instance.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        ls=em.merge(ls);
        em.remove(ls);
        tx.commit();
        LifeCoachDao.instance.closeConnections(em);
    }
}