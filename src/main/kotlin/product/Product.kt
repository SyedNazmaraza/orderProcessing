package product

import java.lang.IllegalArgumentException
import java.util.UUID
import java.util.UUID.randomUUID


class Product (id:Int,name:String,price:Double,quantity:Int){
    var id:Int = id

    var name:String = name
        get() {return field.lowercase()}
        set(value) {if(value.contains("[0-9]".toRegex())) throw IllegalArgumentException("name should not contain numbers") else field=value}
    var price:Double = price
    var quantity:Int = quantity
        set(value) {if(value in 1..10) throw IllegalArgumentException("Quantity Should be greater than 0 less Than 10") else
            field=value}
}