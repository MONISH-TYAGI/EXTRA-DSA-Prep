# Write your MySQL query statement below
select firstname,lastname,city,state from person p1 left join 
address a using(personId);