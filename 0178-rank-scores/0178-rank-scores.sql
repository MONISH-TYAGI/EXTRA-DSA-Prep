# Write your MySQL query statement below
select score ,(select COUNT(DISTINCT score) from scores where s1.score<=score) 'rank' from scores s1 
order by 
score desc;