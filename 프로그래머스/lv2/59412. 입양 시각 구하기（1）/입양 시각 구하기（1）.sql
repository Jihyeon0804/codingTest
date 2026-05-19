select date_format(DATETIME, '%H')/1 as HOUR, count(1) as COUNT
from ANIMAL_OUTS 
group by HOUR
having HOUR between 9 and 19
order by HOUR;