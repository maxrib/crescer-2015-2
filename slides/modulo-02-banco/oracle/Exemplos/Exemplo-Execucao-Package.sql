/* EXEMPLO DE CHAMADA AO PACOTE CRIADO ANTERIORMENTE 
   --
   Pode ser utilizado a janela "Test Window" no PL/SQL Developer */
 begin
  pck_cwi.saudacao;
  dbms_output.put_line('A package foi executada nesta sessão (banco): '|| pck_cwi.Contador || ' vez(es)!');
end;
