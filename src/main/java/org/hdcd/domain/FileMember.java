package org.hdcd.domain;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FileMember {
	private String userId;
	private String password;
	private MultipartFile picture;
	private List<MultipartFile> pictureList;
	
}
