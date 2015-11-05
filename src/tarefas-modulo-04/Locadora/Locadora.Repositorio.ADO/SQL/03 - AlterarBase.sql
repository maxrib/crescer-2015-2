ALTER TABLE dbo.Jogo ADD Descri��o VARCHAR(150) NULL, Selo VARCHAR(10) NULL, Imagem VARCHAR(150), V�deo VARCHAR(150);

update Jogo set Descri��o='Controle sua party por um mundo fict�cio, composto por florestas, cidades e cavernas.' where Nome='Chrono Trigger';
update Jogo set Descri��o='Jogo de Corrida muito legalzinho.' where Nome='Top Gear';
update Jogo set Descri��o='Mega Man malandr�o vai explodir toda gurizada.' where Nome='Megaman X';
update Jogo set Descri��o='Esses robozinhos s�o muito marotos. Aproveite essa marotice!' where Nome='Super Metroid';
update Jogo set Descri��o='Macacos jogando barris em jacar�s.' where Nome='Donkey Kong Country';
update Jogo set Descri��o='Animais pilotando karts. Desvie dos cascos e bananas.' where Nome='Super Mario Kart';
update Jogo set Descri��o='Jogo de luta com pessoas.' where Nome='Super Street Fighter';
update Jogo set Descri��o='Jogo de luta com pessoas estranhas.' where Nome='Mortal Kombat 2';
update Jogo set Descri��o='Jogo de luta com pessoas bizarras.' where Nome='Killer Instinct';
update Jogo set Descri��o='Jogo de luta com pessoas normais.' where Nome='Final Fight';
update Jogo set Descri��o='Encanadores chutando cascos de tartarugas voadoras.' where Nome='Super Mario 1';
update Jogo set Descri��o='Indianos voando em tapetes.' where Nome='Alladin';
update Jogo set Descri��o='Jogo de corrida com m�sicas fodas!' where Nome like '%Racing%';
update Jogo set Descri��o='Elfo loiro tocando ocarina.' where Nome like '%Zelda%';
update Jogo set Descri��o='Igual � todos os outros Final Fantasy.' where Nome like '%Fantasy%';
update Jogo set Descri��o='Joguinho de Futebol bacana.' where Nome like '%Soccer%';
update Jogo set Descri��o='Jogo de arminha tenso!' where Nome like '%Contra%';
update Jogo set Descri��o='Jogo de Faroeste massa!' where Nome like '%Sunset%';
update Jogo set Descri��o='C�es falantes desbravando um mundo bizarro.' where Nome like '%Goof%';
update Jogo set Descri��o='Um rato e um pato com roupas legais.' where Nome like '%Donald%';

update Jogo set Selo = case when Preco > 50 then 'Gold'
							when Preco > 25 or Preco < 50 then 'Silver'
							when Preco < 25 then 'Bronze'
							END;