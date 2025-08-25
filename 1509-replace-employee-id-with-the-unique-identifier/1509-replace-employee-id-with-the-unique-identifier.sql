# Write your MySQL query statement below
select eu.unique_id,em.name
from Employees em
left join EmployeeUNI eu
on em.id=eu.id 
