package org.hdcd;


import java.util.Arrays;

import javax.transaction.Transactional;

import org.hdcd.domain.CodeDetail;
import org.hdcd.domain.CodeGroup;
import org.hdcd.repository.CodeGroupRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CodeGroupTests {

	@Autowired
	CodeGroupRepository repository;
	
//	@Test
//	public void testRegister() {
//		
//		CodeGroup codeGroup = new CodeGroup();
//		
//		codeGroup.setGroupCode("A01");
//		codeGroup.setGroupName("job");
//		
//		repository.save(codeGroup);
//		
//		codeGroup = new CodeGroup();
//		codeGroup.setGroupCode("A02");
//		codeGroup.setGroupName("hobby");
//		repository.save(codeGroup);
//		
//	}
	
//	@Test
//	public void testRegisterWithCodeDetail() {
//		
//
//		CodeGroup codeGroup = new CodeGroup();
//		
//		codeGroup.setGroupCode("A01");
//		codeGroup.setGroupName("job");
//		
//		CodeDetail codeDetail =new CodeDetail();
//		codeDetail.setCodeValue("00");
//		codeDetail.setCodeName("Devleoper");
//		
//		CodeDetail codeDetail2 = new CodeDetail();
//		codeDetail2.setCodeValue("01");
//		codeDetail2.setCodeName("Designer");
//		
//		
//		codeGroup.setCodeDetails(Arrays.asList(codeDetail,codeDetail2));
//		
//		repository.save(codeGroup);
//	}
//	
	
	@Transactional
	@Test
	public void testList() {
		Iterable<CodeGroup> codeGroupList = repository.findAll();
		
		
		for(CodeGroup codeGroup :codeGroupList) {
			System.out.println(codeGroup);
			
			Iterable<CodeDetail> codeDetailList = codeGroup.getCodeDetails();
			
			for(CodeDetail cd :codeDetailList) {
				System.out.println(cd);
			}
		}
		
}
	
}
