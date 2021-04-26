DROP TABLE IF EXISTS `pessoas`;

CREATE TABLE `pessoas` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `data_nascimento` date NOT NULL,
  `email` varchar(50),
  `cpf` varchar(14) NOT NULL,
  `sexo` varchar(1),
  `naturalidade` varchar(100),
  `nacionalidade` varchar(100),
  `data_criacao` date NOT NULL,
  `data_atualizacao` date ,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_pessoas_cpf` (`cpf`),
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

