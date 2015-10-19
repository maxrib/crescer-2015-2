create or replace trigger TR_SQ_CLIENTE
 before insert                    -- antes de inserir
 on CLIENTE      
 for each row                     -- para cada registro do INSERT 
   when (new.IDCLIENTE is null)   -- quando o campo IDCLIENTE não for informado
Begin
 
 Select SQCLIENTE.nextval         -- seleciona o próximo valor da sequencia
 into :new.IDCLIENTE              -- atribui o valor para a coluna "IDCliente" 
 from dual;                       -- "dual" é uma tabela virtual, obrigatória para uso de select
 
End TR_SQ_CLIENTE;