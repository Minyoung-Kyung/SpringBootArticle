package net.developia.boot_article.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class ArticleDTO implements Serializable {
	private long bno;
	private String title;
	private String name;
	private String content;
	private Date regdate;
	private int readcount;
	private String password;
}