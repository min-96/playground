package org.hdcd;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.hdcd.domain.CodeDetail;
import org.hdcd.domain.CodeGroup;
import org.hdcd.repository.CodeDetailRepository;
import org.hdcd.repository.CodeGroupRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest
public class CodeGroupTests {

	@Autowired
	CodeGroupRepository repository;
	
	@Autowired
	CodeDetailRepository codeDetailRepository;
	
//	@Test
//	public void testRegister() {
//		
//		CodeGroup codeGroup = new CodeGroup();
//		
//		codeGroup.setGroupCode("A01");
//		codeGroup.setGroupName("job");
//		
//		repository.save(codeGroup);
		
//		codeGroup = new CodeGroup();
//		codeGroup.setGroupCode("A02");
//		codeGroup.setGroupName("hobby");
//		repository.save(codeGroup);
		
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
	
//	@Transactional
//	@Test
//	public void testList() {
//		Iterable<CodeGroup> codeGroupList = repository.findAll();
//		
//		
//		for(CodeGroup codeGroup :codeGroupList) {
//			System.out.println(codeGroup);
//			
//			Iterable<CodeDetail> codeDetailList = codeGroup.getCodeDetails();
//			
//			for(CodeDetail cd :codeDetailList) {
//				System.out.println(cd);
//			}
//		}
//		
//}
	
//	@Test
//	public void testModify() {
//		Optional<CodeDetail> codeDetailOptional = codeDetailRepository.findById(3L);
//		
//		if(codeDetailOptional.isPresent()) {
//			CodeDetail codeDetail = codeDetailOptional.get();
//			codeDetail.setCodeName("Architech");
//			
//			codeDetailRepository.save(codeDetail);
//		
//		
//		}
//		
//	}
	
	
	
//	@Transactional
//	@Test
//	public void testModifyCodeDetail() {
//		Optional<CodeGroup> codeGroupOptional = repository.findById("A01");
//		
//		if(codeGroupOptional.isPresent()) {
//			CodeGroup codeGroup = codeGroupOptional.get();
//			
//			List<CodeDetail> codeDetails = codeGroup.getCodeDetails();
//			
//			System.out.println("codeDetails : "+ codeDetails);
//			System.out.println("codeDetails.size() : " + codeDetails.size());
//			
//			
//			CodeDetail codeDetailForSearch = new CodeDetail();
//			codeDetailForSearch.setCodeDetailNo(1L);
//			
//			int idx = codeDetails.indexOf(codeDetailForSearch);
//			
//			System.out.println("idx : " +idx);
//			
//			if(idx > -1) {
//			
//				codeDetails.remove(idx);
//				
//				codeDetailForSearch.setCodeName("Architect");
//				
//				codeDetails.add(codeDetailForSearch);
//				
//				codeGroup.setCodeDetails(codeDetails);
//			
//				repository.save(codeGroup);
//			}
//			
//			
//			
//		}
//		
//	}
	
//	
//	@Transactional
//	@Test
//	public void testModifyCodeDetail2() {
//		Optional<CodeGroup> codeGroupOptional = repository.findById("A01");
//		
//		if(codeGroupOptional.isPresent()) {
//			CodeGroup codeGroup = codeGroupOptional.get();
//			
//			List<CodeDetail> codeDetail = codeGroup.getCodeDetails();
//			
//			CodeDetail targetCodeDetail = codeDetail.get(0);
//			
//			targetCodeDetail.setCodeName("Architect");
//			repository.save(codeGroup);
//		}
//	}
	
//	
//	@Transactional
//	@Test
//	public void TestModifyCodeDetailAtTransactional() {
//		Long codeDetailId = 2L;
//		String codeName = "Architech";
//		
//		int count = repository.upDateCodeDetailName(codeDetailId, codeName);
//		
//	}
	
//	
//	@Test
//	public void testRemove() {
//		repository.deleteById("A01");
//	}
	
	
//	
//	@Test
//	public void testRegisterWithCodeDetail() {
//		CodeGroup codeGroup = new CodeGroup();
//		
//		codeGroup.setGroupCode("A01");
//		codeGroup.setGroupName("job");
//		
//		repository.save(codeGroup);
//		
//		CodeDetail codeDeatil = new CodeDetail();
//		codeDeatil.setCodeValue("00");
//		codeDeatil.setCodeName("Developer");
//		codeDeatil.setCodeGroup(codeGroup);
//		
//		codeDetailRepository.save(codeDeatil);
//		
//		CodeDetail codeDeatil1 = new CodeDetail();
//		codeDeatil1.setCodeValue("00");
//		codeDeatil1.setCodeName("Developer");
//		codeDeatil1.setCodeGroup(codeGroup);
//		
//		codeDetailRepository.save(codeDeatil1);
//		
//		
//	}
	
	@Transactional
	@Test
	public void testRemoveWithCodeByQuery() {
		String groupCode="A01";
		repository.deleteAllCodeDetail(groupCode);
		
		//System.out.println("count" + count);
		
		repository.deleteById(groupCode);
	}
}
