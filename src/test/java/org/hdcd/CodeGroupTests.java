package org.hdcd;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.aspectj.apache.bcel.classfile.Code;
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
//
//		codeGroup = new CodeGroup();
//		codeGroup.setGroupCode("A02");
//		codeGroup.setGroupName("hobby");
//		repository.save(codeGroup);
//
//	}
	
	@Test
	public void testRegisterWithCodeDetail() {


		CodeGroup codeGroup = new CodeGroup();

		codeGroup.setGroupCode("A01");
		codeGroup.setGroupName("job");

		CodeDetail codeDetail =new CodeDetail();
		codeDetail.setCodeValue("00");
		codeDetail.setCodeName("Devleoper");

		CodeDetail codeDetail2 = new CodeDetail();
		codeDetail2.setCodeValue("01");
		codeDetail2.setCodeName("Designer");


		codeGroup.setCodeDetails(Arrays.asList(codeDetail,codeDetail2));

		repository.save(codeGroup);
	}

	//목록조회테스트
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
	//상세조회테스트
	@Transactional
	@Test
	public void testRead(){
		Optional<CodeGroup> codeGroupOptional = repository.findById("A01");

		if(codeGroupOptional.isPresent()){
			CodeGroup codeGroup = codeGroupOptional.get();

			List<CodeDetail> codeDetails = codeGroup.getCodeDetails();
			for(CodeDetail code : codeDetails){
				System.out.println(code);

			}
		}
	}
	//그룹네임 수정 테스트
	@Test
	public void testModify(){
		Optional<CodeGroup> codeGroupOptional = repository.findById("A01");

		if(codeGroupOptional.isPresent()){
			CodeGroup codeGroup = codeGroupOptional.get();
			System.out.println("CodeGroup:" + codeGroup );

			codeGroup.setGroupName("hobby");


			repository.save(codeGroup);
		}
	}



//
	@Test
	public void testModify1() {
		Optional<CodeDetail> codeDetailOptional = codeDetailRepository.findById(1L);

		if(codeDetailOptional.isPresent()) {
			CodeDetail codeDetail = codeDetailOptional.get();
			codeDetail.setCodeName("Architech");

			codeDetailRepository.save(codeDetail);


		}

	}
	
	
	
	@Transactional
	@Test
	public void testModifyCodeDetail() {
		Optional<CodeGroup> codeGroupOptional = repository.findById("A01");

		if(codeGroupOptional.isPresent()) {
			CodeGroup codeGroup = codeGroupOptional.get();

			List<CodeDetail> codeDetails = codeGroup.getCodeDetails();

			System.out.println("codeDetails : "+ codeDetails);
			System.out.println("codeDetails.size() : " + codeDetails.size());


			CodeDetail codeDetailForSearch = new CodeDetail();
			codeDetailForSearch.setCodeDetailNo(1L);

			//찾고자 하는 인덱스가 있을경우 0반환
			int idx = codeDetails.indexOf(codeDetailForSearch);

			System.out.println("idx : " +idx);

			if(idx > -1) {

				codeDetails.remove(idx);

				codeDetailForSearch.setCodeName("Architect");

				codeDetails.add(codeDetailForSearch);

				codeGroup.setCodeDetails(codeDetails);

				repository.save(codeGroup);
			}



		}

	}
	
//	
	@Transactional
	@Test
	public void testModifyCodeDetail2() {
		Optional<CodeGroup> codeGroupOptional = repository.findById("A01");

		if(codeGroupOptional.isPresent()) {
			CodeGroup codeGroup = codeGroupOptional.get();

			List<CodeDetail> codeDetail = codeGroup.getCodeDetails();

			System.out.println("codeDetail : " +codeDetail);
			System.out.println("codeDetailSize: " +codeDetail.size());
			CodeDetail targetCodeDetail = codeDetail.get(0);
			System.out.println("targetCodeDetail: "+ targetCodeDetail);

			targetCodeDetail.setCodeName("Architect");
			//targetCodeDetail.setCodeValue("03");
			//codeGroup.setCodeDetails(codeDetail);
			repository.save(codeGroup);
		}
	}
	
//	
	@Transactional
	@Test
	public void TestModifyCodeDetailAtTransactional() {
		Long codeDetailId = 1L;
		String codeName = "Architect";


		int count = repository.upDateCodeDetailName(codeDetailId, codeName);
		System.out.println("count : "+count);
	}
	
//	
	@Test
	public void testRemove() {
		repository.deleteById("A01");
	}
	
	
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
	
//	@Transactional
//	@Test
//	public void testRemoveWithCodeByQuery() {
//		String groupCode="A01";
//		repository.deleteCodeDetail(codeDetailNo);
//
//		//System.out.println("count" + count);
//
//		repository.deleteById(groupCode);
//	}
}
