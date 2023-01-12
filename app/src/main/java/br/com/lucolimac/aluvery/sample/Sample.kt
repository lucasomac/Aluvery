package br.com.lucolimac.aluvery.sample

import br.com.lucolimac.aluvery.domain.entity.Product
import java.math.BigDecimal


val sampleDrinks = listOf(
    Product(
        "Coca-Cola",
        BigDecimal(5.50),
        "https://cdn.pixabay.com/photo/2014/09/26/19/51/drink-462776_1280.jpg"
    ), Product(
        "Sprite",
        BigDecimal(3.34),
        "https://cdn.pixabay.com/photo/2016/03/07/19/50/sprite-1242896_1280.jpg"
    ), Product(
        "Fanta",
        BigDecimal(4.90),
        "https://cdn.pixabay.com/photo/2013/03/01/18/48/aluminum-87987_1280.jpg"
    ), Product(
        name = "Beer",
        price = BigDecimal("5.99"),
        image = "https://images.pexels.com/photos/1552630/pexels-photo-1552630.jpeg",
    ), Product(
        name = "Juice",
        price = BigDecimal("7.99"),
        image = "https://images.pexels.com/photos/96974/pexels-photo-96974.jpeg"
    ), Product(
        name = "Water",
        price = BigDecimal("2.99"),
        image = "https://images.pexels.com/photos/327090/pexels-photo-327090.jpeg"
    )
)

val sampleCandies = listOf(
    Product(
        "Chocolate",
        BigDecimal(5.50),
        "https://cdn.pixabay.com/photo/2013/09/18/18/24/chocolate-183543_1280.jpg"
    ), Product(
        "Candy",
        BigDecimal(3.34),
        "https://cdn.pixabay.com/photo/2012/06/27/15/02/candy-50838_1280.jpg"
    ), Product(
        "Gummy",
        BigDecimal(4.90),
        "https://cdn.pixabay.com/photo/2015/12/12/14/57/giant-rubber-bear-1089612_1280.jpg"
    ), Product(
        name = "Ice Cream",
        price = BigDecimal("5.99"),
        image = "https://images.pexels.com/photos/1352278/pexels-photo-1352278.jpeg",
    ), Product(
        name = "Cake",
        price = BigDecimal("11.99"),
        image = "https://images.pexels.com/photos/291528/pexels-photo-291528.jpeg",
    ), Product(
        name = "Donut",
        price = BigDecimal("3.99"),
        image = "https://images.pexels.com/photos/291528/pexels-photo-291528.jpeg",
    )
)

val sampleProducts = listOf(
    Product(
        "Hamburger",
        BigDecimal(14.50),
        "https://cdn.pixabay.com/photo/2016/03/05/19/02/hamburger-1238246_1280.jpg"
    ), Product(
        "Pizza",
        BigDecimal(59.34),
        "https://cdn.pixabay.com/photo/2017/09/30/15/10/plate-2802332_1280.jpg"
    ), Product(
        "Fries",
        BigDecimal(39.90),
        "https://cdn.pixabay.com/photo/2016/11/20/09/06/bowl-1842294_1280.jpg"
    ), *sampleDrinks.toTypedArray(), *sampleCandies.toTypedArray()
)

val sampleSections = mapOf(
    "Promoções" to sampleProducts, "Doces" to sampleCandies, "Bebidas" to sampleDrinks
)