type table ATable{
    product: text;
    price: integer;
    discount: integer;
    finalPrice: real := price * (1 - (discount / 100))
}

t: ATable;
t := new;

t -> "Preço final do produto com desconto"
t.product -> "Produto"
t.price -> "Preço"
t.discount -> "Desconto"
t.finalPrice -> "Preço final"

["Sabão", 6.99, 5] >> t
["Desodorisante", 12.99, 8] >> t
["Shampoo", 13, 5] >> t
["caderno", 4.99, 2.5] >> t

println t;