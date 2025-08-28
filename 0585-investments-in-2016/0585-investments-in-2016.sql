# Write your MySQL query statement below
WITH cte_2015 AS (
    -- Find tiv_2015 values that appear more than once
    SELECT tiv_2015
    FROM Insurance
    GROUP BY tiv_2015
    HAVING COUNT(*) > 1
),
cte_unique_locations AS (
    -- Find (lat, lon) pairs that are unique
    SELECT lat, lon
    FROM Insurance
    GROUP BY lat, lon
    HAVING COUNT(*) = 1
)
SELECT ROUND(SUM(tiv_2016), 2) AS tiv_2016
FROM Insurance
WHERE tiv_2015 IN (SELECT tiv_2015 FROM cte_2015)
  AND (lat, lon) IN (SELECT lat, lon FROM cte_unique_locations);
