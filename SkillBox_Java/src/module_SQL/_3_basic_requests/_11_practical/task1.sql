SELECT DISTINCT `status_id` FROM `order`;

SELECT
    `good_id`,
    COUNT(*)
FROM `order2good`
GROUP BY `good_id`
    LIMIT 5;

SELECT DISTINCT
    `src_status_id`,
    `dst_status_id`
FROM `order_status_change`;

SELECT
    os.name,
    COUNT(*) `count`
FROM `order` o
         JOIN `order_status` os ON os.id = o.id
GROUP BY os.name
ORDER BY `count`;

SELECT u.`name`
FROM `user` u
         JOIN `order` o ON o.user_id = u.id
         JOIN `order2good` o2g ON o2g.order_id = o.id
         JOIN `good` g ON g.id = o2g.good_id
WHERE g.`name` LIKE '%пуэр с молоком%';

SELECT
    `id`,
    g.`name`
FROM `good` g
         LEFT JOIN `order2good` o2g ON
        o2g.good_id = g.id
WHERE o2g.order_id IS NULL;