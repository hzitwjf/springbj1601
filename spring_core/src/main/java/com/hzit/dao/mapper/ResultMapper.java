package com.hzit.dao.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import com.hzit.dao.entity.Result;
import com.fc.platform.commons.page.Page;
import com.fc.platform.commons.page.Pageable;

public interface ResultMapper {

	void insertResult(Result result);

	void deleteResultByStudentPk(Integer studentPk);

	void updateResult(Result result);

	Page<Result> searchResultByParams(@Param("map") Map<String, String> map, Pageable pageable);

	List<Result> searchResultByParams(@Param("map") Map<String, String> map);

} 
