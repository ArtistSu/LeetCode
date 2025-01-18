SELECT
    e1.name as Employee
FROM
    Employee e1, Employee e2
WHERE
    e1.managerId = e2.id AND
    e1.salary > e2.salary
;