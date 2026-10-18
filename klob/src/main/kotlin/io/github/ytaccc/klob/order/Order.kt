package io.github.ytaccc.klob.order

sealed class Order(val id: Long, val side: Side, quantity: Long) {
    var quantity: Long = quantity
        private set(value) {
            require(value >= 0) { "Quantity must be greater than or equal to 0" }
            require(value < field) { "Quantity can only decrease" }
            field = value
        }

    init {
        require(id > 0) { "Id must be greater than 0" }
        require(quantity > 0) { "Quantity must be greater than 0" }
    }

    fun fill(amount: Long) {
        require(amount > 0) { "Amount must be greater than 0" }
        require(amount <= quantity) { "Amount must be less than or equal to quantity" }
        quantity -= amount
    }
}

class LimitOrder(id: Long, side: Side, quantity: Long, val price: Long) : Order(id, side, quantity) {
    init {
        require(price > 0) { "Price must be greater than 0" }
    }
}
class MarketOrder(id: Long, side: Side, quantity: Long) : Order(id, side, quantity)

enum class Side {
    BUY,
    SELL,
}
