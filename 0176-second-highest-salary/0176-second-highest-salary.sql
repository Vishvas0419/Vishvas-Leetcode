# Write your MySQL query statement below
select (select MAX(salary) from Employee where salary != (select MAX(salary) from Employee)) AS SecondHighestSalary