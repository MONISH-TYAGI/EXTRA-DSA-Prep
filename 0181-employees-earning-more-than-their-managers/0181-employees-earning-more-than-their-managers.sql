# Write your MySQL query statement below
select e1.name as Employee from employee e1 inner join employee e2 ON e1.managerid=e2.id and  e1.salary>e2.salary ;