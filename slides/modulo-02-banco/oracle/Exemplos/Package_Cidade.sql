create or replace package pck_cidade is

  -- Author  : Andre Nunes
  -- Purpose : controlar cadastro de cidades
  
  -- Public declarations
  function busca_cidade (pNome in varchar2,
                         pUF   in varchar2) return integer;
  
end pck_cidade;
/

create or replace package body pck_cidade is

  -- Private type declarations
  ------------------------------------------------------------------------------------------------  
  /* retorna o ID da cidade */
  function busca_idcidade (pNome in varchar2,
                           pUF   in varchar2) return integer as
    v_idcidade integer;
  begin
    
    select idcidade
    into   v_idcidade 
    from   cidade
    where  lower(nome) = lower(pNome)   -- utiliza a versão, pois o oracle é case sensitive
    and    lower(uf)   = lower(pUF);
    
    return v_idcidade;
    
  exception
     when no_data_found then -- caso não encontre a cidade
        return -1;
  end;                          
  ------------------------------------------------------------------------------------------------
  procedure cria_cidade (pNome in varchar2,
                         pUF   in varchar2,
                         pIDCidade out integer) as
     -- Não é permitido o uso de operacoes Insert, Update e Delete dentro de funções
     -- Para evitar o erro é preciso criar uma transação autônoma e utilizar do commit 
     pragma autonomous_transaction;
  begin
     
     insert into Cidade
        (nome, uf)
     values
        (initcap(pNome),
         upper(pUF) )
      returning IDCidade into pIDCidade; -- irá retornar o IDCidade gerado conforme sequence/trigger

      -- confirma a transação autônoma
      commit; 
      
  end cria_cidade;
  ------------------------------------------------------------------------------------------------
  function busca_cidade (pNome in varchar2,
                         pUF   in varchar2) return integer as
      v_idcidade integer;
  begin

      v_idcidade := busca_idcidade(pNome, pUF);

      -- caso a cidade não exista
      if v_idcidade = -1 then
        cria_cidade(pNome, pUF, v_idcidade); -- procedure com parametro OUT
      end if;
      
      return v_idcidade;
  end busca_cidade;
  
begin
  -- Initialization
  null;
end pck_cidade;
/
