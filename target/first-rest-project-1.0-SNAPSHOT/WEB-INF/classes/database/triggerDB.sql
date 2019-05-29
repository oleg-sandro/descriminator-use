USE `service`;

--
-- Trigger for seats generation when insert new hall
--

DELIMITER ;;
CREATE TRIGGER `hall_AFTER_INSERT` AFTER INSERT ON `hall` FOR EACH ROW BEGIN
	DECLARE r INTEGER DEFAULT NEW.rows;
	DECLARE c INTEGER DEFAULT NEW.cols;
	DECLARE i INTEGER DEFAULT 1;
	DECLARE j INTEGER DEFAULT 1;
	WHILE i <= r DO
		WHILE j<=c DO
			INSERT INTO seat (`id_hall`, `row`, `number`) VALUES (NEW.id, i, j);
			SET j = j + 1;
		END WHILE;
		SET j = 1;
		SET i = i + 1;
	END WHILE;
END;;
DELIMITER ;