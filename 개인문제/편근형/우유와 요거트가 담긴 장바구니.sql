-- https://programmers.co.kr/learn/courses/30/lessons/62284

SELECT milk.cart_id
FROM (SELECT DISTINCT cart_id FROM cart_products WHERE name='Milk') AS milk
JOIN (SELECT DISTINCT cart_id FROM cart_products WHERE name='Yogurt') AS yogurt
ON milk.cart_id = yogurt.cart_id
