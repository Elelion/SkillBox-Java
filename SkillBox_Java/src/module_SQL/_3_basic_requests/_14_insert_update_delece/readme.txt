• INSERT - используются для вставки данных в таблицу
Пример 1 (одиночный запрос):
INSERT INTO skillbox.good (
    `id`,
    `category_id`,
    `name`,
    `count`,
    `price`
)
VALUES (
    2088,
    6,
    'new record',
    50,
    355
);

Пример 2 (множественный запрос):
INSERT INTO skillbox.good (`id`, `category_id`, `name`, `count`, `price`)
VALUES (2088, 6, 'new record', 50, 355),
(2095, 6, 'new record1', 51, 356),
(2099, 6, 'new record2', 52, 357);

• UPDATE - обновить запись в таблице, те внести какие либо данные.
Пример (значению name где id=1, подставит указанное значение):
UPDATE good SET name = 'WebDev' WHERE id = 1;

• DELETE - удалить запись.
Пример:
DELETE FROM `good` WHERE `id` = 1373;
