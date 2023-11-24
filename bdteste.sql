-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 24/11/2023 às 04:29
-- Versão do servidor: 10.4.28-MariaDB
-- Versão do PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `bdteste`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `estoque`
--

CREATE TABLE `estoque` (
  `id_estoque` int(11) NOT NULL,
  `lote` int(11) DEFAULT NULL,
  `secao` varchar(100) DEFAULT NULL,
  `quantidade` int(11) DEFAULT NULL,
  `chegada` datetime(6) DEFAULT NULL,
  `saida` datetime(6) DEFAULT NULL,
  `descricao` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `tbl_cliente`
--

CREATE TABLE `tbl_cliente` (
  `id_clien` bigint(20) UNSIGNED NOT NULL,
  `clien_Nome` varchar(100) DEFAULT NULL,
  `clien_Cpf` varchar(20) DEFAULT NULL,
  `clien_Email` varchar(100) DEFAULT NULL,
  `clien_Telefone` varchar(25) DEFAULT NULL,
  `clien_Cep` varchar(20) DEFAULT NULL,
  `clien_Endereco` varchar(100) DEFAULT NULL,
  `clien_Cidade` varchar(100) DEFAULT NULL,
  `clien_Estado` varchar(100) DEFAULT NULL,
  `clien_Sexo` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `tbl_cliente`
--

INSERT INTO `tbl_cliente` (`id_clien`, `clien_Nome`, `clien_Cpf`, `clien_Email`, `clien_Telefone`, `clien_Cep`, `clien_Endereco`, `clien_Cidade`, `clien_Estado`, `clien_Sexo`) VALUES
(1, 'Carlos Henrique dos Santos Frederico', '111.111.111-11', 'carloshenrique@gmail.com', '(88) 98628-5279', '25223-600', 'Rua Maripa, Jardim Primavera', 'Duque de Caxias', 'Rio de Janeiro (RJ)', 'Masculino'),
(2, 'Juliana da Silva Freitas', '222.222.222-22', 'juliana@gmail.com', '(51) 99689-6808', '55514-212', 'Rua jucelino', 'Belford Roxo', 'Rio de Janeiro (RJ)', 'Feminino'),
(3, 'Renato Augusto de Almeida', '333.333.333-33', 'renato@gmail.com', '(91) 97107-4947', '74491-812', 'Rua Dourada', 'Rio Bonito', 'Rio de Janeiro (RJ)', 'Masculino');

-- --------------------------------------------------------

--
-- Estrutura para tabela `tbl_funcionario`
--

CREATE TABLE `tbl_funcionario` (
  `id_func` bigint(20) UNSIGNED NOT NULL,
  `func_Nome` varchar(100) DEFAULT NULL,
  `func_Cpf` varchar(20) DEFAULT NULL,
  `func_Email` varchar(100) DEFAULT NULL,
  `func_Data` date DEFAULT NULL,
  `func_Sexo` varchar(50) DEFAULT NULL,
  `func_Telefone` varchar(30) DEFAULT NULL,
  `func_Telefone2` varchar(30) DEFAULT NULL,
  `func_Cep` varchar(15) DEFAULT NULL,
  `func_Endereco` varchar(100) DEFAULT NULL,
  `func_Cidade` varchar(100) DEFAULT NULL,
  `func_Estado` varchar(50) DEFAULT NULL,
  `func_Cargo` varchar(30) DEFAULT NULL,
  `func_Turno` varchar(30) DEFAULT NULL,
  `func_Salario` double DEFAULT NULL,
  `func_Situacao` varchar(20) DEFAULT NULL,
  `func_User` varchar(100) DEFAULT NULL,
  `func_Senha` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `tbl_funcionario`
--

INSERT INTO `tbl_funcionario` (`id_func`, `func_Nome`, `func_Cpf`, `func_Email`, `func_Data`, `func_Sexo`, `func_Telefone`, `func_Telefone2`, `func_Cep`, `func_Endereco`, `func_Cidade`, `func_Estado`, `func_Cargo`, `func_Turno`, `func_Salario`, `func_Situacao`, `func_User`, `func_Senha`) VALUES
(1, 'Administrador', '', '', NULL, '', '', '', '', '', '', '', 'Gerente', '', NULL, 'Ativo', 'admin', 'admin'),
(2, 'Davi Costa de Oliveira', '414.165.425-74', 'davicosta@gmail.com', '2005-04-19', 'Masculino', '(16)54651-5646', '(54)64651-5615', '25223-600', 'Rua Maripa', 'Duque de Caxias', 'Rio de Janeiro (RJ)', 'Gerente', 'Tarde', 2000, 'Ativo', 'Davi', '123'),
(3, 'Gabriel de Andrade Santos', '321.654.560-23', 'gabrielandrade@gmail.com', '2004-11-23', 'Masculino', '(15)71231-6547', '(24)71646-5462', '25265-008', 'Rua da Jaqueira, Jardim Primavera', 'Duque de Caxias', 'Rio de Janeiro (RJ)', 'Estoquista', 'Manhã', 1500, 'Ativo', 'Gabriel', '123'),
(4, 'Maria Eduarda da Silva Pinheiro', '465.165.135-12', 'dudamaria@gmail.com', '2000-06-08', 'Feminino', '(14)11113-3265', '(23)75241-4545', '25223-075', 'Rua Sagres, Parque Moderno', 'Duque de Caxias', 'Rio de Janeiro (RJ)', 'Caixa', 'Tarde', 1700, 'Ativo', 'Maria', '123'),
(5, 'Carlos Henrique dos Santos', '015.921.400-92', 'carlos@gmail.com', '2005-11-11', 'Masculino', '(83)98076-8744', '(79)98978-0518', '25223-600', 'Rua Maripa, Jardim Primavera', 'Duque de Caxias', 'Rio de Janeiro (RJ)', 'Caixa', 'Manhã', 1233.5, 'Inativo', 'Carlos Henrique', 'carlos');

-- --------------------------------------------------------

--
-- Estrutura para tabela `tbl_produto`
--

CREATE TABLE `tbl_produto` (
  `id_Produto` bigint(20) UNSIGNED NOT NULL,
  `prod_Nome` varchar(100) DEFAULT NULL,
  `prod_NomeFornec` varchar(100) DEFAULT NULL,
  `prod_DataRegistro` date DEFAULT NULL,
  `prod_Categoria` varchar(100) DEFAULT NULL,
  `prod_Quantidade` int(11) DEFAULT NULL,
  `prod_Tamanho` varchar(100) DEFAULT NULL,
  `prod_Preco` double DEFAULT NULL,
  `prod_Desconto` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `tbl_produto`
--

INSERT INTO `tbl_produto` (`id_Produto`, `prod_Nome`, `prod_NomeFornec`, `prod_DataRegistro`, `prod_Categoria`, `prod_Quantidade`, `prod_Tamanho`, `prod_Preco`, `prod_Desconto`) VALUES
(2, 'Camisa Nike Plus', 'Nike', '2023-11-09', 'Camisetas', 42, 'G', 10, 0),
(3, 'Short ADIDAS', 'ADIDAS', '2023-11-15', 'Shorts', 100, 'M', 20, 10),
(4, 'Camiseta Básica', 'CottonStyle', '2023-11-22', 'Camisetas', 147, 'M', 29, 10),
(5, 'Calça Jeans Skinny ', 'Denim Trends ', '2023-11-22', 'Calça', 50, 'M', 80, 15),
(6, 'Vestido Floral ', 'FashionFlora', '2023-11-22', 'Vestido', 30, 'P', 55, 5),
(7, 'Blusa de Moletom com Capuz', 'CozyWear', '2023-11-22', 'Moletom', 7, 'G', 50, 0);

-- --------------------------------------------------------

--
-- Estrutura para tabela `vendas`
--

CREATE TABLE `vendas` (
  `id_vendas` bigint(20) UNSIGNED NOT NULL,
  `cpf_cliente` varchar(20) NOT NULL,
  `ven_data` date NOT NULL,
  `ven_Hora` time NOT NULL,
  `ven_valor_liquido` double NOT NULL,
  `ven_valor_bruto` double NOT NULL,
  `ven_Troco` double NOT NULL,
  `ven_TipoPagamento` varchar(50) NOT NULL,
  `ven_NomeCli` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `vendas`
--

INSERT INTO `vendas` (`id_vendas`, `cpf_cliente`, `ven_data`, `ven_Hora`, `ven_valor_liquido`, `ven_valor_bruto`, `ven_Troco`, `ven_TipoPagamento`, `ven_NomeCli`) VALUES
(1, '111.111.111-11', '2023-11-17', '12:18:42', 159.9, 319.8, 80.19, 'Dinheiro', 'Carlos Henrique dos Santos Frederico'),
(2, '111.111.111-11', '2023-11-17', '17:50:00', 36.48, 72.97, 27.03, 'Dinheiro', 'Carlos Henrique dos Santos Frederico'),
(3, '111.111.111-11', '2023-11-17', '20:25:11', 536.48, 1072.97, 1927.03, 'Dinheiro', 'Carlos Henrique dos Santos Frederico'),
(4, '111.111.111-11', '2023-11-17', '10:00:00', 63.96, 127.92, 0, 'Cartão', 'Carlos Henrique dos Santos Frederico'),
(5, '111.111.111-11', '2023-11-22', '22:49:07', 77.4, 86, 0, 'Cartão', 'Carlos Henrique dos Santos Frederico'),
(6, '111.111.111-11', '2023-11-22', '22:53:49', 93.6, 104, 16, 'Dinheiro', 'Carlos Henrique dos Santos Frederico'),
(7, '111.111.111-11', '2023-11-22', '23:14:58', 59.4, 66, 0, 'Pix', 'Carlos Henrique dos Santos Frederico'),
(8, '222.222.222-22', '2023-11-23', '00:10:23', 128.3, 128.3, 0, 'Pix', 'Juliana da Silva Freitas'),
(9, '333.333.333-33', '2023-11-23', '00:26:45', 97.13, 102.25, 7.75, 'Dinheiro', 'Renato Augusto de Almeida'),
(10, '333.333.333-33', '2023-11-23', '00:36:27', 442.46, 465.75, 0, 'Pix', 'Renato Augusto de Almeida'),
(11, '333.333.333-33', '2023-11-24', '00:25:56', 291.78, 324.2, 0, 'Pix', 'Renato Augusto de Almeida');

-- --------------------------------------------------------

--
-- Estrutura para tabela `venda_produto`
--

CREATE TABLE `venda_produto` (
  `id_ven_produto` bigint(20) UNSIGNED NOT NULL,
  `fk_produto` bigint(20) UNSIGNED NOT NULL,
  `fk_vendas` bigint(20) UNSIGNED NOT NULL,
  `ven_pro_valor` double NOT NULL,
  `ven_pro_quant` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `venda_produto`
--

INSERT INTO `venda_produto` (`id_ven_produto`, `fk_produto`, `fk_vendas`, `ven_pro_valor`, `ven_pro_quant`) VALUES
(1, 2, 2, 10, 4),
(2, 3, 2, 10, 4),
(3, 2, 3, 10, 4),
(4, 3, 3, 10, 4),
(5, 3, 3, 10, 4),
(6, 3, 3, 10, 4),
(7, 3, 3, 10, 4),
(8, 3, 3, 10, 4),
(9, 3, 3, 10, 4),
(10, 3, 3, 10, 4),
(11, 3, 3, 10, 4),
(12, 3, 3, 10, 4),
(13, 3, 3, 10, 4),
(14, 3, 3, 10, 4),
(15, 2, 4, 10.99, 4),
(16, 2, 4, 10.99, 4),
(17, 3, 4, 10.99, 4),
(18, 2, 5, 18, 2),
(19, 3, 5, 18, 2),
(20, 2, 6, 18, 3),
(21, 3, 6, 18, 3),
(22, 2, 7, 18, 2),
(23, 3, 7, 18, 2),
(24, 4, 8, 50, 1),
(25, 7, 8, 50, 1),
(26, 7, 9, 52.25, 1),
(27, 6, 9, 52.25, 1),
(28, 7, 10, 52.25, 7),
(29, 6, 10, 52.25, 7);

--
-- Índices para tabelas despejadas
--

--
-- Índices de tabela `estoque`
--
ALTER TABLE `estoque`
  ADD PRIMARY KEY (`id_estoque`);

--
-- Índices de tabela `tbl_cliente`
--
ALTER TABLE `tbl_cliente`
  ADD UNIQUE KEY `id_clien` (`id_clien`);

--
-- Índices de tabela `tbl_funcionario`
--
ALTER TABLE `tbl_funcionario`
  ADD UNIQUE KEY `id_func` (`id_func`);

--
-- Índices de tabela `tbl_produto`
--
ALTER TABLE `tbl_produto`
  ADD UNIQUE KEY `id_Produto` (`id_Produto`);

--
-- Índices de tabela `vendas`
--
ALTER TABLE `vendas`
  ADD PRIMARY KEY (`id_vendas`),
  ADD KEY `fkcliente` (`cpf_cliente`);

--
-- Índices de tabela `venda_produto`
--
ALTER TABLE `venda_produto`
  ADD PRIMARY KEY (`id_ven_produto`),
  ADD KEY `fkproduto` (`fk_produto`),
  ADD KEY `fkvenda` (`fk_vendas`) USING BTREE;

--
-- AUTO_INCREMENT para tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `estoque`
--
ALTER TABLE `estoque`
  MODIFY `id_estoque` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `tbl_cliente`
--
ALTER TABLE `tbl_cliente`
  MODIFY `id_clien` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de tabela `tbl_funcionario`
--
ALTER TABLE `tbl_funcionario`
  MODIFY `id_func` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de tabela `tbl_produto`
--
ALTER TABLE `tbl_produto`
  MODIFY `id_Produto` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de tabela `vendas`
--
ALTER TABLE `vendas`
  MODIFY `id_vendas` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de tabela `venda_produto`
--
ALTER TABLE `venda_produto`
  MODIFY `id_ven_produto` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- Restrições para tabelas despejadas
--

--
-- Restrições para tabelas `venda_produto`
--
ALTER TABLE `venda_produto`
  ADD CONSTRAINT `venda_produto_ibfk_1` FOREIGN KEY (`fk_produto`) REFERENCES `tbl_produto` (`id_Produto`),
  ADD CONSTRAINT `venda_produto_ibfk_2` FOREIGN KEY (`fk_vendas`) REFERENCES `vendas` (`id_vendas`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
