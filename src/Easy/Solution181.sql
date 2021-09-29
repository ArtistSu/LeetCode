
SELECT A.Name AS 'Employee' FROM Employee AS A, Employee AS B WHERE A.ManagerId = B.Id AND A.Salary > B.Salary;
SELECT A.Name AS 'Employee' FROM Employee AS A INNER JOIN Employee AS B WHERE A.ManagerId = B.Id AND A.Salary > B.Salary;