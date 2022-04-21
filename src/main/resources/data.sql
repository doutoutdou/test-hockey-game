insert into player(number, name, lastname, position)
values (31, 'Carey', 'Price', 'goaltender'),
       (14, 'Nick', 'Suzuki', 'forward'),
       (15, 'Jesperi', 'Kotkaniemi', 'forward'),
       (27, 'Alexander', 'Romanov', 'defenseman'),
       (71, 'Jake', 'Evans', 'forward'),
       (6, 'Shea', 'Weber', 'defenseman'),
       (9, 'Cole', 'Caufield', 'defenseman'),
       (46, 'Jonathan', 'Drouin', 'forward'),
       (93, 'Cayden', 'Primeau', 'goaltender');

insert into team(coach, year, captain)
select 'Dominique Ducharme', 2019, pl.id
from player as pl
where pl.number = 14;

insert into team(coach, year, captain)
select 'Dominique Ducharme', 2020, pl.id
from player as pl
where pl.number = 14;

insert into team(coach, year, captain)
select 'Kent Hughes', 2021, pl.id
from player as pl
where pl.number = 6;

insert into team(coach, year, captain)
select 'Martin St-Louis', 2022, pl.id
from player as pl
where pl.number = 46;


-- Team 2019
insert into teams_players(team_id, player_id)
select t.id, pl.id
from team as t, player as pl
where t.year = 2019 and pl.number = 31;

insert into teams_players(team_id, player_id)
select t.id, pl.id
from team as t, player as pl
where t.year = 2019 and pl.number = 14;

insert into teams_players(team_id, player_id)
select t.id, pl.id
from team as t, player as pl
where t.year = 2019 and pl.number = 15;

insert into teams_players(team_id, player_id)
select t.id, pl.id
from team as t, player as pl
where t.year = 2019 and pl.number = 27;

-- Team 2020
insert into teams_players(team_id, player_id)
select t.id, pl.id
from team as t, player as pl
where t.year = 2020 and pl.number = 31;

insert into teams_players(team_id, player_id)
select t.id, pl.id
from team as t, player as pl
where t.year = 2020 and pl.number = 14;

insert into teams_players(team_id, player_id)
select t.id, pl.id
from team as t, player as pl
where t.year = 2020 and pl.number = 71;

insert into teams_players(team_id, player_id)
select t.id, pl.id
from team as t, player as pl
where t.year = 2020 and pl.number = 6;

-- Team 2021
insert into teams_players(team_id, player_id)
select t.id, pl.id
from team as t, player as pl
where t.year = 2021 and pl.number = 93;

insert into teams_players(team_id, player_id)
select t.id, pl.id
from team as t, player as pl
where t.year = 2021 and pl.number = 14;

insert into teams_players(team_id, player_id)
select t.id, pl.id
from team as t, player as pl
where t.year = 2021 and pl.number = 71;

insert into teams_players(team_id, player_id)
select t.id, pl.id
from team as t, player as pl
where t.year = 2021 and pl.number = 6;

-- Team 2022
insert into teams_players(team_id, player_id)
select t.id, pl.id
from team as t, player as pl
where t.year = 2022 and pl.number = 93;

insert into teams_players(team_id, player_id)
select t.id, pl.id
from team as t, player as pl
where t.year = 2022 and pl.number = 14;

insert into teams_players(team_id, player_id)
select t.id, pl.id
from team as t, player as pl
where t.year = 2022 and pl.number = 46;

insert into teams_players(team_id, player_id)
select t.id, pl.id
from team as t, player as pl
where t.year = 2022 and pl.number = 9;


