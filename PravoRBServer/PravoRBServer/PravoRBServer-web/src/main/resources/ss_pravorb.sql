-- --------------------------------------------------------
-- Хост:                         veress.ddns.net
-- Версия сервера:               5.6.21-log - MySQL Community Server (GPL)
-- ОС Сервера:                   Win64
-- HeidiSQL Версия:              9.1.0.4867
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Дамп структуры базы данных ss_pravorb
CREATE DATABASE IF NOT EXISTS `ss_pravorb` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `ss_pravorb`;


-- Дамп структуры для таблица ss_pravorb.acts
CREATE TABLE IF NOT EXISTS `acts` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `part` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK__parts` (`part`),
  CONSTRAINT `FK__parts` FOREIGN KEY (`part`) REFERENCES `parts` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы ss_pravorb.acts: ~1 rows (приблизительно)
DELETE FROM `acts`;
/*!40000 ALTER TABLE `acts` DISABLE KEYS */;
INSERT INTO `acts` (`id`, `part`) VALUES
	(1, 11),
	(2, 11);
/*!40000 ALTER TABLE `acts` ENABLE KEYS */;


-- Дамп структуры для таблица ss_pravorb.favorites
CREATE TABLE IF NOT EXISTS `favorites` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `act` int(10) unsigned NOT NULL DEFAULT '0',
  `user` int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `act_user` (`act`,`user`),
  KEY `FK_favorites_acts` (`act`),
  KEY `FK_favorites_users` (`user`),
  CONSTRAINT `FK_favorites_acts` FOREIGN KEY (`act`) REFERENCES `acts` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_favorites_users` FOREIGN KEY (`user`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы ss_pravorb.favorites: ~0 rows (приблизительно)
DELETE FROM `favorites`;
/*!40000 ALTER TABLE `favorites` DISABLE KEYS */;
INSERT INTO `favorites` (`id`, `act`, `user`) VALUES
	(1, 1, 6);
/*!40000 ALTER TABLE `favorites` ENABLE KEYS */;


-- Дамп структуры для таблица ss_pravorb.groups
CREATE TABLE IF NOT EXISTS `groups` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы ss_pravorb.groups: ~3 rows (приблизительно)
DELETE FROM `groups`;
/*!40000 ALTER TABLE `groups` DISABLE KEYS */;
INSERT INTO `groups` (`id`, `name`) VALUES
	(1, 'Администраторы'),
	(2, 'Модераторы'),
	(3, 'Пользователи');
/*!40000 ALTER TABLE `groups` ENABLE KEYS */;


-- Дамп структуры для таблица ss_pravorb.history
CREATE TABLE IF NOT EXISTS `history` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `act` int(10) unsigned NOT NULL DEFAULT '0',
  `text` int(10) unsigned NOT NULL DEFAULT '0',
  `user` int(10) unsigned DEFAULT '0',
  `time_edit` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `FK_history_acts` (`act`),
  KEY `FK_history_texts` (`text`),
  KEY `FK_history_users` (`user`),
  CONSTRAINT `FK_history_acts` FOREIGN KEY (`act`) REFERENCES `acts` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_history_texts` FOREIGN KEY (`text`) REFERENCES `texts` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_history_users` FOREIGN KEY (`user`) REFERENCES `users` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы ss_pravorb.history: ~3 rows (приблизительно)
DELETE FROM `history`;
/*!40000 ALTER TABLE `history` DISABLE KEYS */;
INSERT INTO `history` (`id`, `act`, `text`, `user`, `time_edit`) VALUES
	(2, 1, 1, 1, '2014-11-28 17:00:28'),
	(3, 1, 2, 1, '2014-12-11 03:26:55'),
	(4, 2, 3, 1, '2014-12-11 03:32:21'),
	(5, 2, 4, 1, '2014-12-11 03:32:38');
/*!40000 ALTER TABLE `history` ENABLE KEYS */;


-- Дамп структуры для представление ss_pravorb.last_acts
-- Создание временной таблицы для обработки ошибок зависимостей представлений
CREATE TABLE `last_acts` (
	`id` INT(10) UNSIGNED NOT NULL,
	`act` INT(10) UNSIGNED NOT NULL,
	`part` INT(10) UNSIGNED NOT NULL,
	`text` INT(10) UNSIGNED NOT NULL,
	`user` INT(10) UNSIGNED NULL,
	`time_edit` TIMESTAMP NULL
) ENGINE=MyISAM;


-- Дамп структуры для таблица ss_pravorb.parts
CREATE TABLE IF NOT EXISTS `parts` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `parent` int(10) unsigned NOT NULL DEFAULT '0',
  `name` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8 COMMENT='Разделы Национального реестра правовых актов РБ';

-- Дамп данных таблицы ss_pravorb.parts: ~26 rows (приблизительно)
DELETE FROM `parts`;
/*!40000 ALTER TABLE `parts` DISABLE KEYS */;
INSERT INTO `parts` (`id`, `parent`, `name`) VALUES
	(1, 0, 'Раздел 1'),
	(2, 0, 'Раздел 2'),
	(3, 0, 'Раздел 3'),
	(4, 0, 'Раздел 4'),
	(5, 0, 'Раздел 5'),
	(6, 0, 'Раздел 6'),
	(7, 0, 'Раздел 7'),
	(8, 0, 'Раздел 8'),
	(9, 0, 'Раздел 9'),
	(10, 0, 'Раздел 10'),
	(11, 1, 'Конституция Республики Беларусь'),
	(12, 1, 'Решения республиканских референдумов'),
	(13, 1, 'Декреты, указы, распоряжения Президента Республики Беларусь'),
	(14, 2, 'Законы Республики Беларусь'),
	(15, 3, 'Международные договоры Республики Беларусь'),
	(16, 4, 'Постановления Палаты представителей Национального собрания Республики Беларусь'),
	(17, 4, 'Постановления Совета Республики Национального собрания Республики Беларусь'),
	(18, 5, 'Постановления Совета Министров Республики Беларусь'),
	(19, 5, 'Распоряжения Премьер-министра Республики Беларусь'),
	(20, 6, 'Заключения и иные решения Конституционного Суда, за исключением запросов, требований и других решений процедурного характера'),
	(21, 6, 'Постановления Пленума Верховного Суда по вопросам применения законодательства Республики Беларусь, возникающим при рассмотрении судебных дел'),
	(22, 7, 'Правовые акты Администрации Президента Республики Беларусь'),
	(23, 7, 'Нормативные правовые акты Комитета государственного контроля, Следственного комитета, Государственного комитета судебных экспертиз, Управления делами Президента Республики Беларусь, иных государственных органов, непосредственно подчиненных (подотчетных) Президенту Республики Беларусь'),
	(24, 8, 'Нормативные правовые акты Национального банка, Национальной академии наук Беларуси, министерств, иных республиканских органов государственного управления'),
	(25, 9, 'Нормативные правовые акты областных, Минского городского Советов депутатов, облисполкомов, Минского горисполкома, местных Советов депутатов, исполнительных и распорядительных органов базового территориального уровня'),
	(26, 9, 'Решения, принятые областным, Минским городским, районным, городским (городов областного подчинения) референдумом'),
	(27, 10, 'Другие нормативные акты');
/*!40000 ALTER TABLE `parts` ENABLE KEYS */;


-- Дамп структуры для функция ss_pravorb.pr_user_auth
DELIMITER //
CREATE DEFINER=`root`@`localhost` FUNCTION `pr_user_auth`(`login` VARCHAR(50), `password` VARCHAR(50)) RETURNS int(11)
BEGIN
	DECLARE buf int;
	SELECT (count(*)>0) INTO buf FROM `users` WHERE `users`.`login`=login AND `users`.`password`=MD5(MD5(password));
	IF buf=0 
		THEN
			return buf;
		ELSE
			SELECT `users`.`id` INTO buf FROM `users` WHERE `users`.`login`=login AND `users`.`password`=MD5(MD5(password));
			return buf;
		END IF;
END//
DELIMITER ;


-- Дамп структуры для процедура ss_pravorb.pr_user_changepassword
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `pr_user_changepassword`(IN `id` INT, IN `password` VARCHAR(50))
BEGIN
	UPDATE `users` SET `users`.`password`=MD5(MD5(password)) WHERE `users`.`id`=id;
END//
DELIMITER ;


-- Дамп структуры для процедура ss_pravorb.pr_user_changepasswordsecure
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `pr_user_changepasswordsecure`(IN `id` INT, IN `oldpassword` VARCHAR(50), IN `newpassword` VARCHAR(50))
BEGIN
	DECLARE buf varchar(32);
	SELECT `users`.`password` INTO buf FROM `users` WHERE `users`.`id`=id;
	IF MD5(MD5(oldpassword))=buf
		THEN
			UPDATE `users` SET `users`.`password`=MD5(MD5(newpassword)) WHERE `users`.`id`=id;
		END IF;
END//
DELIMITER ;


-- Дамп структуры для процедура ss_pravorb.pr_user_create
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `pr_user_create`(IN `login` VARCHAR(50), IN `password` VARCHAR(50))
BEGIN
	INSERT INTO `users` (`users`.`login`, `users`.`password`) VALUES (login, MD5(MD5(password)));
END//
DELIMITER ;


-- Дамп структуры для процедура ss_pravorb.pr_user_setgroup
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `pr_user_setgroup`(IN `id` INT, IN `groupid` INT)
BEGIN
	UPDATE `users` SET `users`.`group`=groupid WHERE `users`.`id`=id;
END//
DELIMITER ;


-- Дамп структуры для процедура ss_pravorb.pr_user_setinfo
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `pr_user_setinfo`(IN `id` INT, IN `firstname` TINYTEXT, IN `lastname` TINYTEXT, IN `email` VARCHAR(50), IN `address` TINYTEXT, IN `zipcode` VARCHAR(10), IN `telephone` TINYTEXT)
BEGIN
	DECLARE buf int;
	SELECT (count(*)>0) INTO buf FROM `users` WHERE `users`.`id`=id;
	IF buf>0 
		THEN
			UPDATE `users` SET 
				`users`.`firstname`=firstname, 
				`users`.`lastname`=lastname,
				`users`.`email`=email,
				`users`.`address`=address,
				`users`.`zipcode` = zipcode,
				`users`.`telephone`=telephone				  
			WHERE `users`.`id`=id;
		END IF;
END//
DELIMITER ;


-- Дамп структуры для таблица ss_pravorb.texts
CREATE TABLE IF NOT EXISTS `texts` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` text NOT NULL,
  `text` longtext NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='Правовые акты\r\nСтатус: 1 - создан, 0 - для отката';

-- Дамп данных таблицы ss_pravorb.texts: ~4 rows (приблизительно)
DELETE FROM `texts`;
/*!40000 ALTER TABLE `texts` DISABLE KEYS */;
INSERT INTO `texts` (`id`, `name`, `text`) VALUES
	(1, 'Текст конституции РБ', 'КОНСТИТУЦИЯ ЗДЕСЬ!'),
	(2, 'Вторая редакция конст', 'ЗДЕСЬ ЗДЕСЬ!!!'),
	(3, 'Первая редакция второго тома', '1'),
	(4, 'Вторая редакция', '2');
/*!40000 ALTER TABLE `texts` ENABLE KEYS */;


-- Дамп структуры для таблица ss_pravorb.users
CREATE TABLE IF NOT EXISTS `users` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `login` varchar(20) NOT NULL,
  `password` varchar(32) NOT NULL,
  `firstname` tinytext,
  `lastname` tinytext,
  `email` varchar(50) DEFAULT NULL,
  `address` tinytext,
  `zipcode` varchar(10) DEFAULT NULL,
  `telephone` tinytext,
  `group` int(10) unsigned NOT NULL DEFAULT '3',
  PRIMARY KEY (`id`),
  UNIQUE KEY `login` (`login`),
  KEY `FK_users_groups` (`group`),
  CONSTRAINT `FK_users_groups` FOREIGN KEY (`group`) REFERENCES `groups` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы ss_pravorb.users: ~3 rows (приблизительно)
DELETE FROM `users`;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`id`, `login`, `password`, `firstname`, `lastname`, `email`, `address`, `zipcode`, `telephone`, `group`) VALUES
	(1, 'admin', 'fb469d7ef430b0baf0cab6c436e70375', 'Марина', 'Андреенко', 'test@test.by', 'адрес здесь', '210004', '+375-29-897-82-52', 1),
	(4, 'moderator', 'fb469d7ef430b0baf0cab6c436e70375', 'Модератор', 'Модераторович', 'test@test.by', 'адрес здесь', '210004', '+375-29-897-82-52', 2),
	(6, 'user', 'fb469d7ef430b0baf0cab6c436e70375', 'Юзер', 'Юзерович', 'test@test.by', 'адрес', '210004', '+375-29-897-82-52', 3);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;


-- Дамп структуры для триггер ss_pravorb.history_after_delete
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION';
DELIMITER //
CREATE TRIGGER `history_after_delete` AFTER DELETE ON `history` FOR EACH ROW BEGIN
	DELETE FROM texts WHERE OLD.text=texts.id;
END//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;


-- Дамп структуры для представление ss_pravorb.last_acts
-- Удаление временной таблицы и создание окончательной структуры представления
DROP TABLE IF EXISTS `last_acts`;
CREATE ALGORITHM=UNDEFINED DEFINER=`veress`@`%` VIEW `last_acts` AS SELECT history.id, history.act, acts.part, history.text, history.user, MAX(history.time_edit) as time_edit
FROM history
INNER JOIN acts ON acts.id = history.act
WHERE acts.part=11
GROUP BY history.act ;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
