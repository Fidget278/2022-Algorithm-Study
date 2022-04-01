-- 링크 : https://programmers.co.kr/learn/courses/30/lessons/7748

SELECT *
FROM PLACES
WHERE HOST_ID = ANY(
    SELECT HOST_ID
    FROM PLACES
    GROUP BY HOST_ID
    HAVING COUNT(*) > 1
    ORDER BY ID ASC
    )
ORDER BY ID ASC
