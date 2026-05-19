SELECT A.MEMBER_NAME, C.REVIEW_TEXT, DATE_FORMAT(C.REVIEW_DATE, '%Y-%m-%d') AS 'REVIEW_DATE'
FROM `MEMBER_PROFILE` AS A
INNER JOIN (SELECT *
            FROM `REST_REVIEW`
            GROUP BY `MEMBER_ID`
            HAVING COUNT(*) >= (SELECT COUNT(*)
                                FROM `REST_REVIEW`
                                GROUP BY `MEMBER_ID`
                                ORDER BY 1 DESC
                                LIMIT 1)
           ) AS B
ON A.MEMBER_ID = B.MEMBER_ID
INNER JOIN `REST_REVIEW` AS C
ON B.MEMBER_ID = C.MEMBER_ID
ORDER BY `REVIEW_DATE`, C.REVIEW_TEXT