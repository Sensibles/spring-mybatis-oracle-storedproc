package io.sanjay.mapper;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;
import org.springframework.stereotype.Repository;

import io.sanjay.entity.DbEntity;

@Repository
public interface DbMapper {

	
	 @Select(value= "{ CALL SANJKUMA_ONEPWDBADMIN.MYTESTPROCEDURE( " +
	 " #{inStr, mode=IN, javaType = java.lang.String, jdbcType=VARCHAR}," +
	 " #{outStr, mode=OUT, javaType = java.lang.String, jdbcType=VARCHAR},"
	 + " #{outStr2, mode=OUT, javaType = java.lang.String, jdbcType=VARCHAR})}")
	 
	@Options(statementType = StatementType.CALLABLE)
	@ResultType(DbEntity.class)
	@Results({ 
		@Result(property = "inStr", column = "inStr"),
		@Result(property = "outStr", column = "outStr"),
		@Result(property = "outStr2", column = "outStr2"),
	})
	public void callProc(DbEntity params);

}
