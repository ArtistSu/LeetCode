SELECT C.NAME AS Customers FROM Customers AS C WHERE C.id NOT IN (SELECT CustomerId FROM Orders);