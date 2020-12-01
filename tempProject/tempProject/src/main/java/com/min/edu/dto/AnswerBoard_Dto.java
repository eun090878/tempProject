package com.min.edu.dto;

import java.io.Serializable;
import java.util.Date;

public class AnswerBoard_Dto implements Serializable {

	private static final long serialVersionUID = -1883111503411392702L;

	private int seq;
	private String id;
	private String title;
	private String content;
	private int refer;
	private int step;
	private int depth;
	private int readcount;
	private String delfalg;
	private String regdate;
	private String blank = "&nbsp;&nbsp;&nbsp;";
	private String img = "<img alt='reply' src='./image/reply.png'>";

	public AnswerBoard_Dto() {
	}

	public AnswerBoard_Dto(int seq, String id, String title, String content, int refer, int step, int depth,
			int readcount, String delfalg, String regdate, String blank, String img) {
		super();
		this.seq = seq;
		this.id = id;
		this.title = title;
		this.content = content;
		this.refer = refer;
		this.step = step;
		this.depth = depth;
		this.readcount = readcount;
		this.delfalg = delfalg;
		this.regdate = regdate;
		this.blank = blank;
		this.img = img;
	}

	@Override
	public String toString() {
		return "AnswerBoard_Dto [seq=" + seq + ", id=" + id + ", title=" + title + ", content=" + content + ", refer="
				+ refer + ", step=" + step + ", depth=" + depth + ", readcount=" + readcount + ", delfalg=" + delfalg
				+ ", regdate=" + regdate + ", blank=" + blank + ", img=" + img + "]";
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public String getBoardListTitle() {
		String result = "";
		if (getDelfalg() == ("Y")) {
			return "관리자에 의해 삭제된 글입니다.";
		} else {
			if (title.length() > 5) {
				title = title.substring(0, 5) + "...";
				if (depth > 0) {
					for (int i = 0; i < depth; i++) {
						result += blank;
					}
					result += img;
				}
				return result + title;
			} else {
				if (depth > 0) {
					for (int i = 0; i < depth; i++) {
						result += blank;
					}
					result += img;
				}
				return result + title;
			}
		}
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getRefer() {
		return refer;
	}

	public void setRefer(int refer) {
		this.refer = refer;
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public int getReadcount() {
		return readcount;
	}

	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}

	public String getDelfalg() {
		return delfalg;
	}

	public void setDelfalg(String delfalg) {
		this.delfalg = delfalg;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getBlank() {
		return blank;
	}

	public void setBlank(String blank) {
		this.blank = blank;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

}
