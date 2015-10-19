/*************************************
 * Exercícios de SQL (SQL Server)
 **************************************/
-- 1) 
select substring(nome, 0, CHARINDEX(' ', nome)) as primeiro_nome, 
       CHARINDEX(' ', nome) primeiro_espaco,
       nome 
from associado

-- 2) 
Select idassociado, 
       nome, 
	   DataNascimento, 
	   DATEDIFF(Year, DataNascimento, getdate()) Idade -- arredondamento 
from   Associado

-- 3
Select IDEmpregado, 
       NomeEmpregado, 
	   DataAdmissao,
	   DATEDIFF(Month, DataAdmissao, CONVERT(DateTime, '31/12/2000', 103) ) as Meses_Trabalho
From   Empregado
Where  DataAdmissao between CONVERT(DateTime, '01/05/1980', 103)
                        and CONVERT(DateTime, '20/01/1982', 103);

-- 4 
Select top 1 WITH TIES 
       Cargo, 
       COUNT(1) as Total_Empregados
from   Empregado
group  by Cargo
order  by Total_Empregados desc;

select idempregado, cargo from empregado
------------------------------------------------------------
-- apoio para testar critério de empate com TOP (with ties)
begin transaction
go

update empregado 
set    cargo = 'Vendedor'
where  idempregado = 7566
go

rollback
---------------------------------------------------------------

-- 5
Select top 1
       LEN(Nome) as numero_caracteres, 
       nome
from   Associado
Order by numero_caracteres desc
------------------------------------------------------------
-- alternativa utilizando do MAX()
Select nome
from   Associado
where  LEN(Nome) = (select max(len(nome)) from associado);
