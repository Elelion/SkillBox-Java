• DISTINCT - используется для удаления дубликатов из набора результатов. Используется только в месте с SELECT (важно!)

Пример 1 (простой):
SELECT DISTINCT `status_id` FROM `order`;

Пример 2 (более сложный):
SELECT DISTINCT
	s1.name,
    s2.name
FROM `order_status_change` ch
JOIN `order_status` s1 ON s1.id = ch.src_status_id
JOIN `order_status` s2 ON s2.id = ch.dst_status_id
WHERE 1;

• GROUP BY - позволяют сгруппировать данные. Они употребляются в рамках команды SELECT. COUNT(*) - выводит количество элементов в каждой группе. ВАЖНО: ORDER BY  пишется ВСЕГДА после GROUP BY !!!

Пример 1:
SELECT
	`category_id`,
	COUNT(*)
FROM `good`
GROUP BY `category_id`;

Пример 2 (более сложный):
SELECT
	c.name,
	COUNT(*) 'count'
FROM `good` g
JOIN `good_category` c ON c.id = g.category_id
GROUP BY g.category_id
ORDER BY `count` DESC;
