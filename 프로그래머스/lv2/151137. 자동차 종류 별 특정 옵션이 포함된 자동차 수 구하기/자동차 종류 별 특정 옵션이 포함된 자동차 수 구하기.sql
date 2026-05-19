select CAR_TYPE, count(CAR_TYPE) as CARS
from CAR_RENTAL_COMPANY_CAR
where OPTIONS REGEXP '통풍시트|열선시트|가죽시트'
group by CAR_TYPE
order by CAR_TYPE;