SELECT o.ANIMAL_ID, o.NAME
FROM ANIMAL_INS as i RIGHT OUTER JOIN ANIMAL_OUTS as o
ON o.ANIMAL_ID = i.ANIMAL_ID
WHERE i.DATETIME IS NULL
ORDER BY 1;