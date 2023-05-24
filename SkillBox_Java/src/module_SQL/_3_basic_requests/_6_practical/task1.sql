SELECT `id`, `name` FROM SkillBox_Shop.good WHERE count > 518;

SELECT `id`, `name`, `price` FROM SkillBox_Shop.good WHERE count = 0 AND price >= 300;

SELECT `id`, `name` FROM SkillBox_Shop.good WHERE `name` LIKE '%таежный%';

SELECT `id`, `name`
FROM `good`
WHERE `name` LIKE '%манго%'
  AND `name` NOT LIKE '%айс%';

SELECT `id`, `name`, `reg_date`
FROM `user`
WHERE `name` LIKE '% Иван%'
  AND `reg_date` >= '2017-03-01'
  AND `reg_date` < '2017-12-01';