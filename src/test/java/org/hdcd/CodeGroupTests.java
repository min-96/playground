package org.hdcd;

import org.hdcd.domain.CodeGroup;
import org.hdcd.repository.CodeGroupRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CodeGroupTests {

	@Autowired
	CodeGroupRepository repository;
	
	@Test
	public void testRegister() {
		
		CodeGroup codeGroup = new CodeGroup();
		
		codeGroup.setGroupCode("A01");
		codeGroup.setGroupName("job");
		
		repository.save(codeGroup);
		
		codeGroup = new CodeGroup();
		codeGroup.setGroupCode("A02");
		codeGroup.setGroupName("hobby");
		repository.save(codeGroup);
		
	}
	
	
}
