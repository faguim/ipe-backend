package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "questionnareteste")
public class QuestionnareTest {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
	
	private String name;
	private int animation;
	private int layout;
	private int narrative;
	private int video;
	
	private String question2;
	private String question2Others;

	private String question3;
	private boolean question4;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAnimation() {
		return animation;
	}
	public void setAnimation(int animation) {
		this.animation = animation;
	}
	public int getLayout() {
		return layout;
	}
	public void setLayout(int layout) {
		this.layout = layout;
	}
	public int getNarrative() {
		return narrative;
	}
	public void setNarrative(int narrative) {
		this.narrative = narrative;
	}
	public int getVideo() {
		return video;
	}
	public void setVideo(int video) {
		this.video = video;
	}
	public String getQuestion3() {
		return question3;
	}
	public void setQuestion3(String question3) {
		this.question3 = question3;
	}
	public boolean isQuestion4() {
		return question4;
	}
	public void setQuestion4(boolean question4) {
		this.question4 = question4;
	}
	public String getQuestion2() {
		return question2;
	}
	public void setQuestion2(String question2) {
		this.question2 = question2;
	}
	public String getQuestion2Others() {
		return question2Others;
	}
	public void setQuestion2Others(String question2Others) {
		this.question2Others = question2Others;
	}
}
