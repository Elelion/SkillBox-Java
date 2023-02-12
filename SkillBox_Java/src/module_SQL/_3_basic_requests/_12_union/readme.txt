• UNION - объеденяет результат выполнения SELECT запроса в единую таблицу.
Объединять можно разные запросы , от двух и более, рассмотрим на примере
объединение 2х запросов.

Пример:
SELECT o.id, o.creation_date
FROM `order` o
JOIN `order_status` s
ON s.id = o.status_id
WHERE s.code IN ('APPROVED_BY_STOCK', 'PACKED')

UNION

SELECT o.id, o.creation_date
FROM `order` o
JOIN `user` u ON u.id = o.user_id
WHERE u.reg_date BETWEEN '2018-02-01' AND '2018-02-28';