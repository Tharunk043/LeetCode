# Write your MySQL query statement below
delete from person
where id not in
(
    select id from (
        select id,row_number() over(partition by email order by id) as rn from person
    ) as t
    where rn =1
)