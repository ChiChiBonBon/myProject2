package bean01_3;

import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.util.ArrayList;

public class SocialBean_3 implements Serializable{
	
	String comment_num;
	String comment;
	ArrayList DBcomment_num;
	ArrayList DBcomment;
	
	public SocialBean_3(){
	}
	
	public ArrayList getDBcomment_num() {
		return DBcomment_num;
	}

	public void setDBcomment_num(ArrayList dBcomment_num) {
		DBcomment_num = dBcomment_num;
	}

	public ArrayList getDBcomment() {
		return DBcomment;
	}

	public void setDBcomment(ArrayList dBcomment) {
		DBcomment = dBcomment;
	}

	public SocialBean_3(String comment_num,String comment) {
		this.comment_num=comment_num;
		this.comment=comment;
	}
	
	public String getComment_num() {
		return comment_num;
	}
	public void setComment_num(String comment_num) {
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
		return "SocialBean_3 [comment_num=" + comment_num + ", comment=" + comment + "]";
	}

}
