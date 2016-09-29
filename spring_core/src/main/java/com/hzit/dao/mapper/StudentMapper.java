package com.hzit.dao.mapper;

import java.util.List;
import java.util.Map;

import com.hzit.dao.vo.StudentVo;
import org.apache.ibatis.annotations.Param;
import com.hzit.dao.entity.Student;
import com.fc.platform.commons.page.Page;
import com.fc.platform.commons.page.Pageable;

public interface StudentMapper {

	void insertStudent(Student student);

	void deleteStudentByStudentNo(Integer studentNo);

	void updateStudent(Student student);
	Student findById(Integer studentNo);
	Page<StudentVo> searchStudentByParams(@Param("map") Map<String, String> map, Pageable pageable);

	List<StudentVo> searchStudentByParams(@Param("map") Map<String, String> map);

} 
