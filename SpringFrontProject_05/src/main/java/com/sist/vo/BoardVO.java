package com.sist.vo;

import lombok.Data;
import java.util.*;

import org.springframework.web.multipart.MultipartFile;

@Data
public class BoardVO {
	private int no, hit, filecount;
	private String name, subject, content, pwd, dbday, filename, filesize;
	private Date regdate;
	private List<MultipartFile> files;
}
