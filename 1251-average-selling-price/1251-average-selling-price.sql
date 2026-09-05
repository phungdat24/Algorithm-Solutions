# Write your MySQL query statement below
SELECT
    gia.product_id,
    IFNULL(ROUND((SUM(gia.price * sl.units))/sum(sl.units),2),0) AS average_price
FROM Prices gia
LEFT JOIN UnitsSold sl
ON 
    gia.product_id = sl.product_id
    AND sl.purchase_date BETWEEN gia.start_date AND gia.end_date
GROUP BY 
    gia.product_id