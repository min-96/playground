package org.hdcd.vo;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class PageRequestVO {
	
	private int page;
	private int sizePerPage;

	public PageRequestVO() {
		this.page=1;
		this.sizePerPage=10;
	}
	
	public void setPage(int Page) {
		if(page<=0) {
			this.page=1;
			return;
		}
		this.page=page;
	}
	
	public void setSizePerPage(int size) {
		if(size<=0 ||size>100) {
			this.sizePerPage=10;
			return;
		}
		this.sizePerPage=size;
	}
	
	
	public int getPage() {
		
		return page;
	}

	public int getSizePerPage() {
		return this.sizePerPage;
	}

	
	public int getPageStart() {
		return(this.page-1)*sizePerPage;
	}
	
	public String toUriString() {
		UriComponents uriComponents= UriComponentsBuilder.newInstance()
				.queryParam("page", this.page)
				.queryParam("size", this.sizePerPage)
				.build();
		
		return uriComponents.toUriString();
		
	}
	
}
