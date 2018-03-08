package model;

import java.io.Serializable;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "questionnare")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@AssociationOverrides({
	@AssociationOverride(name = "student", joinColumns = @JoinColumn(name = "id")),
	@AssociationOverride(name = "video", joinColumns = @JoinColumn(name = "id"))
})
public class Questionnare implements Serializable{
	private static final long serialVersionUID = -8686237974877803285L;

	@EmbeddedId
	private QuestionnareId pk = new QuestionnareId();
	
	public QuestionnareId getPk() {
		return pk;
	}

	public void setPk(QuestionnareId pk) {
		this.pk = pk;
	}

	@Transient
	public Student getStudent() {
		return getPk().getStudent();
	}

	public void setStudent(Student student) {
		getPk().setStudent(student);
	}

	@Transient
	public Video getVideo() {
		return getPk().getVideo();
	}

	public void setVideo(Video video) {
		getPk().setVideo(video);
	}

}
