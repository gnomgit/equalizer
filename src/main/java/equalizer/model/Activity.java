package equalizer.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
public class Activity { 

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="id", scope=Person.class)
	@ManyToOne
    @JoinColumn(name="owner_id")
    private Person owner;
	
	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="id", scope=Person.class)
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(	name = "person_activity", 
				joinColumns = @JoinColumn(name = "activity_id", referencedColumnName = "id"), 
				inverseJoinColumns = @JoinColumn(name = "person_id", referencedColumnName = "id"))
	private List<Person> participants;
	
	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="id", scope=Task.class)
	@OneToMany(mappedBy = "activity")
	private List<Task> tasks;
	
	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="id", scope=Payment.class)
	@OneToMany(mappedBy = "activity")
	private List<Payment> payments;
	
	private String name;
	private String modified;
	private String description;
	private Date date;

	private boolean calculated = false;

	private double total = 0.0;
	
	public Date getDate() {
		return date;
	}
	public String getDescription() {
		return description;
	}
		
	public long getId() {
		return id;
	}

	public String getModified() {
		return modified;
	}

	public String getName() {
		return name;
	}

	public Person getOwner() {
		return owner;
	}

	public List<Person> getParticipants() {
		return participants;
	}
	
	public List<Payment> getPayments() {
		return payments;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public double getTotal() {
		return total;
	}

	public boolean isCalculated() {
		return calculated;
	}
	
	public void setCalculated(boolean calculated) {
		this.calculated = calculated;
		updateModified();
	}

	public void setDate(Date date) {
		this.date = date;
		updateModified();
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setModified(String modified) {
		this.modified = modified;
	}

	public void setName(String name) {
		this.name = name;
		updateModified();
	}

	public void setOwner(Person owner) {
		this.owner = owner;
		updateModified();
	}

	public void setParticipants(List<Person> participants) {
		this.participants = participants;
		updateModified();
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
		updateModified();
	}
	
	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
		updateModified();
	}

	public void setTotal(double total) {
		this.total = total;
		updateModified();
	}

	private void updateModified() {
		Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        modified = sdf.format(cal.getTime());
	}
}
