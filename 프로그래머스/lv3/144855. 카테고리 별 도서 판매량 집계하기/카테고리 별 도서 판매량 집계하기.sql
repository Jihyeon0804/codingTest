select b.CATEGORY, sum(s.SALES) as TOTAL_SALES 
from BOOK b
inner join BOOK_SALES s
on b.BOOK_ID = s.BOOK_ID
where date_format(s.SALES_DATE, '%Y-%m') = '2022-01'
group by b.CATEGORY
order by b.CATEGORY;