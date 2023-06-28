package order

import product.Product
import java.lang.IllegalArgumentException

class Order (id:Int){
    var id :Int = id
    var products = mutableMapOf<Product,Int>()

    fun addProducts(product: Product, quantity:Int){
        if (product.quantity <= quantity){
            products[product] = quantity
        }
        else{
            throw IllegalArgumentException("Given Product Have only ${product.quantity} no of Quantities")
        }
    }
    fun removeProduct(product: Product){
        if(products.containsKey(product)){
            products.remove(product)
        }
        else{
            throw IllegalArgumentException("Given Product Not There In List")
        }
    }
    fun calculateTotalPrice():Double = products.map { it.key.price }.sum()

    fun printOrderDetails(){
        println("Your order details")
        products.forEach{ println(it) }
    }

}