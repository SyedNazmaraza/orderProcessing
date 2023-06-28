package customer

import order.Order
import order.OrderProcessor
import java.lang.IllegalArgumentException

class Customer(id:Int,name:String){

    var id:Int =id

    var name:String=name
        get() {return field.lowercase()}
        set(value) {if(value.contains("[0-9]".toRegex())) throw IllegalArgumentException("name should not contain numbers") else field=value}

    private var orders = mutableListOf<Order>()

    fun placeOrder(order: Order){
        orders.add(order)
        OrderProcessor().processOrders()
    }
    fun cancelOrder(order: Order){
        orders.remove(order)
    }
    fun getTotalOrderCount():Int =orders.size

    fun getTotalSpentAmount():Double = orders.map { it.calculateTotalPrice() }.sum()

}