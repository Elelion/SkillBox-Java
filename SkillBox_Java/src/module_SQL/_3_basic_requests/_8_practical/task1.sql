SELECT `id`, `name`, `count`
FROM SkillBox_Shop.good
ORDER BY `count` DESC LIMIT 5;

SELECT `id`, `email`, `reg_date`
FROM `user`
ORDER BY `reg_date`
DESC LIMIT 3;

SELECT `name`, `count`, `price`
FROM SkillBox_Shop.good
ORDER BY `count`
DESC, `price` LIMIT 10, 6;
