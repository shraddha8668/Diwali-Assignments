select empno, ename,sal,deptno from (select empno, ename,sal,deptno,
rank() over(Partition by deptno order by sal desc) as rnk from emp )as t
where rnk <= 5 order by deptno, sal desc;