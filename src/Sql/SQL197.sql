# Write your MySQL query statement below
# DATEDIFF(Today, Yesterday)
select w1.id as id
from Weather w1
join
Weather w2
on DATEDIFF(w1.recordDate, w2.recordDate) = 1 and w1.temperature > w2.temperature;

SELECT
    w1.id
FROM
    Weather w1
        LEFT JOIN
    Weather w2
    ON
        w1.recordDate = DATE_ADD(w2.recordDate, INTERVAL 1 DAY)
WHERE
    w1.temperature > w2.temperature
;