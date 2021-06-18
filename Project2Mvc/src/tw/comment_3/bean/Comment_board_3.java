package tw.comment_3.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "comment_board_3")
@Component("comment_board_3")
public class Comment_board_3 implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer comment_num;
	String comment;
	
	public Comment_board_3(){
	}

	public Comment_board_3(Integer comment_num,String comment) {
		this.comment_num=comment_num;
		this.comment=comment;
	}
	
	public Integer getComment_num() {
		return comment_num;
	}
	public void setComment_num(Integer comment_num) {
		this.comment_num = comment_num;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Comment_board_3 [comment_num=");
		sb.append(comment_num);
		sb.append(",comment=");
		sb.append(comment);
		sb.append("]");
		return sb.toString();
	}

}
