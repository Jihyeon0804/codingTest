select `CART_ID`
from `cart_products`
where `NAME` in ('milk', 'yogurt')
group by `CART_ID`
having count(DISTINCT `NAME`)= 2;