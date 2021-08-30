package org.hdcd.repository;

import org.hdcd.domain.CodeGroup;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CodeGroupRepository extends CrudRepository<CodeGroup, String> {

	@Modifying
	@Query("DELETE FROM CodeDetail cd WHERE cd.codeDetailNo=?1")
	public int deleteCodeDetail(Long codeDetailNo);

	@Modifying
	@Query("UPDATE FROM CodeDetail cd SET cd.codeName=?2 WHERE cd.codeDetailNo=?1")
	public int upDateCodeDetailName(Long codeDetailNo,String codeName);

	@Query("SELECT cg.groupCode,cg.groupName,cd.codeValue,cd.codeName,cd.useYn FROM CodeGroup cg INNER JOIN cg.codeDetails cd")
	public List<Object[]> getList();

	@Query("SELECT cg.groupCode,cg.groupName,cd.codeValue,cd.codeName,cd.useYn FROM CodeGroup cg INNER JOIN cg.codeDetails cd ON cg.groupCode = cd.codeGroup")
	public List<Object[]> getList2();

	@Query("SELECT cg.groupCode,cg.groupName,cd.codeValue,cd.codeName,cd.useYn FROM CodeGroup cg INNER JOIN cg.codeDetails cd ON cg.groupCode = cd")
	public List<Object[]> getList3();
}
