# spring-mybatis-oracle-storedproc
The procedure used:

CREATE OR REPLACE procedure MYTESTPROCEDURE
( inStr in varchar2, outStr out varchar2, outStr2 out varchar2)
is
begin 
outStr := inStr || ' testing';
outStr2 := inStr || ' testing again';
end MYTESTPROCEDURE;
