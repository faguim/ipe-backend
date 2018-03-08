package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "student")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Student {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
	
	private String name;
	private String email;
	
	@OneToMany(mappedBy = "pk.student", cascade = { CascadeType.PERSIST })
    private List<Questionnare> questionnares = new ArrayList<Questionnare>();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public List<Questionnare> getQuestionnares() {
		return questionnares;
	}
	public void setQuestionnares(List<Questionnare> questionnares) {
		this.questionnares = questionnares;
	}
}