ALTER TABLE dbo.Jogo ADD Descrição VARCHAR(150) NULL, Selo VARCHAR(10) NULL, Imagem VARCHAR(150), Vídeo VARCHAR(150);

update Jogo set Descrição='Controle sua party por um mundo fictício, composto por florestas, cidades e cavernas.' where Nome='Chrono Trigger';
update Jogo set Descrição='Jogo de Corrida muito legalzinho.' where Nome='Top Gear';
update Jogo set Descrição='Mega Man malandrão vai explodir toda gurizada.' where Nome='Megaman X';
update Jogo set Descrição='Esses robozinhos são muito marotos. Aproveite essa marotice!' where Nome='Super Metroid';
update Jogo set Descrição='Macacos jogando barris em jacarés.' where Nome='Donkey Kong Country';
update Jogo set Descrição='Animais pilotando karts. Desvie dos cascos e bananas.' where Nome='Super Mario Kart';
update Jogo set Descrição='Jogo de luta com pessoas.' where Nome='Super Street Fighter';
update Jogo set Descrição='Jogo de luta com pessoas estranhas.' where Nome='Mortal Kombat 2';
update Jogo set Descrição='Jogo de luta com pessoas bizarras.' where Nome='Killer Instinct';
update Jogo set Descrição='Jogo de luta com pessoas normais.' where Nome='Final Fight';
update Jogo set Descrição='Encanadores chutando cascos de tartarugas voadoras.' where Nome='Super Mario 1';
update Jogo set Descrição='Indianos voando em tapetes.' where Nome='Alladin';
update Jogo set Descrição='Jogo de corrida com músicas fodas!' where Nome like '%Racing%';
update Jogo set Descrição='Elfo loiro tocando ocarina.' where Nome like '%Zelda%';
update Jogo set Descrição='Igual à todos os outros Final Fantasy.' where Nome like '%Fantasy%';
update Jogo set Descrição='Joguinho de Futebol bacana.' where Nome like '%Soccer%';
update Jogo set Descrição='Jogo de arminha tenso!' where Nome like '%Contra%';
update Jogo set Descrição='Jogo de Faroeste massa!' where Nome like '%Sunset%';
update Jogo set Descrição='Cães falantes desbravando um mundo bizarro.' where Nome like '%Goof%';
update Jogo set Descrição='Um rato e um pato com roupas legais.' where Nome like '%Donald%';

update Jogo set Selo = case when Preco > 50 then 'Gold'
							when Preco > 25 or Preco < 50 then 'Silver'
							when Preco < 25 then 'Bronze'
							END;