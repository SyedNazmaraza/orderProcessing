import customer.Customer
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import order.Order
import product.Product


fun main() {


    var product1=Product(1,"Shampoo",200.02,10)
    var product2=Product(2,"FaceWash",120.02,12)
    var product3=Product(3,"Soap",90.0,15)
    var product4=Product(4,"Cream",300.04,20)
    var product5=Product(5,"oil",40.25,12)
    var product6=Product(6,"powder",50.82,16)
    var listOfProducts = arrayListOf<Product>(product1,product2,product3,product4,product5,product6)

    var customer = Customer(1,"Arjun")

    var order = Order(1)
    customer.placeOrder(order)

}

fun start(){
    println("Select The Options: ")
    println("1)See The Orders List")
    println("2)Place The Order")
    println("3)Cancel The Order")

}

fun getMostExpensiveProduct(products: List<Product>): Product? {
    return if(products.isEmpty()) null
    else{
        var product :Product = products[0]
        products.forEach{ if(it.price>product.price) product=it  }
        product
    }

}

fun <T> Iterable<T>.getOrdersByCustomer(lam: (T) -> Boolean):List<T>{
    var l = ArrayList<T>()
    for( i in this){
        if(lam(i)){
            l.add(i)
        }
    }
    return l
}

fun processOrdersAsync(orders: List<Order>){
    for(i in orders){
        GlobalScope.async {
            delay(2000)
            println(i.printOrderDetails())
        }
    }
}


