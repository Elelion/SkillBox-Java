SELECT
    u.`name`,
    u.`email`
FROM `good` g
         JOIN `order2good` o2g ON o2g.good_id = g.id
         JOIN `order` o ON o.id = o2g.order_id
         JOIN `user` u ON u.id = o.user_id
WHERE g.`name` LIKE 'Гватемала%'

UNION

SELECT
    u.`name`,
    u.`email`
FROM `user` u
         JOIN `order` o ON
            o.user_id = u.id AND o.status_id = 4
WHERE
        u.`email` NOT LIKE '%.ru%' AND u.`email` NOT LIKE '%.su%'

UNION

SELECT
    u.`name`,
    u.`email`
FROM `user` u
         JOIN `order` o ON o.user_id = u.id
         JOIN `order2good` o2g ON o2g.order_id = o.id
         JOIN `good` g ON g.id = o2g.good_id AND g.`category_id` = 23;