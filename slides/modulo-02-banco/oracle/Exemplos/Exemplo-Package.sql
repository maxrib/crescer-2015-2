/* CRIAÇÃO DA ESPECIFICAÇÃO DA PACKAGE "PCK_CWI"  */
create or replace package pck_cwi as
  Contador int;
  procedure saudacao;
  procedure publico;
end;
/

/* CRIAÇÃO DO CORPO DA PACKAGE "PCK_CWI"  */
create or replace package body pck_cwi as
  procedure saudacao is
    begin
      publico;
      contador := contador + 1;
    end saudacao;
  ---------------------------------------------------------------------------------
  procedure privado (pValor in number) is
    begin
      dbms_output.put_line('Tipo número: '|| to_char(pValor));
    end privado;
  ---------------------------------------------------------------------------------
  procedure privado (pValor in date) is
    begin
      dbms_output.put_line('Tipo data: '|| to_char(pValor, 'dd-mm-yyyy hh24:mi:ss'));
    end privado;
  ---------------------------------------------------------------------------------
  procedure privado (pValor in varchar2) is
    begin
      dbms_output.put_line('Tipo caractere: '|| pValor);
    end privado;
  ---------------------------------------------------------------------------------
  procedure publico is
    begin
      privado(pValor=>'Tchê, mas que barbaridade!!!');
      privado(pValor=>123456789);
      privado(pValor=>sysdate);
    end publico;

--	INICIALIZAÇÃO DA PACKAGE (OPCIONAL) 
begin
    contador := 0; -- Inicializa contador
	dbms_output.enable;
end;
/


