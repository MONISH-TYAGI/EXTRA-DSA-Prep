CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  RETURN (
      # Write your MySQL query statement below.
      select distinct(salary) as getNthHighestSalary from Employee w1 where N=(
      select COUNT(DISTINCT(w2.salary)) from Employee w2 where w2.salary>=w1.salary
      )
  );
END