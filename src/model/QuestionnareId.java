package model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class QuestionnareId implements Serializable{
	private static final long serialVersionUID = -4631171674316237517L;

	@ManyToOne
	private Student student;

	@ManyToOne
	private Video video;

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}
}
