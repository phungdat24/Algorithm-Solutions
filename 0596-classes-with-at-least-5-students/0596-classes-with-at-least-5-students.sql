# Write your MySQL query statement below
SELECT 
    class 
From Courses
GROUP BY 
    class
HAVING 
    Count(student) >= 5