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
@Table(name = "video")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Video {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

	@OneToMany(mappedBy = "pk.video", cascade = { CascadeType.PERSIST })
    private List<Questionnare> questionnares = new ArrayList<Questionnare>();
	
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
