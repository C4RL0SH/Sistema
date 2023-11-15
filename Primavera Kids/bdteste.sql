-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 10/11/2023 às 21:12
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
(1, 'Carlos Henrique dos Santos Frederico', '730.755.310-46', 'carloshenrique@gmail.com', '(88) 98628-5279', '25223-600', 'Rua Maripa, Jardim Primavera', 'Duque de Caxias', 'Rio de Janeiro (RJ)', 'Masculino');

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
(2, 'Davi Costa de Oliveira', '414.165.425-74', 'davicosta@gmail.com', '2005-04-19', 'Masculino', '(16)54651-5646', '(54)64651-5615', '25223-600', 'Rua Maripa', 'Duque de Caxias', 'Rio de Janeiro (RJ)', 'Gerente', 'Tarde', 2000, 'Ativo', 'Davi Costa', '12345'),
(3, 'Gabriel de Andrade dos Santos', '321.654.560-23', 'gabrielandrade@gmail.com', '2004-11-23', 'Masculino', '(15)71231-6547', '(24)71646-5462', '25265-008', 'Rua da Jaqueira, Jardim Primavera', 'Duque de Caxias', 'Rio de Janeiro (RJ)', 'Estoquista', 'Manhã', 1500, 'Ativo', 'Gabriel de Andrade', 'biel'),
(4, 'Maria Eduarda da Silva Pinheiro', '465.165.135-12', 'dudamaria@gmail.com', '2000-06-08', 'Feminino', '(14)11113-3265', '(23)75241-4545', '25223-075', 'Rua Sagres, Parque Moderno', 'Duque de Caxias', 'Rio de Janeiro (RJ)', 'Caixa', 'Tarde', 1700, 'Ativo', 'Maria Eduarda', 'dudinha'),
(5, 'Carlos Henrique dos Santos', '015.921.400-92', 'carlos@gmail.com', '2005-11-11', 'Masculino', '(83)98076-8744', '(79)98978-0518', '25223-600', 'Rua Maripa, Jardim Primavera', 'Duque de Caxias', 'Rio de Janeiro (RJ)', 'Caixa', 'Manhã', 1233.5, 'Demitido', 'Carlos Henrique', 'carlos');

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
  `prod_PrecCompra` double DEFAULT NULL,
  `prod_Desconto` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `tbl_produto`
--

INSERT INTO `tbl_produto` (`id_Produto`, `prod_Nome`, `prod_NomeFornec`, `prod_DataRegistro`, `prod_Categoria`, `prod_Quantidade`, `prod_Tamanho`, `prod_Preco`, `prod_PrecCompra`, `prod_Desconto`) VALUES
(2, 'Camisa Nike Plus', 'Nike', '2023-11-09', 'Camisetas', 50, 'G', 10.99, 15.99, 0);

-- --------------------------------------------------------

--
-- Estrutura para tabela `vendas`
--

CREATE TABLE `vendas` (
  `id_vendas` bigint(20) UNSIGNED NOT NULL,
  `fk_cliente` bigint(20) UNSIGNED NOT NULL,
  `ven_data` date NOT NULL,
  `ven_valor_liquido` double NOT NULL,
  `ven_valor_bruto` double NOT NULL,
  `ven_desconto` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

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
  ADD KEY `fkcliente` (`fk_cliente`);

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
  MODIFY `id_clien` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de tabela `tbl_funcionario`
--
ALTER TABLE `tbl_funcionario`
  MODIFY `id_func` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de tabela `tbl_produto`
--
ALTER TABLE `tbl_produto`
  MODIFY `id_Produto` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de tabela `vendas`
--
ALTER TABLE `vendas`
  MODIFY `id_vendas` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `venda_produto`
--
ALTER TABLE `venda_produto`
  MODIFY `id_ven_produto` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- Restrições para tabelas despejadas
--

--
-- Restrições para tabelas `vendas`
--
ALTER TABLE `vendas`
  ADD CONSTRAINT `vendas_ibfk_1` FOREIGN KEY (`fk_cliente`) REFERENCES `tbl_cliente` (`id_clien`);

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
