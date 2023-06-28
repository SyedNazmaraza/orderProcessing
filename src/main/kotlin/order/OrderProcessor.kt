package order

import order.Order

class OrderProcessor {
    private var orders = mutableListOf<Order>()

    fun processOrders(){
        orders.forEach { println(it.printOrderDetails()) }

        for( i in orders){
            for(j in i.products){
                j.key.quantity-=j.value
            }
        }

    }
}