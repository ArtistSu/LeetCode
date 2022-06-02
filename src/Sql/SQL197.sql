# Write your MySQL query statement below
# DATEDIFF(Today, Yesterday)
select w1.id as id
from Weather w1
join
Weather w2
on DATEDIFF(w1.recordDate, w2.recordDate) = 1 and w1.temperature > w2.temperature;