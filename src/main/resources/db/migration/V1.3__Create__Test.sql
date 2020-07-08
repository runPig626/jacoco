CREATE TABLE `test_` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

INSERT INTO `test_` VALUES (1,'product 1'),(2,'product 2'),(3,'flyway db'),(4,'h2 product');