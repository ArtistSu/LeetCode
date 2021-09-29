SELECT Email FROM (SELECT Email, count(Email) AS NUM FROM Person GROUP BY Email) AS SUB_SEARCH WHERE NUM > 1;
SELECT Email FROM Person GROUP BY Email Having COUNT(Email) >1;