/*
1)Selecione o nome do empregado e nome do departamento que cada um está associado.
*/

Select Empregado.NomeEmpregado,
       Departamento.NomeDepartamento
From   Empregado 
  inner join Departamento 
 on Empregado.IDDepartamento = Departamento.IDDepartamento

  -- poderia ser tanto INNER quanto LEFT




/*
2)Exibir o nome do associado e sua cidade, exibir também associados sem Cidade relacionada.
*/


Select Associado.Nome as Nome_Associado,
       Cidade.Nome    as Nome_Cidade,
	   Cidade.UF
From   Associado
   left join Cidade on Associado.IDCidade = Cidade.IDCidade

------------------------------------------------------------------
begin transaction
go

-- testando o uso do replace para validar a expressão
select idcidade, Nome, replace(Nome, '*', '')  Novo_Nome
From   Cidade;

-- removendo o "*" do início dos nomes 
update Cidade
set    Nome = replace(Nome, '*', '')  
where  Nome like '*%'

commit



/*
3)Lista os estados (UF) e total de cidades que não possuem associados relacionados 
(dica: pode ser utilizado count + group by + exists).
*/

Select c.UF, COUNT(1) as Total_Cidades
From   Cidade c
Where  NOT EXISTS (Select 1
                   From   Associado
				   Where  Associado.IDCidade = C.IDCidade)
Group  by c.UF




/*
4)Faça uma consulta que liste o nome do associado, o nome da cidade, 
  e uma coluna que indique se a cidade é da região SUL (RS, SC, PR), 
  se for imprimir *** (3 asteriscos), senão imprimir nulo.
*/

-- Criando uma view
create view vw_Cidade_Regiao as 
Select a.Nome as Nome_Associado,
       c.Nome as Nome_Cidade,
	   c.UF,
	   Case When c.UF in ('RS', 'SC', 'PR') then '***'
	        else null
	   End as Regiao_Sul
From   Associado a 
  left join Cidade c on c.IDCidade = a.IDCidade;

-- utilizando a view
select * from vw_Cidade_Regiao;


SELECT * 
FROM (  Select a.Nome as Nome_Associado,
			   c.Nome as Nome_Cidade,
			   c.UF,
			   Case When c.UF in ('RS', 'SC', 'PR') then '***'
					else null
			   End as Regiao_Sul
		From   Associado a 
		  left join Cidade c on c.IDCidade = a.IDCidade) as CONSULTA




-----------------------------------------------------------------------------------------------
-- 5)
Select emp.NomeEmpregado,
       dep.NomeDepartamento  as Departamento_Empregado,
       gerente.NomeEmpregado as NomeGerente,
       dep_g.NomeDepartamento as Departamento_Gerente
From   Empregado emp
  Inner join Empregado gerente  on Emp.IDGerente = gerente.IDEmpregado
  Inner join Departamento dep   on Emp.IDDepartamento = dep.IDDepartamento
  Left  join Departamento dep_g on dep_g.IDDepartamento = gerente.IDDepartamento


-----------------------------------------------------------------------------------------------  
-- 6)
-- criando uma cópia da tabela empregado
Select *
Into   EmpregadoCopia
From   Empregado
go

-- iniciando a transacao
Begin Transaction
go

-- alterando o salario de todos os empregados que 
-- existam em departamentos de SAO PAULO
Update Empregado
Set    Salario = Salario* 1.145
Where  EXISTS (Select 1
               From   Departamento dep
               Where  dep.IDDepartamento = Empregado.IDDepartamento
               and    dep.Localizacao    = 'Sao Paulo')

-- VERIFIQUE O RESULTADO E ESCOLHA UMA OPCAO ABAIXO:
--Rollback transaction
--Commit transaction

-----------------------------------------------------------------------------------------------
-- 7)
-- exibindo o total da coluna salario das 2 tabelas:
Select 'Salario ANTES' as Descricao,
       SUM(Salario)    as SalarioTotal
From   EmpregadoCopia
UNION all   
Select 'Salario DEPOIS' as Descricao,
       SUM(Salario)    as SalarioTotal
From   Empregado

-- UMA OPCAO PARA EXIBIR A DIFERENÇA É COMPARAR AS TABELAS ANTES E DEPOIS DA ALTERACAO
Select SUM(Empregado.Salario) - 
       SUM(EmpregadoCopia.Salario) as Diferenca
From   EmpregadoCopia
 INNER JOIN Empregado on Empregado.IDEmpregado = EmpregadoCopia.IDEmpregado
 
 
 -----------------------------------------------------------------------------------------------
 -- 8)
 -- 
   Select IDDepartamento, NomeDepartamento
 From   Departamento dep
 Where  EXISTS (Select IDDepartamento
                From   Empregado emp
                Where  emp.IDDepartamento = dep.IDDepartamento
                and    Salario = (Select MAX(Salario)
                                  From   Empregado
                                  Where  IDDepartamento is not null)
                )

-----------------------------------------------------------------------------------------------
-- 9)
-- 
 Select assoc.Nome,
        cid.Nome as NomeCidade
 From   Associado assoc
   Inner join Cidade cid on assoc.IDCidade = cid.IDCidade
 UNION
 Select emp.NomeEmpregado as Nome,
        dep.Localizacao as NomeCidade
 From   Empregado emp
   inner join Departamento dep on emp.IDDepartamento = dep.IDDepartamento


-----------------------------------------------------------------------------------------------
-- 10)
-- 
Select Nome
From   Cidade
Where  exists (Select 1
               From   Associado assoc
               Where  assoc.IDCidade = Cidade.IDCidade)
			   