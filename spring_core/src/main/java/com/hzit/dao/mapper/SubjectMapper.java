package com.hzit.dao.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import com.hzit.dao.entity.Subject;
import com.fc.platform.commons.page.Page;
import com.fc.platform.commons.page.Pageable;

public interface SubjectMapper {

	void insertSubject(Subject subject);

	void deleteSubjectBySubjectNo(Integer subjectNo);

	void updateSubject(Subject subject);

	Page<Subject> searchSubjectByParams(@Param("map") Map<String, String> map, Pageable pageable);

	List<Subject> searchSubjectByParams(@Param("map") Map<String, String> map);

} 
